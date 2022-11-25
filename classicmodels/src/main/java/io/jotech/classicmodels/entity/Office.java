package io.jotech.classicmodels.entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
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
@Table(name = "offices")
public class Office implements Serializable {

    @Id
    @Size(max = 10)
    @Column(name = "officeCode", nullable = false, length = 10)
    @JsonbProperty(value = "officeCode")
    private String officeCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Size(max = 50)
    @NotNull
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Size(max = 50)
    @NotNull
    @Column(name = "addressLine1", nullable = false, length = 50)
    private String addressLine1;

    @Size(max = 50)
    @Column(name = "addressLine2", length = 50)
    private String addressLine2;

    @Size(max = 50)
    @Column(name = "state", length = 50)
    private String state;

    @Size(max = 50)
    @NotNull
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Size(max = 15)
    @NotNull
    @Column(name = "postalCode", nullable = false, length = 15)
    private String postalCode;

    @Size(max = 10)
    @NotNull
    @Column(name = "territory", nullable = false, length = 10)
    private String territory;


    public static Office fromOfficeCode(String officeCode) {

        return Office.builder().officeCode(officeCode).build();
    }



}
