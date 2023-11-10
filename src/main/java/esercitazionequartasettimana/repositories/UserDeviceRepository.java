package esercitazionequartasettimana.repositories;

import esercitazionequartasettimana.enteties.User;
import esercitazionequartasettimana.enteties.User_Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserDeviceRepository extends JpaRepository<User_Device, UUID> {
    List<User_Device> findByUser(User user);
}
