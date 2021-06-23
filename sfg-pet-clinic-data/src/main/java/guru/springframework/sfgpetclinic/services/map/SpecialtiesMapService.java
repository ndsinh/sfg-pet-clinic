package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialtiesMapService extends BaseServiceMap<Speciality, Long> implements SpecialtiesService {
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
