package esercitazionequartasettimana.enteties;

import esercitazionequartasettimana.enums.DeviceState;
import esercitazionequartasettimana.enums.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "devices")
public class Device {
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private DeviceState state;
    @Enumerated(EnumType.STRING)
    private DeviceType type;
}
