package com.patika.kredinbizdeservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = VechileLoan.class),
        @JsonSubTypes.Type(value = HouseLoan.class),
        @JsonSubTypes.Type(value = ConsumerLoan.class)
})

public abstract class Loan implements Product {

    private BigDecimal amount;
    private Integer installment;
    private Double interestRate;
    // private Campaign campaign; // kampanyalı kredileri üstte çıkart

    //sponsorlu kampanyaları üstte çıkart

    public Loan() {
    }

    public Loan(BigDecimal amount, Integer installment, Double interestRate) {
        this.amount = amount;
        this.installment = installment;
        this.interestRate = interestRate;
    }

    abstract void calculate(BigDecimal amount, int installment);

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }



    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "amount=" + amount +
                ", installment=" + installment +
                ", interestRate=" + interestRate +
                '}';
    }
}
