package exercise2_0;
import java.util.Date;

/**
 * Exercise 2.0: Loan class.
 * Models a loan with an annual interest rate, number of years,
 * loan amount, and the date the loan was created.
 */
public class loan {

    // ---------- Data fields (attributes) ----------
    private double annualInterestRate; // annual interest rate in percent (default 2.5)
    private int numberOfYears;         // loan duration in years (default 1)
    private double loanAmount;         // amount borrowed (default 1000)
    private Date loanDate;             // date the loan was created

    // ---------- Constructors ----------

    // No-argument constructor
    public loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Creates a loan with the specified interest rate, years, and amount.
     * The loan date is set automatically to the current date and time.
     */
    public loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date(); // current date when the object is created
    }

    // ---------- Accessor methods (getters) ----------

    /** Returns the annual interest rate of this loan. */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /** Returns the number of years of this loan. */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /** Returns the amount of this loan. */
    public double getLoanAmount() {
        return loanAmount;
    }

    /** Returns the date this loan was created. */
    public Date getLoanDate() {
        return loanDate;
    }

    // ---------- Mutator methods (setters) ----------
    // Note: there is no setter for loanDate, because the diagram doesn't have one.

    /** Sets a new annual interest rate for this loan. */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /** Sets a new number of years for this loan. */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /** Sets a new amount for this loan. */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // ---------- Other methods ----------

    /**
     * Returns the monthly payment for this loan using the formula:
     *   monthlyPayment = (P * r) / (1 - (1 + r)^(-n))
     * where P = loan amount, r = monthly interest rate,
     * n = total number of monthly payments.
     */
    public double getMonthlyPayment() {
        double r = annualInterestRate / 1200;  // monthly rate (percent -> decimal, / 12 months)
        int n = numberOfYears * 12;            // total number of monthly payments

        // Special case: with 0% interest the formula would divide by zero
        if (r == 0) {
            return loanAmount / n;
        }

        return (loanAmount * r) / (1 - Math.pow(1 + r, -n));
    }

    /** Returns the total payment for this loan (monthly payment * number of months). */
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

}
class test{
    // ---------- Simple test ----------
    public static void main(String[] args) {
        loan loan = new loan(7.5, 5, 20000);
        System.out.println("Loan date: " + loan.getLoanDate());
        System.out.printf("Monthly payment: %.2f%n", loan.getMonthlyPayment());
        System.out.printf("Total payment: %.2f%n", loan.getTotalPayment());
    }
}