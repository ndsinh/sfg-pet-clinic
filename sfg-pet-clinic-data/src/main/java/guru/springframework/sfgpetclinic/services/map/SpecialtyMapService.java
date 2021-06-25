package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyMapService extends BaseMapService<Speciality, Long> implements SpecialtyService {
    @Override
    public Speciality findById(Long id) {
        return super.get(id);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.getSetValues();
    }

    @Override
    public Speciality save(Speciality object) {
        return super.put(object);
    }

    @Override
    public void delete(Speciality object) {
        super.removeByValue(object);
    }

    @Override
    public void deleteById(Long id) {
        super.removeByKey(id);
    }
}
