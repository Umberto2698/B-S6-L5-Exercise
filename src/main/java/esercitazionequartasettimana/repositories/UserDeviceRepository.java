package esercitazionequartasettimana.repositories;

import esercitazionequartasettimana.enteties.User_Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDeviceRepository extends JpaRepository<User_Device, UUID> {
    Page<User_Device> findByUserId(UUID userId, Pageable page);
}
