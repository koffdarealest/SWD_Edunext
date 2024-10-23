package group3.edunext.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "ProductName", length = 50)
    private String productName;

    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;

    @Column(name = "UnitsInStock")
    private Integer unitsInStock;

    @Nationalized
    @Lob
    @Column(name = "Image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID")
    private Category categoryID;

}