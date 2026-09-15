package refugio.connect.upc.refugioconnect.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import refugio.connect.upc.refugioconnect.dtos.RolDTO;
import refugio.connect.upc.refugioconnect.entities.Rol;
import refugio.connect.upc.refugioconnect.exceptions.ResourceNotFoundException;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IRolService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final IRolService rS;
    private final ModelMapper modelMapper;

    public RolController(IRolService rS, ModelMapper modelMapper) {
        this.rS = rS;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listar() {
        List<RolDTO> lista = rS.list()
                .stream()
                .map(r -> modelMapper.map(r, RolDTO.class))
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<RolDTO> registrar(@Valid @RequestBody RolDTO dto) {
        Rol rol = modelMapper.map(dto, Rol.class);
        rS.insert(rol);

        RolDTO responseDTO = modelMapper.map(rol, RolDTO.class);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(rol.getIdRol())
                .toUri();

        return ResponseEntity.created(location).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> buscarId(@PathVariable Long id) {
        Rol rol = rS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el rol con ID: " + id
                        ));

        RolDTO responseDTO = modelMapper.map(rol, RolDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> actualizar(@PathVariable Long id, @Valid @RequestBody RolDTO dto) {
        Rol rol = rS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el rol con ID: " + id
                        ));

        // Mapeamos los nuevos datos sobre la entidad existente
        modelMapper.map(dto, rol);
        rol.setIdRol(id); // Aseguramos que el ID no cambie
        rS.insert(rol);

        RolDTO responseDTO = modelMapper.map(rol, RolDTO.class);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Rol rol = rS.listId(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe el rol con ID: " + id
                        ));

        rS.delete(rol.getIdRol());
        return ResponseEntity.noContent().build();
    }
}