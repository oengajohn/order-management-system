package io.jotech.classicmodels.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "payments")
@IdClass(PaymentId.class)
public class Payment implements Serializable {

    @Id
    @Column(name = "checkNumber", nullable = false, length = 50)
    private String checkNumber;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerNumber", nullable = false,foreignKey = @ForeignKey(name = "payments_ibfk_1"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerNumber")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("customerNumber")
    @Setter(AccessLevel.NONE)
    private Customer customerNumber;

    @NotNull
    @Column(name = "paymentDate", nullable = false)
    private LocalDate paymentDate;

    @NotNull
    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;


    @JsonProperty("customerNumber")
    public void setCustomerByCustomerNumber(Integer customerNum) {
        customerNumber = Customer.fromCustomerNumber(customerNum);

    }


}
