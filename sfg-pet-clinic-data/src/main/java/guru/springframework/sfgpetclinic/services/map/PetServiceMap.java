package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends BaseServiceMap<Pet, Long>
        implements CrudService<Pet, Long> {


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
