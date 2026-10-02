package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.SeguimientoAdopcionDTO;
import refugio.connect.upc.refugioconnect.entities.SeguimientoAdopcion;
import refugio.connect.upc.refugioconnect.entities.SolicitudAdopcion;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ISeguimientoAdopcionService;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ISolicitudAdopcionService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/seguimientos-adopcion")
public class SeguimientoAdopcionController {

    private final ISeguimientoAdopcionService sS;
    private final ISolicitudAdopcionService solicitudService;

    public SeguimientoAdopcionController(
            ISeguimientoAdopcionService sS,
            ISolicitudAdopcionService solicitudService) {

        this.sS = sS;
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public ResponseEntity<List<SeguimientoAdopcionDTO>> listar() {

        List<SeguimientoAdopcionDTO> lista = sS.list()
                .stream()
                .map(this::convertirDTO)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/resumen-por-estado")
    public ResponseEntity<List<Object[]>> resumenPorEstado() {
        return ResponseEntity.ok(sS.countByEstadoMascota());
    }

    @PostMapping
    public ResponseEntity<SeguimientoAdopcionDTO> registrar(
            @Valid @RequestBody SeguimientoAdopcionDTO dto) {

        SolicitudAdopcion solicitud = solicitudService
                .listId(dto.getIdSolicitud())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la solicitud de adopción con ID: "
                                        + dto.getIdSolicitud()
                        ));

        SeguimientoAdopcion seguimiento = new SeguimientoAdopcion();

        seguimiento.setSolicitudAdopcion(solicitud);
        seguimiento.setIdVoluntarioAsignado(dto.getIdVoluntarioAsignado());
        seguimiento.setFechaContacto(dto.getFechaContacto());
        seguimiento.setEstadoMascota(dto.getEstadoMascota());
        seguimiento.setObservaciones(dto.getObservaciones());

        sS.insert(seguimiento);

        SeguimientoAdopcionDTO responseDTO =
                convertirDTO(seguimiento);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(seguimiento.getIdSeguimiento())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguimientoAdopcionDTO> buscarId(
            @PathVariable Long id) {

        SeguimientoAdopcion seguimiento = sS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el seguimiento de adopción con ID: " + id
                        ));

        return ResponseEntity.ok(convertirDTO(seguimiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguimientoAdopcionDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody SeguimientoAdopcionDTO dto) {

        SeguimientoAdopcion seguimiento = sS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el seguimiento de adopción con ID: " + id
                        ));

        SolicitudAdopcion solicitud = solicitudService
                .listId(dto.getIdSolicitud())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la solicitud de adopción con ID: "
                                        + dto.getIdSolicitud()
                        ));

        seguimiento.setSolicitudAdopcion(solicitud);
        seguimiento.setIdVoluntarioAsignado(dto.getIdVoluntarioAsignado());
        seguimiento.setFechaContacto(dto.getFechaContacto());
        seguimiento.setEstadoMascota(dto.getEstadoMascota());
        seguimiento.setObservaciones(dto.getObservaciones());

        sS.insert(seguimiento);

        return ResponseEntity.ok(convertirDTO(seguimiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        SeguimientoAdopcion seguimiento = sS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el seguimiento de adopción con ID: " + id
                        ));

        sS.delete(seguimiento.getIdSeguimiento());

        return ResponseEntity.noContent().build();
    }

    private SeguimientoAdopcionDTO convertirDTO(
            SeguimientoAdopcion seguimiento) {

        SeguimientoAdopcionDTO dto = new SeguimientoAdopcionDTO();

        dto.setIdSeguimiento(seguimiento.getIdSeguimiento());

        if (seguimiento.getSolicitudAdopcion() != null) {
            dto.setIdSolicitud(
                    seguimiento.getSolicitudAdopcion().getIdSolicitud()
            );
        }
        dto.setIdVoluntarioAsignado(
                seguimiento.getIdVoluntarioAsignado()
        );
        dto.setFechaContacto(
                seguimiento.getFechaContacto()
        );
        dto.setEstadoMascota(
                seguimiento.getEstadoMascota()
        );
        dto.setObservaciones(
                seguimiento.getObservaciones()
        );
        return dto;
    }
}