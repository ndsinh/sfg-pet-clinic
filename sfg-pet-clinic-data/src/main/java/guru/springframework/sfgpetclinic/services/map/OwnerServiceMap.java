package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends BaseServiceMap<Owner, Long>
        implements CrudService<Owner, Long> {

    @Override
    public Owner findById(Long id) {
        return super.get(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.getSetValues();
    }

    @Override
    public Owner save(Owner object) {
        return super.put(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.removeByValue(object);
    }

    @Override
    public void deleteById(Long id) {
        super.removeByKey(id);
    }
}
