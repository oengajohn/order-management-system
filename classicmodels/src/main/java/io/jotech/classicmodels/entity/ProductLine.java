package io.jotech.classicmodels.entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;
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
@Table(name = "productlines")
public class ProductLine implements Serializable {

    @Id
    @Size(max = 50)
    @Column(name = "productLine", nullable = false, length = 50)
    @JsonbProperty(value = "productLine")
    private String id;

    @Size(max = 4000)
    @Column(name = "textDescription", length = 4000)
    private String textDescription;

    @Lob
    @Column(name = "htmlDescription")
    private String htmlDescription;

    @Column(name = "image")
    private byte[] image;


    public static ProductLine fromProductLine(String productLine) {

        return ProductLine.builder().id(productLine).build();
    }

}
