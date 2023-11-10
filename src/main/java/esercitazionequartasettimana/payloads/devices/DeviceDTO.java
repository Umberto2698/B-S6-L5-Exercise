package esercitazionequartasettimana.payloads.devices;

import jakarta.validation.constraints.NotEmpty;

public record DeviceDTO(
        String state,
        @NotEmpty(message = "Insert the type of the device.")
        String type) {
}
