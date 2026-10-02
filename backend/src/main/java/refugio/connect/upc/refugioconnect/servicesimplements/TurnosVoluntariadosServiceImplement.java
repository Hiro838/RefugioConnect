package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.TurnosVoluntariados;
import refugio.connect.upc.refugioconnect.repositories.ITurnosVoluntariadosRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.ITurnosVoluntariadosService;

import java.util.List;
import java.util.Optional;

@Service
public class TurnosVoluntariadosServiceImplement implements ITurnosVoluntariadosService {

    private final ITurnosVoluntariadosRepository turnosRepository;

    public TurnosVoluntariadosServiceImplement(ITurnosVoluntariadosRepository turnosRepository) {
        this.turnosRepository = turnosRepository;
    }

    @Override
    public void insert(TurnosVoluntariados turnosVoluntariados) {
        turnosRepository.save(turnosVoluntariados);
    }

    @Override
    public List<TurnosVoluntariados> list() {
        return turnosRepository.findAll();
    }

    @Override
    public Optional<TurnosVoluntariados> listId(Long id) {
        return turnosRepository.findById(id);
    }

    @Override
    public void update(TurnosVoluntariados turnosVoluntariados) {
        turnosRepository.save(turnosVoluntariados);
    }

    @Override
    public void delete(Long id) {
        turnosRepository.deleteById(id);
    }
}