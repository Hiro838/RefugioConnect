package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.DonacionesDTO;
import refugio.connect.upc.refugioconnect.entities.Donaciones;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IDonacionesService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/donaciones")
public class DonacionesController {

    private final IDonacionesService donacionesService;
    private final ModelMapper modelMapper;

    public DonacionesController(IDonacionesService donacionesService, ModelMapper modelMapper) {
        this.donacionesService = donacionesService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<DonacionesDTO>> listar() {
        List<DonacionesDTO> lista = donacionesService.list()
                .stream()
                .map(donacion -> modelMapper.map(donacion, DonacionesDTO.class))
                .toList();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<DonacionesDTO> registrar(@Valid @RequestBody DonacionesDTO dto) {
        Donaciones donacion = modelMapper.map(dto, Donaciones.class);
        donacionesService.insert(donacion);

        DonacionesDTO responseDTO = modelMapper.map(donacion, DonacionesDTO.class);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(donacion.getIdDonacion())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonacionesDTO> buscarPorId(@PathVariable Long id) {
        Donaciones donacion = donacionesService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la donación con el ID: " + id));
        DonacionesDTO dto = modelMapper.map(donacion, DonacionesDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DonacionesDTO> actualizar(@Valid @RequestBody DonacionesDTO dto) {
        Donaciones existente = donacionesService.listId(dto.getIdDonacion())
                .orElseThrow(() -> new ResourceNotFoundException("No existe la donación con el ID: " + dto.getIdDonacion()));

        Donaciones donacion = modelMapper.map(dto, Donaciones.class);
        donacion.setIdDonacion(existente.getIdDonacion());
        donacionesService.update(donacion);

        DonacionesDTO responseDTO = modelMapper.map(donacion, DonacionesDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Donaciones existente = donacionesService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la donación con el ID: " + id));
        donacionesService.delete(existente.getIdDonacion());
        return ResponseEntity.noContent().build();
    }
}