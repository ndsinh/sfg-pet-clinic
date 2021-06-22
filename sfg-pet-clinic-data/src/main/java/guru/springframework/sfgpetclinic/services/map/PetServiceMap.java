package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends BaseServiceMap<Pet, Long>
        implements PetService {


    @Override
    public Pet findById(Long id) {
        return super.get(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.getSetValues();
    }

    @Override
    public Pet save(Pet object) {
        return super.put(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        super.removeByValue(object);
    }

    @Override
    public void deleteById(Long id) {
        super.removeByKey(id);
    }
}
