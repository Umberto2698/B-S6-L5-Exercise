package esercitazionequartasettimana.controllers;

import esercitazionequartasettimana.enteties.Device;
import esercitazionequartasettimana.exceptions.BadRequestException;
import esercitazionequartasettimana.payloads.devices.DeviceDTO;
import esercitazionequartasettimana.payloads.devices.DeviceUpdateInfoDTO;
import esercitazionequartasettimana.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("")
    public Page<Device> getDevices(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String orderBy) {
        return deviceService.getDevices(page, size, orderBy);
    }

    @GetMapping("/{id}")
    public Device getDevice(@PathVariable UUID id) {
        return deviceService.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Device saveDevice(@RequestBody @Validated DeviceDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return deviceService.save(body);
        }
    }

    @PatchMapping("/{id}")
    public Device updateDeviceInfo(@PathVariable UUID id, @RequestBody @Validated DeviceUpdateInfoDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return deviceService.update(id, body);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevice(@PathVariable UUID id) {
        deviceService.delete(id);
    }


}
