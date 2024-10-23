package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "Account", nullable = false, length = 20)
    private String account;

    @Column(name = "Password", nullable = false, length = 20)
    private String password;

    @Nationalized
    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "Gender", nullable = false)
    private Boolean gender = false;

    @Nationalized
    @Lob
    @Column(name = "Address")
    private String address;

}