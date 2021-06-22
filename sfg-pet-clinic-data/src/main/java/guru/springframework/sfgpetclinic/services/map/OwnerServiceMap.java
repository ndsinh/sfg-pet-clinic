package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends BaseServiceMap<Owner, Long>
        implements OwnerService {

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

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
