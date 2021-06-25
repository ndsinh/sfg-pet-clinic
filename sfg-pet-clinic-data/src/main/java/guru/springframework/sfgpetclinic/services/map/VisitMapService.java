package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map", "default"})
public class VisitMapService extends BaseMapService<Visit, Long>
        implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.get(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.getSetValues();
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null
                || object.getPet().getId() == null
                || object.getPet().getOwner() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.put(object);
    }

    @Override
    public void delete(Visit object) {
        super.removeByValue(object);
    }

    @Override
    public void deleteById(Long id) {
        super.removeByKey(id);
    }
}
