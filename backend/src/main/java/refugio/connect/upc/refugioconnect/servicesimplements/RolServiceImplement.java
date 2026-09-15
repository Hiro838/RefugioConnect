package refugio.connect.upc.refugioconnect.servicesimplements;

import org.springframework.stereotype.Service;
import refugio.connect.upc.refugioconnect.entities.Rol;
import refugio.connect.upc.refugioconnect.repositories.IRolRepository;
import refugio.connect.upc.refugioconnect.servicesinterfaces.IRolService;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplement implements IRolService {
    private final IRolRepository rR;

    public RolServiceImplement(IRolRepository rR) {
        this.rR = rR;
    }

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol r) {
        rR.save(r);
    }

    @Override
    public Optional<Rol> listId(Long id) {
        return rR.findById(id);
    }

    @Override
    public void delete(Long id) {
        rR.deleteById(id);
    }

}
