package esercitazionequartasettimana.services;

import esercitazionequartasettimana.enteties.Device;
import esercitazionequartasettimana.exceptions.ItemNotFoundException;
import esercitazionequartasettimana.payloads.devices.DeviceDTO;
import esercitazionequartasettimana.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public Page<Device> getDevices(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return deviceRepository.findAll(pageable);
    }

    public Device save(DeviceDTO body) {
        Device device = new Device();
        if (body.state() == null || body.state().isEmpty()) {
            device = Device.builder().state("AVAILABLE").type(body.type()).build();
        } else {
            device = Device.builder().state(body.state()).type(body.type()).build();
        }
        device.setId(UUID.randomUUID());
        return deviceRepository.save(device);
    }

    public Device getById(UUID id) {
        return deviceRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Device update(UUID id, DeviceDTO body) {
        Device found = this.getById(id);
        if (body.state() == null || body.state().isEmpty()) {
            found.setState("AVAILABLE");
        } else {
            found.setState(body.state());
        }
        found.setType(body.type());
        return deviceRepository.save(found);
    }

    public void delete(UUID id) {
        Device found = this.getById(id);
        deviceRepository.delete(found);
    }
}
