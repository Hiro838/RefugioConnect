package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.HistorialMedicoDTO;
import refugio.connect.upc.refugioconnect.entities.HistorialMedico;
import refugio.connect.upc.refugioconnect.entities.Mascotas;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IHistorialMedicoService;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IMascotasService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/historial-medico")
public class HistorialMedicoController {

    private final IHistorialMedicoService historialService;
    private final IMascotasService mascotasService;
    private final ModelMapper modelMapper;

    public HistorialMedicoController(IHistorialMedicoService historialService,
                                     IMascotasService mascotasService,
                                     ModelMapper modelMapper) {
        this.historialService = historialService;
        this.mascotasService = mascotasService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<HistorialMedicoDTO>> listar() {
        return ResponseEntity.ok(historialService.list().stream()
                .map(this::toDto)
                .toList());
    }

    @PostMapping
    public ResponseEntity<HistorialMedicoDTO> registrar(
            @Valid @RequestBody HistorialMedicoDTO dto) {
        HistorialMedico historial = modelMapper.map(dto, HistorialMedico.class);
        historial.setMascotas(obtenerMascota(dto.getIdMascotas()));
        historialService.insert(historial);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(historial.getIdHistorialMedico())
                .toUri();
        return ResponseEntity.created(location).body(toDto(historial));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedicoDTO> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(obtenerHistorial(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialMedicoDTO> actualizar(
            @PathVariable Long id, @Valid @RequestBody HistorialMedicoDTO dto) {
        HistorialMedico historial = obtenerHistorial(id);
        modelMapper.map(dto, historial);
        historial.setIdHistorialMedico(id);
        historial.setMascotas(obtenerMascota(dto.getIdMascotas()));
        historialService.insert(historial);
        return ResponseEntity.ok(toDto(historial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        obtenerHistorial(id);
        historialService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private HistorialMedico obtenerHistorial(Long id) {
        return historialService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No existe el historial médico con ID: " + id));
    }

    private Mascotas obtenerMascota(Long id) {
        return mascotasService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No existe la mascota con ID: " + id));
    }

    private HistorialMedicoDTO toDto(HistorialMedico historial) {
        HistorialMedicoDTO dto = modelMapper.map(historial, HistorialMedicoDTO.class);
        if (historial.getMascotas() != null) {
            dto.setIdMascotas(historial.getMascotas().getIdMascotas());
        }
        return dto;
    }
}
