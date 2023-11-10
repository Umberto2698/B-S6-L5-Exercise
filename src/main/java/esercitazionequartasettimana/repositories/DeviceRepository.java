package esercitazionequartasettimana.repositories;

import esercitazionequartasettimana.enteties.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
