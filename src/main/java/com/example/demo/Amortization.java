
//Error says: The type java.util.AbstractList cannot be resolved. 
//It is indirectly referenced from required type java.util.ArrayListJava(16777563)
package com.example.demo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor
public class Amortization implements AmortizationInterface{

    private double principal;
    private double interestRate;
    private int numPayments;

    @Override
    public String toString() {
      return principal + " " + interestRate + " " + numPayments;
    }

    public List<AmortizationTableRow> getAmortizationTable() {
        double monthlyInterest = interestRate/12;
        int monthNum = 1;
        double monthlyPayment = calculateMonthlyPayments();
        double newPrincipal = principal;

        List<AmortizationTableRow> table = new ArrayList<AmortizationTableRow>();
  
        while(newPrincipal > 0) {
            AmortizationTableRow row = new AmortizationTableRow();

            row.setBeginBalance(newPrincipal);
            row.setMonthlyPayment(monthlyPayment);
            row.setPaymentNum(monthNum);

            newPrincipal = newPrincipal * (1 + monthlyInterest) - monthlyPayment;
            //System.out.printf("Month: %d\tPrincipal: %,.2f\n", monthNum, principal);
            row.setEndBalance(newPrincipal);

            table.add(row);

            monthNum++;
        }

        return table;
      }
    
      public double calculateMonthlyPayments() {
        double monthlyInterest = interestRate/12;
        double monthlyPayment = principal * monthlyInterest * Math.pow(1 + monthlyInterest, numPayments) 
                                                        / (Math.pow(1 + monthlyInterest, numPayments) - 1);
        return monthlyPayment; 
      }
}
