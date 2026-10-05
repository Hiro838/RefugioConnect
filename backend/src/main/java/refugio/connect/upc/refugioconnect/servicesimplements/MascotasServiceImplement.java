package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.Mascotas;
import refugio.connect.upc.refugioconnect.repositories.IMascotasRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IMascotasService;

import java.util.List;
import java.util.Optional;

@Service
public class MascotasServiceImplement implements IMascotasService {

    private final IMascotasRepository mR;

    public MascotasServiceImplement(IMascotasRepository mR) {
        this.mR = mR;
    }

    @Override
    public List<Mascotas> list() {
        return mR.findAll();
    }

    @Override
    public void insert(Mascotas mascotas) {
        mR.save(mascotas);
    }

    @Override
    public Optional<Mascotas> listId(Long id)  {
        return mR.findById(id);
    }

    @Override
    public void delete(Long id)  {
        mR.deleteById(id);
    }
}
