package pe.edu.upc.demosm2.servicesinterfaces;

import pe.edu.upc.demosm2.entities.Streaming;

import java.time.LocalDate;
import java.util.List;

public interface IStreamingService {
    public void insert(Streaming s);
    public List<Streaming> list();
    List<Streaming> findByLaunchDateStreaming(LocalDate date);
}
