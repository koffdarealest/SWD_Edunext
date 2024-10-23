package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @Column(name = "UserID", nullable = false)
    private Integer id;

    @Column(name = "Username", nullable = false, length = 100)
    private String username;

    @Column(name = "Fullname", length = 100)
    private String fullname;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Address", length = 100)
    private String address;

    @Column(name = "PhoneNumber", length = 15)
    private String phoneNumber;

    @Column(name = "Gender")
    private Boolean gender;

    @Column(name = "Dob")
    private LocalDate dob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID")
    private Role roleID;

    @Column(name = "Status", length = 20)
    private String status;

}