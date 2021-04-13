package MortgageProj;

import java.util.Scanner;

public class HomeBuyer {
    private String homeBuyersName;
    private double yearlyIncome;
    private double monthlyIncome;
    private double rate;
    private double principal;
    private double monthlyPayment;
    private int debtToIncomeRatio;
    private int time;

    public HomeBuyer(String homeBuyersName, long yearlyIncome) {
        this.homeBuyersName = homeBuyersName;
        this.yearlyIncome = yearlyIncome;
        this.monthlyIncome = (yearlyIncome / 12);
    }

    public void loanReport(){
        calculateMortgage();
        calculateDebtToIncomeRatio();
        System.out.println(toString());
    }


    public double calculateMortgage(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Principal Amount : ");
        principal = scan.nextDouble();

        System.out.print("Enter Rate of Interest : ");
        rate = scan.nextDouble();
        double monthlyRate = (rate / 100) / 12;

        System.out.print("Enter Time period in years : ");
        time = scan.nextInt();
        int months = time * 12;

        monthlyPayment = (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
        monthlyPayment = Math.round(monthlyPayment);
        return monthlyPayment;

    }


    public int calculateDebtToIncomeRatio(){
        debtToIncomeRatio = (int) monthlyIncome /  (int) monthlyPayment;
        return debtToIncomeRatio;
    }


    @Override
    public String toString() {
        return
                "Home Buyers Name: " + homeBuyersName + "\n" +
                " Yearly Income: $" + yearlyIncome + "\n" +
                " Monthly Income: $" + monthlyIncome + "\n" +
                " Interest Rate: " + rate + "\n" +
                " Principal Amount: $" + principal + "\n" +
                " Monthly Payment: $" + monthlyPayment + "\n" +
                " Debt to Income Ratio: " + debtToIncomeRatio + "\n" +
                " Term of Loan: " + time + " years";
    }
}
