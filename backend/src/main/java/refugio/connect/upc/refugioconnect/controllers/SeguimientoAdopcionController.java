package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.SeguimientoAdopcionDTO;
import refugio.connect.upc.refugioconnect.entities.SeguimientoAdopcion;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ISeguimientoAdopcionService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/seguimientos")
public class SeguimientoAdopcionController {

    private final ISeguimientoAdopcionService seguimientoService;
    private final ModelMapper modelMapper;

    public SeguimientoAdopcionController(ISeguimientoAdopcionService seguimientoService, ModelMapper modelMapper) {
        this.seguimientoService = seguimientoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<SeguimientoAdopcionDTO>> listar() {
        List<SeguimientoAdopcionDTO> lista = seguimientoService.list()
                .stream()
                .map(seguimiento -> modelMapper.map(seguimiento, SeguimientoAdopcionDTO.class))
                .toList();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('VOLUNTARIO')")
    public ResponseEntity<SeguimientoAdopcionDTO> registrar(@Valid @RequestBody SeguimientoAdopcionDTO dto) {
        SeguimientoAdopcion seguimiento = modelMapper.map(dto, SeguimientoAdopcion.class);
        seguimientoService.insert(seguimiento);

        SeguimientoAdopcionDTO responseDTO = modelMapper.map(seguimiento, SeguimientoAdopcionDTO.class);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(seguimiento.getIdSeguimientoAdopcion())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguimientoAdopcionDTO> buscarPorId(@PathVariable Long id) {
        SeguimientoAdopcion seguimiento = seguimientoService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el seguimiento de adopción con el ID: " + id));
        SeguimientoAdopcionDTO dto = modelMapper.map(seguimiento, SeguimientoAdopcionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('VOLUNTARIO')")
    public ResponseEntity<SeguimientoAdopcionDTO> actualizar(@Valid @RequestBody SeguimientoAdopcionDTO dto) {
        SeguimientoAdopcion existente = seguimientoService.listId(dto.getIdSeguimientoAdopcion())
                .orElseThrow(() -> new ResourceNotFoundException("No existe el seguimiento de adopción con el ID: " + dto.getIdSeguimientoAdopcion()));

        SeguimientoAdopcion seguimiento = modelMapper.map(dto, SeguimientoAdopcion.class);
        seguimiento.setIdSeguimientoAdopcion(existente.getIdSeguimientoAdopcion());
        seguimientoService.update(seguimiento);

        SeguimientoAdopcionDTO responseDTO = modelMapper.map(seguimiento, SeguimientoAdopcionDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        SeguimientoAdopcion existente = seguimientoService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el seguimiento de adopción con el ID: " + id));
        seguimientoService.delete(existente.getIdSeguimientoAdopcion());
        return ResponseEntity.noContent().build();
    }
}