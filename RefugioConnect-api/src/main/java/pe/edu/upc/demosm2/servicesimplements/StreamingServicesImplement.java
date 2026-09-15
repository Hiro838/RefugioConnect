package pe.edu.upc.demosm2.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.demosm2.entities.Streaming;
import pe.edu.upc.demosm2.repositories.IStreammingRepository;
import pe.edu.upc.demosm2.servicesinterfaces.IStreamingService;

import java.time.LocalDate;
import java.util.List;
@Service
public class StreamingServicesImplement implements IStreamingService {

    public final IStreammingRepository sR;

    public StreamingServicesImplement(IStreammingRepository sR) {
        this.sR = sR;
    }

    @Override
    public void insert(Streaming s) {
        sR.save(s);
    }

    @Override
    public List<Streaming> list() {
        return sR.findAll();
    }

    @Override
    public List<Streaming> findByLaunchDateStreaming(LocalDate date) {
        return sR.findByLaunchDateStreaming(date);
    }
}
