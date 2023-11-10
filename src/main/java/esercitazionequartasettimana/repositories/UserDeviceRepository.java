package esercitazionequartasettimana.repositories;

import esercitazionequartasettimana.enteties.User_Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDeviceRepository extends JpaRepository<User_Device, UUID> {
}
