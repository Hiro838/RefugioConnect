package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.HistorialMedico;
import refugio.connect.upc.refugioconnect.repositories.IHistorialMedicoRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IHistorialMedicoService;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoServiceImplement implements IHistorialMedicoService {

    private final IHistorialMedicoRepository hR;

    public HistorialMedicoServiceImplement(IHistorialMedicoRepository hR) {
        this.hR = hR;
    }

    @Override
    public List<HistorialMedico> list() {
        return hR.findAll();
    }

    @Override
    public void insert(HistorialMedico historialMedico) {
        hR.save(historialMedico);
    }

    @Override
    public Optional<HistorialMedico> listId(Long id)  {
        return hR.findById(id);
    }

    @Override
    public void delete(Long id)  {
        hR.deleteById(id);
    }
}
