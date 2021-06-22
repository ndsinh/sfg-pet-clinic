package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends BaseServiceMap<Vet, Long>
        implements VetService {
    @Override
    public Vet findById(Long id) {
        return super.get(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.getSetValues();
    }

    @Override
    public Vet save(Vet object) {
        return super.put(object);
    }

    @Override
    public void delete(Vet object) {
        super.removeByValue(object);
    }

    @Override
    public void deleteById(Long id) {
        super.removeByKey(id);
    }
}
