package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.Donacion;

import java.util.List;
import java.util.Optional;

public interface IDonacionService {

    public List<Donacion> list();

    public void insert(Donacion d);

    public Optional<Donacion> listId(Long id);

    public void delete(Long id);
}