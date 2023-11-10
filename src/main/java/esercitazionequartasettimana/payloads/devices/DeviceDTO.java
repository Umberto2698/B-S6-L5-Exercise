package esercitazionequartasettimana.payloads.devices;

import esercitazionequartasettimana.enums.DeviceState;
import esercitazionequartasettimana.enums.DeviceType;
import jakarta.validation.constraints.NotNull;

public record DeviceDTO(
        DeviceState state,
        @NotNull(message = "Insert the type of the device.")
        DeviceType type) {
}
