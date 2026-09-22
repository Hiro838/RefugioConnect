package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.Especie;

import java.util.List;
import java.util.Optional;

public interface IEspecieService {
    public List<Especie>list();
    public void insert(Especie e);
    public Optional<Especie> listId(Long id);
    public void delete(Long id);
}
