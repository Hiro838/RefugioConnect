package refugio.connect.upc.refugioconnect.servicesinterfaces;

import refugio.connect.upc.refugioconnect.entities.TurnosVoluntariados;

import java.util.List;
import java.util.Optional;

public interface ITurnosVoluntariadosService {

    public void insert(TurnosVoluntariados turnosVoluntariados);

    public List<TurnosVoluntariados> list();

    public Optional<TurnosVoluntariados> listId(Long id);

    public void update(TurnosVoluntariados turnosVoluntariados);

    public void delete(Long id);
}