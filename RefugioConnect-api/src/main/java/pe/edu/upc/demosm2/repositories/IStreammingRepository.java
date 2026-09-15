package pe.edu.upc.demosm2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demosm2.entities.Streaming;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IStreammingRepository extends JpaRepository<Streaming,Long> {
    List<Streaming> findByLaunchDateStreaming(LocalDate date);
}
