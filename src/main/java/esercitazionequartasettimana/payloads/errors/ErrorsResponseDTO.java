package esercitazionequartasettimana.payloads.errors;

import java.util.Date;

public record ErrorsResponseDTO(String message, Date timestamp) {
}
