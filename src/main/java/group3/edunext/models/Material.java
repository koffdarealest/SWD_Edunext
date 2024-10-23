package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
public class Material {
    @Id
    @Column(name = "MaterialID", nullable = false)
    private Integer id;

    @Column(name = "MaterialName", nullable = false, length = 100)
    private String materialName;

    @Column(name = "MaterialType", nullable = false, length = 50)
    private String materialType;

    @Nationalized
    @Lob
    @Column(name = "ClassIDs")
    private String classIDs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UploadedBy")
    private User uploadedBy;

}