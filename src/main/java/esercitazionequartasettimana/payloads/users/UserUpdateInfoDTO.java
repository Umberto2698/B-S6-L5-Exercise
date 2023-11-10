package esercitazionequartasettimana.payloads.users;

import jakarta.validation.constraints.Pattern;

public record UserUpdateInfoDTO(
        String name,
        String surname,
        String username,
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Insert a valid email.")
        String email) {
}