package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.RazasDTO;
import refugio.connect.upc.refugioconnect.entities.Especie;
import refugio.connect.upc.refugioconnect.entities.Razas;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IEspecieService;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IRazasService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/razas")
public class RazasController {

    private final IRazasService rS;
    private final IEspecieService eS;
    private final ModelMapper modelMapper;

    public RazasController(IRazasService rS, IEspecieService eS, ModelMapper modelMapper) {
        this.rS = rS;
        this.eS = eS;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<RazasDTO>> listar() {
        List<RazasDTO> lista = rS.list()
                .stream()
                .map(r -> {
                    RazasDTO dto = modelMapper.map(r, RazasDTO.class);
                    // Mapeo manual del ID de especie por si ModelMapper no lo detecta automáticamente
                    if (r.getEspecie() != null) {
                        dto.setIdEspecie(r.getEspecie().getIdEspecie());
                    }
                    return dto;
                })
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<RazasDTO> registrar(@Valid @RequestBody RazasDTO dto) {
        Razas razas = modelMapper.map(dto, Razas.class);

        // Instanciamos la especie solo con su ID para establecer la llave foránea
        razas.setEspecie(obtenerEspecie(dto.getIdEspecie()));

        rS.insert(razas);

        RazasDTO responseDTO = modelMapper.map(razas, RazasDTO.class);
        responseDTO.setIdEspecie(razas.getEspecie().getIdEspecie());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(razas.getIdRaza())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RazasDTO> buscarId(@PathVariable Long id) {
        Razas razas = rS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la raza con ID: " + id
                        ));

        RazasDTO responseDTO = modelMapper.map(razas, RazasDTO.class);
        if (razas.getEspecie() != null) {
            responseDTO.setIdEspecie(razas.getEspecie().getIdEspecie());
        }
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RazasDTO> actualizar(@PathVariable Long id, @Valid @RequestBody RazasDTO dto) {
        Razas razas = rS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la raza con ID: " + id
                        ));

        // Mapeamos los nuevos datos sobre la entidad existente
        modelMapper.map(dto, razas);
        razas.setIdRaza(id); // Aseguramos que el ID no cambie

        // Actualizamos la relación de llave foránea con la nueva especie
        razas.setEspecie(obtenerEspecie(dto.getIdEspecie()));

        rS.insert(razas);

        RazasDTO responseDTO = modelMapper.map(razas, RazasDTO.class);
        responseDTO.setIdEspecie(razas.getEspecie().getIdEspecie());

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Razas razas  = rS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe la raza con ID: " + id
                        ));

        rS.delete(razas.getIdRaza());
        return ResponseEntity.noContent().build();
    }

    private Especie obtenerEspecie(Long idEspecie) {
        return eS.listId(idEspecie)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "No existe la especie con ID: " + idEspecie));
    }
}