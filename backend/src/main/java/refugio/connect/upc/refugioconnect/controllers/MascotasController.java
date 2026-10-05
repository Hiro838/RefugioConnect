package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.MascotasDTO;
import refugio.connect.upc.refugioconnect.entities.Mascotas;
import refugio.connect.upc.refugioconnect.entities.Razas;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IMascotasService;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IRazasService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotasController {

    private final IMascotasService mascotasService;
    private final IRazasService razasService;
    private final ModelMapper modelMapper;

    public MascotasController(IMascotasService mascotasService, IRazasService razasService,
                              ModelMapper modelMapper) {
        this.mascotasService = mascotasService;
        this.razasService = razasService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<MascotasDTO>> listar() {
        return ResponseEntity.ok(mascotasService.list().stream()
                .map(this::toDto)
                .toList());
    }

    @PostMapping
    public ResponseEntity<MascotasDTO> registrar(@Valid @RequestBody MascotasDTO dto) {
        Mascotas mascota = modelMapper.map(dto, Mascotas.class);
        mascota.setRaza(obtenerRaza(dto.getIdRaza()));
        mascotasService.insert(mascota);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mascota.getIdMascotas())
                .toUri();
        return ResponseEntity.created(location).body(toDto(mascota));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotasDTO> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(toDto(obtenerMascota(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotasDTO> actualizar(@PathVariable Long id,
                                                   @Valid @RequestBody MascotasDTO dto) {
        Mascotas mascota = obtenerMascota(id);
        modelMapper.map(dto, mascota);
        mascota.setIdMascotas(id);
        mascota.setRaza(obtenerRaza(dto.getIdRaza()));
        mascotasService.insert(mascota);
        return ResponseEntity.ok(toDto(mascota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        obtenerMascota(id);
        mascotasService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Mascotas obtenerMascota(Long id) {
        return mascotasService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No existe la mascota con ID: " + id));
    }

    private Razas obtenerRaza(Long id) {
        return razasService.listId(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No existe la raza con ID: " + id));
    }

    private MascotasDTO toDto(Mascotas mascota) {
        MascotasDTO dto = modelMapper.map(mascota, MascotasDTO.class);
        if (mascota.getRaza() != null) {
            dto.setIdRaza(mascota.getRaza().getIdRaza());
        }
        return dto;
    }
}
