package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.TurnosVoluntariadosDTO;
import refugio.connect.upc.refugioconnect.entities.TurnosVoluntariados;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ITurnosVoluntariadosService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnosVoluntariadosController {

    private final ITurnosVoluntariadosService turnosService;
    private final ModelMapper modelMapper;

    public TurnosVoluntariadosController(ITurnosVoluntariadosService turnosService, ModelMapper modelMapper) {
        this.turnosService = turnosService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<TurnosVoluntariadosDTO>> listar() {
        List<TurnosVoluntariadosDTO> lista = turnosService.list()
                .stream()
                .map(turno -> modelMapper.map(turno, TurnosVoluntariadosDTO.class))
                .toList();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('VOLUNTARIO')")
    public ResponseEntity<TurnosVoluntariadosDTO> registrar(@Valid @RequestBody TurnosVoluntariadosDTO dto) {
        TurnosVoluntariados turno = modelMapper.map(dto, TurnosVoluntariados.class);
        turnosService.insert(turno);

        TurnosVoluntariadosDTO responseDTO = modelMapper.map(turno, TurnosVoluntariadosDTO.class);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(turno.getIdTurnoVoluntariado())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnosVoluntariadosDTO> buscarPorId(@PathVariable Long id) {
        TurnosVoluntariados turno = turnosService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el turno de voluntariado con el ID: " + id));
        TurnosVoluntariadosDTO dto = modelMapper.map(turno, TurnosVoluntariadosDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('VOLUNTARIO')")
    public ResponseEntity<TurnosVoluntariadosDTO> actualizar(@Valid @RequestBody TurnosVoluntariadosDTO dto) {
        TurnosVoluntariados existente = turnosService.listId(dto.getIdTurnoVoluntariado())
                .orElseThrow(() -> new ResourceNotFoundException("No existe el turno de voluntariado con el ID: " + dto.getIdTurnoVoluntariado()));

        TurnosVoluntariados turno = modelMapper.map(dto, TurnosVoluntariados.class);
        turno.setIdTurnoVoluntariado(existente.getIdTurnoVoluntariado());
        turnosService.update(turno);

        TurnosVoluntariadosDTO responseDTO = modelMapper.map(turno, TurnosVoluntariadosDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        TurnosVoluntariados existente = turnosService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el turno de voluntariado con el ID: " + id));
        turnosService.delete(existente.getIdTurnoVoluntariado());
        return ResponseEntity.noContent().build();
    }
}