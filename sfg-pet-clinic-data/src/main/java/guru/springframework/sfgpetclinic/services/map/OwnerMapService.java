package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map", "default"})
public class OwnerMapService extends BaseMapService<Owner, Long>
        implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

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
        if (object == null) {
            return null;
        }
        if (object.getPets() != null) {
            object.getPets().forEach(pet -> {
                if (pet.getPetType() == null) {
                    throw new RuntimeException("Pet Type is required");
                }
                if (pet.getPetType().getId() == null) {
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                }
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
        return super.put(object);
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
        return this.findAll().stream()
                .filter(owner -> lastName.equalsIgnoreCase(owner.getLastName()))
                .findFirst().orElse(null);
    }
}
