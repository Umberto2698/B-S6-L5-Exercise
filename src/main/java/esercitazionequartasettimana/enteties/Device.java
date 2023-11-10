package esercitazionequartasettimana.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import esercitazionequartasettimana.enums.DeviceState;
import esercitazionequartasettimana.enums.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
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

    @OneToMany(mappedBy = "device")
    @JsonIgnore
    private List<User_Device> user_devices;

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", state=" + state +
                ", type=" + type +
                '}';
    }
}
