package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.DonacionDTO;
import refugio.connect.upc.refugioconnect.entities.Donacion;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IDonacionService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/donaciones")
public class DonacionController {

    private final IDonacionService dS;
    private final ModelMapper modelMapper;

    public DonacionController(IDonacionService dS, ModelMapper modelMapper) {
        this.dS = dS;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<DonacionDTO>> listar() {

        List<DonacionDTO> lista = dS.list()
                .stream()
                .map(d -> modelMapper.map(d, DonacionDTO.class))
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<DonacionDTO> registrar(
            @Valid @RequestBody DonacionDTO dto) {

        Donacion donacion = modelMapper.map(dto, Donacion.class);

        if (donacion.getFechaDonacion() == null) {
            donacion.setFechaDonacion(LocalDateTime.now());
        }

        dS.insert(donacion);

        DonacionDTO responseDTO =
                modelMapper.map(donacion, DonacionDTO.class);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(donacion.getIdDonacion())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonacionDTO> buscarId(
            @PathVariable Long id) {

        Donacion donacion = dS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la donación con ID: " + id
                        ));

        DonacionDTO responseDTO =
                modelMapper.map(donacion, DonacionDTO.class);

        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonacionDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody DonacionDTO dto) {

        Donacion donacion = dS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la donación con ID: " + id
                        ));

        modelMapper.map(dto, donacion);

        donacion.setIdDonacion(id);

        dS.insert(donacion);

        DonacionDTO responseDTO =
                modelMapper.map(donacion, DonacionDTO.class);

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        Donacion donacion = dS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la donación con ID: " + id
                        ));

        dS.delete(donacion.getIdDonacion());

        return ResponseEntity.noContent().build();
    }
}