package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.EspecieDTO;
import refugio.connect.upc.refugioconnect.entities.Especie;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IEspecieService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/especies")
public class EspecieController {

    private final IEspecieService eS;
    private final ModelMapper modelMapper;

    public EspecieController(IEspecieService eS, ModelMapper modelMapper) {
        this.eS = eS;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<EspecieDTO>> listar() {
        List<EspecieDTO> lista = eS.list()
                .stream()
                .map(e -> modelMapper.map(e, EspecieDTO.class))
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<EspecieDTO> registrar(@Valid @RequestBody EspecieDTO dto) {
        Especie especie = modelMapper.map(dto, Especie.class);
        eS.insert(especie);

        EspecieDTO responseDTO = modelMapper.map(especie, EspecieDTO.class);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(especie.getIdEspecie())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecieDTO> buscarId(@PathVariable Long id) {
        Especie especie = eS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la especie con ID: " + id
                        ));

        EspecieDTO responseDTO = modelMapper.map(especie, EspecieDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecieDTO> actualizar(@PathVariable Long id, @Valid @RequestBody EspecieDTO dto) {
        Especie especie = eS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la especie con ID: " + id
                        ));

        modelMapper.map(dto, especie);
        especie.setIdEspecie(id);
        eS.insert(especie);

        EspecieDTO responseDTO = modelMapper.map(especie, EspecieDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Especie especie = eS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la especie con ID: " + id
                        ));

        eS.delete(especie.getIdEspecie());
        return ResponseEntity.noContent().build();
    }
}