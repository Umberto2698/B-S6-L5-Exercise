package esercitazionequartasettimana.enteties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import esercitazionequartasettimana.enums.DeviceState;
import esercitazionequartasettimana.enums.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
    private DeviceState state = DeviceState.AVAILABLE;
    @Enumerated(EnumType.STRING)
    private DeviceType type;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime cratedAt;

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
