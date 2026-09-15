package pe.edu.upc.demosm2.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.upc.demosm2.dtos.StreamingDTOInsert;
import pe.edu.upc.demosm2.dtos.StreamingDTOList;
import pe.edu.upc.demosm2.entities.Streaming;
import pe.edu.upc.demosm2.servicesinterfaces.IStreamingService;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/streamings")
public class StreamingController {
    private final IStreamingService cS;
    private final ModelMapper modelMapper;

    public StreamingController(IStreamingService cS, ModelMapper modelMapper) {
        this.cS = cS;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<StreamingDTOList>> listar() {

        List<StreamingDTOList> lista = cS.list()
                .stream()
                .map(streaming -> modelMapper.map(streaming, StreamingDTOList.class))
                .toList();

        return ResponseEntity.ok(lista);
    }
    @PostMapping
    public ResponseEntity<StreamingDTOInsert> registrar(
            @Valid @RequestBody StreamingDTOInsert dto) {
        Streaming st = modelMapper.map(dto, Streaming.class);
        cS.insert(st);
        StreamingDTOInsert responseDTO =
                modelMapper.map(st, StreamingDTOInsert.class);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(st.getIdStreaming())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(responseDTO);
    }
    @GetMapping("/buscar-por-fecha")
    public ResponseEntity<List<StreamingDTOList>> buscarPorFecha(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        List<StreamingDTOList> lista = cS.findByLaunchDateStreaming(fecha)
                .stream()
                .map(streaming -> modelMapper.map(streaming, StreamingDTOList.class))
                .toList();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si no encuentra nada
        }

        return ResponseEntity.ok(lista);
    }
}
