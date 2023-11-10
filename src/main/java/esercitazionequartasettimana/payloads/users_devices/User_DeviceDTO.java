package esercitazionequartasettimana.payloads.users_devices;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record User_DeviceDTO(
        @NotNull(message = "The assignment date is required.")
        LocalDate assignmentDate,
        LocalDate withdrawalDate) {
}
