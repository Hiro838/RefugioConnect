package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.Donaciones;
import refugio.connect.upc.refugioconnect.repositories.IDonacionesRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IDonacionesService;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionesServiceImplement implements IDonacionesService {

    private final IDonacionesRepository donacionesRepository;

    public DonacionesServiceImplement(IDonacionesRepository donacionesRepository) {
        this.donacionesRepository = donacionesRepository;
    }

    @Override
    public void insert(Donaciones donaciones) {
        donacionesRepository.save(donaciones);
    }

    @Override
    public List<Donaciones> list() {
        return donacionesRepository.findAll();
    }

    @Override
    public Optional<Donaciones> listId(Long id) {
        return donacionesRepository.findById(id);
    }

    @Override
    public void update(Donaciones donaciones) {
        donacionesRepository.save(donaciones);
    }

    @Override
    public void delete(Long id) {
        donacionesRepository.deleteById(id);
    }
}