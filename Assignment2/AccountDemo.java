package Inheritance;
import java.util.Scanner;

public class AccountDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double balance, annual_Int_Rate,monthly_Ser_Charge,
                amount_Of_Deposit,amount_Of_Withdraw;
        System.out.println("Testing Bank Account Class");
        System.out.println("Enter Your Balance");
        balance = input.nextDouble();
        System.out.println("Enter Interest Rate");
        annual_Int_Rate = input.nextDouble();
        System.out.println("Enter Monthly Charges");
        monthly_Ser_Charge = input.nextDouble();
        System.out.println("Enter Amount Of Deposit You Want To Deposit");
        amount_Of_Deposit = input.nextDouble();
        BankAccount ba = new BankAccount(balance,
                monthly_Ser_Charge,annual_Int_Rate);
        System.out.println("After Calling Deposit");
        ba.deposit(amount_Of_Deposit);
        System.out.println("Enter Amount Of Withdraw you Want To Withdraw");
        amount_Of_Withdraw = input.nextDouble();
        System.out.println("After Calling Withdraw");
        ba.withdraw(amount_Of_Withdraw);
        System.out.println("\nTesting Savings Account Class");
        System.out.println("Enter Your Balance");
        balance = input.nextDouble();
        System.out.println("Enter Interest Rate");
        annual_Int_Rate = input.nextDouble();
        System.out.println("Enter Monthly Charges");
        monthly_Ser_Charge = input.nextDouble();
        System.out.println("Enter Amount Of Deposit You Want To Deposit");
        amount_Of_Deposit = input.nextDouble();
        SavingsAccount sa = new SavingsAccount(balance,monthly_Ser_Charge,annual_Int_Rate);
        System.out.println("After Calling Deposit");
        sa.deposit(amount_Of_Deposit);
        System.out.println("Enter Amount Of Withdraw you Want To Withdraw");
        amount_Of_Withdraw = input.nextDouble();
        System.out.println("After Calling Withdraw");
        sa.withdraw(amount_Of_Withdraw);

    }
}
