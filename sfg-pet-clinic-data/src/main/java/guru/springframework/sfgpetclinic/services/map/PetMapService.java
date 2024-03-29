package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map", "default"})
public class PetMapService extends BaseMapService<Pet, Long>
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
        return super.put(object);
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
