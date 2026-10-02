package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.SolicitudAdopcionDTO;
import refugio.connect.upc.refugioconnect.entities.SolicitudAdopcion;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ISolicitudAdopcionService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudAdopcionController {

    private final ISolicitudAdopcionService solicitudService;
    private final ModelMapper modelMapper;

    public SolicitudAdopcionController(ISolicitudAdopcionService solicitudService, ModelMapper modelMapper) {
        this.solicitudService = solicitudService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<SolicitudAdopcionDTO>> listar() {
        List<SolicitudAdopcionDTO> lista = solicitudService.list()
                .stream()
                .map(solicitud -> modelMapper.map(solicitud, SolicitudAdopcionDTO.class))
                .toList();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<SolicitudAdopcionDTO> registrar(@Valid @RequestBody SolicitudAdopcionDTO dto) {
        SolicitudAdopcion solicitud = modelMapper.map(dto, SolicitudAdopcion.class);
        solicitudService.insert(solicitud);

        SolicitudAdopcionDTO responseDTO = modelMapper.map(solicitud, SolicitudAdopcionDTO.class);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(solicitud.getIdSolicitudAdopcion())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudAdopcionDTO> buscarPorId(@PathVariable Long id) {
        SolicitudAdopcion solicitud = solicitudService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la solicitud de adopción con el ID: " + id));
        SolicitudAdopcionDTO dto = modelMapper.map(solicitud, SolicitudAdopcionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('VOLUNTARIO')")
    public ResponseEntity<SolicitudAdopcionDTO> actualizar(@Valid @RequestBody SolicitudAdopcionDTO dto) {
        SolicitudAdopcion existente = solicitudService.listId(dto.getIdSolicitudAdopcion())
                .orElseThrow(() -> new ResourceNotFoundException("No existe la solicitud de adopción con el ID: " + dto.getIdSolicitudAdopcion()));

        SolicitudAdopcion solicitud = modelMapper.map(dto, SolicitudAdopcion.class);
        solicitud.setIdSolicitudAdopcion(existente.getIdSolicitudAdopcion());
        solicitudService.update(solicitud);

        SolicitudAdopcionDTO responseDTO = modelMapper.map(solicitud, SolicitudAdopcionDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        SolicitudAdopcion existente = solicitudService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la solicitud de adopción con el ID: " + id));
        solicitudService.delete(existente.getIdSolicitudAdopcion());
        return ResponseEntity.noContent().build();
    }
}