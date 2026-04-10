import java.util.Scanner;

public class LoanSystem {

    static double calculateEMI(double loanAmount, double rate, int time) {
        rate = rate / (12 * 100);
        time = time * 12;
        double emi = (loanAmount * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);
        return emi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double income, loanAmount, rate, emi;
        int time, monthsPaid;

        System.out.println("=== Loan Eligibility & EMI Tracking System ===\n");

        System.out.print("Enter your monthly income: ");
        income = sc.nextDouble();

        System.out.print("Enter loan amount: ");
        loanAmount = sc.nextDouble();

        System.out.print("Enter interest rate (annual): ");
        rate = sc.nextDouble();

        System.out.print("Enter loan duration (years): ");
        time = sc.nextInt();

        if (income >= 20000) {
            System.out.println("\nYou are eligible for the loan.");

            emi = calculateEMI(loanAmount, rate, time);
            System.out.printf("Your monthly EMI: %.2f\n", emi);

            System.out.print("\nEnter number of EMIs paid: ");
            monthsPaid = sc.nextInt();

            if (monthsPaid >= time * 12) {
                System.out.println("Loan fully paid!");
            } else {
                System.out.println("Remaining EMIs: " + ((time * 12) - monthsPaid));
            }

        } else {
            System.out.println("\nYou are NOT eligible for the loan.");
        }

        sc.close();
    }
}