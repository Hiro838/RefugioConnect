package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.SolicitudAdopcionDTO;
import refugio.connect.upc.refugioconnect.entities.SolicitudAdopcion;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ISolicitudAdopcionService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes-adopcion")
public class SolicitudAdopcionController {

    private final ISolicitudAdopcionService sS;
    private final ModelMapper modelMapper;

    public SolicitudAdopcionController(ISolicitudAdopcionService sS,
                                       ModelMapper modelMapper) {
        this.sS = sS;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<SolicitudAdopcionDTO>> listar() {

        List<SolicitudAdopcionDTO> lista = sS.list()
                .stream()
                .map(s -> modelMapper.map(s, SolicitudAdopcionDTO.class))
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<SolicitudAdopcionDTO> registrar(
            @Valid @RequestBody SolicitudAdopcionDTO dto) {

        SolicitudAdopcion solicitud =
                modelMapper.map(dto, SolicitudAdopcion.class);

        if (solicitud.getEstadoSolicitud() == null
                || solicitud.getEstadoSolicitud().isBlank()) {
            solicitud.setEstadoSolicitud("Pendiente");
        }

        if (solicitud.getFechaSolicitud() == null) {
            solicitud.setFechaSolicitud(LocalDateTime.now());
        }

        sS.insert(solicitud);

        SolicitudAdopcionDTO responseDTO =
                modelMapper.map(solicitud, SolicitudAdopcionDTO.class);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(solicitud.getIdSolicitud())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudAdopcionDTO> buscarId(
            @PathVariable Long id) {

        SolicitudAdopcion solicitud = sS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la solicitud de adopción con ID: " + id
                        ));

        SolicitudAdopcionDTO responseDTO =
                modelMapper.map(solicitud, SolicitudAdopcionDTO.class);

        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudAdopcionDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody SolicitudAdopcionDTO dto) {

        SolicitudAdopcion solicitud = sS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la solicitud de adopción con ID: " + id
                        ));

        modelMapper.map(dto, solicitud);
        solicitud.setIdSolicitud(id);

        sS.insert(solicitud);

        SolicitudAdopcionDTO responseDTO =
                modelMapper.map(solicitud, SolicitudAdopcionDTO.class);

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        SolicitudAdopcion solicitud = sS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la solicitud de adopción con ID: " + id
                        ));

        sS.delete(solicitud.getIdSolicitud());

        return ResponseEntity.noContent().build();
    }
}