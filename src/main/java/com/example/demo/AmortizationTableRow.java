package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class AmortizationTableRow {
    
    private int paymentNum;
    private double monthlyPayment;
    private double beginBalance;
    private double endBalance;

}
