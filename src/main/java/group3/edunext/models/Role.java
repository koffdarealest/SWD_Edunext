package group3.edunext.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role {
    @Id
    @Column(name = "RoleID", nullable = false)
    private Integer id;

    @Column(name = "RoleName", nullable = false, length = 50)
    private String roleName;

}