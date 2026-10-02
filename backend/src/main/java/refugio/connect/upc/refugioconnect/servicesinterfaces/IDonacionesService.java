package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.Donaciones;

import java.util.List;
import java.util.Optional;

public interface IDonacionesService {

    public void insert(Donaciones donaciones);

    public List<Donaciones> list();

    public Optional<Donaciones> listId(Long id);

    public void update(Donaciones donaciones);

    public void delete(Long id);
}