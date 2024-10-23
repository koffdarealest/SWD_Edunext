package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "CustomerName", nullable = false, length = 50)
    private String customerName;

    @Column(name = "Birthdate", nullable = false)
    private Instant birthdate;

    @Column(name = "Gender", nullable = false)
    private Boolean gender = false;

    @Nationalized
    @Lob
    @Column(name = "Address")
    private String address;

}