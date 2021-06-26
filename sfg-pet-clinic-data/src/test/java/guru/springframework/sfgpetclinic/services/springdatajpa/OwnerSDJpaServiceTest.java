package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Long id = 1L;
    String lastName = "Smith";

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(id);
        returnOwner.setLastName(lastName);
    }

    @Test
    void findByIdFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
        Owner byId = ownerSDJpaService.findById(id);
        assertNotNull(byId);
        assertEquals(id, byId.getId());
        verify(ownerRepository, times(1)).findById(id);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        Owner byId = ownerSDJpaService.findById(id);
        assertNull(byId);
        verify(ownerRepository, times(1)).findById(id);
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setLastName("Owner1");
        returnOwners.add(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setLastName("Owner2");
        returnOwners.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> all = ownerSDJpaService.findAll();
        assertNotNull(all);
        assertEquals(2, all.size());

        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner owner = new Owner();
        owner.setId(id);
        owner.setLastName(lastName);
        Owner savedOwner = ownerSDJpaService.save(owner);

        assertNotNull(savedOwner);
        assertEquals(returnOwner.getId(), savedOwner.getId());
        verify(ownerRepository, times(1)).save(owner);
    }

    @Test
    void delete() {
        Owner owner = new Owner();
        owner.setId(id);
        owner.setLastName(lastName);

        ownerSDJpaService.delete(owner);
        verify(ownerRepository, times(1)).delete(owner);
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(id);
        verify(ownerRepository, times(1)).deleteById(id);
    }

    @Test
    void findByLastName() {
        Owner owner = new Owner();
        owner.setId(1l);
        owner.setLastName(lastName);
        when(ownerRepository.findByLastName(any()))
                .thenReturn(Optional.of(owner));
        Owner byLastName = ownerSDJpaService.findByLastName(lastName);
        assertEquals(lastName, byLastName.getLastName());
        verify(ownerRepository, times(1))
                .findByLastName(any());
    }
}