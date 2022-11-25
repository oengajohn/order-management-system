package io.jotech.classicmodels.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "products", indexes = {
        @Index(name = "productLine", columnList = "productLine")
})

public class Product implements Serializable {

    @Id
    @Column(name = "productCode", nullable = false, updatable = false)
    private String productCode;

    @NotNull
    @Size(max = 70)
    @Column(length = 70, nullable = false)
    private String productName;


    @OneToOne(optional = false)
    @JoinColumn(name = "productLine",foreignKey = @ForeignKey(name = "products_ibfk_1"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("productLine")
    @Setter(AccessLevel.NONE)
    private ProductLine productLine;

    @NotNull
    @Size(max = 10)
    @Column(length = 10, nullable = false)
    private String productScale;


    @NotNull
    @Size(max = 50)
    @Column(length = 50, nullable = false)
    private String productVendor;

    @NotNull
    @Column(nullable = false, columnDefinition = "text")
    private String productDescription;

    @NotNull
    @Column(nullable = false, columnDefinition = "smallint")
    private Integer quantityInStock;

    @NotNull
    @Column(nullable = false)
    BigDecimal buyPrice;

    @NotNull
    @Column(nullable = false,name = "MSRP")
    BigDecimal mSRP;


    @JsonProperty("productLine")
    public void setProductLineByLine(String line) {
        productLine = ProductLine.fromProductLine(line);

    }

    public static Product fromProductCode(String productCode) {

        return Product.builder().productCode(productCode).build();
    }
}
