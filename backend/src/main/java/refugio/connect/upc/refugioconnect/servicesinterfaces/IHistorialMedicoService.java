package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.HistorialMedico;

import java.util.List;
import java.util.Optional;

public interface IHistorialMedicoService {
    public List<HistorialMedico> list();
    public void insert(HistorialMedico h);
    public Optional<HistorialMedico> listId(Long id);
    public void delete(Long id);
}
