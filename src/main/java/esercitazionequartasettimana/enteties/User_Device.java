package esercitazionequartasettimana.enteties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
