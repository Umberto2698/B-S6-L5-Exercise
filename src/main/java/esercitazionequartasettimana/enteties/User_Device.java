package esercitazionequartasettimana.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_devices")
public class User_Device {
    @Id
    private UUID id;
    @Column(name = "assignment_date")
    private LocalDate assignmentDate;
    @Column(name = "withdrawal_date")
    private LocalDate withdrawalDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
}
