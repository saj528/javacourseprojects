package MortgageProj;

import java.util.Scanner;

public class HomeBuyingApp {
    private String homeBuyersName;
    private double yearlyIncome;
    private double monthlyIncome;
    private double downPayment;
    private double rate;
    private double principal;
    private double monthlyPayment;
    private double debt;
    private double debtToIncomeRatio;
    private int time;

    public HomeBuyingApp(String homeBuyersName, long yearlyIncome) {
        this.homeBuyersName = homeBuyersName;
        this.yearlyIncome = yearlyIncome;
        this.monthlyIncome = (yearlyIncome / 12);
    }

    public void loanReport(){
        calculateMortgage();
        calculateDebtToIncomeRatio();
        calculateDownPayment();
        System.out.println(toString());
    }


    public void calculateMortgage(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Principal Amount : ");
        principal = scan.nextDouble();

        System.out.print("Enter Rate of Interest : ");
        rate = scan.nextDouble();
        double monthlyRate = (rate / 100) / 12;

        System.out.print("Enter Time period in years : ");
        time = scan.nextInt();
        int months = time * 12;

        System.out.print("How much do you currently pay monthly towards debt? : ");
        debt = scan.nextDouble();

        monthlyPayment = (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
        monthlyPayment = Math.round(monthlyPayment);

    }


    public void calculateDebtToIncomeRatio(){
        debtToIncomeRatio = (( monthlyPayment + debt) / monthlyIncome) * 100;
    }

    public void calculateDownPayment(){
        downPayment = principal * .20;
    }


    @Override
    public String toString() {
        return
                "Home Buyers Name: " + homeBuyersName + "\n" +
                " Yearly Income: $" + yearlyIncome + "\n" +
                " Monthly Income: $" + monthlyIncome + "\n" +
                " Interest Rate: " + rate + "%" + "\n" +
                " Principal Amount: $" + principal + "\n" +
                " Down Payment: $" + downPayment + "\n" +
                " Monthly House Payment: $" + monthlyPayment + "\n" +
                " Total Monthly Payments: $" + (monthlyPayment + debt) + "\n" +
                " Debt to Income Ratio: " + debtToIncomeRatio + "%" + "\n" +
                " Term of Loan: " + time + " years";
    }
}
