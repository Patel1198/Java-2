package Inheritance;

/**
 * @author Jay Patel
 * @version 1.0
 *
 */
public class SavingsAccount extends BankAccount {
    private Boolean status;
    SavingsAccount(double balance,double monthly_Ser_Charge,
                   double annual_Int_Rate){
        super(balance, monthly_Ser_Charge, annual_Int_Rate);
        if(getBalance()<50){
            status = false;
        }else {
            status = true;
        }
    }
    //methods
    public void deposit(double amount_Of_Deposit){
        super.deposit(amount_Of_Deposit);
        if (status==false && getBalance() > 50){
        status=true;
        }
    }
    public void withdraw(double amount_Of_Withdraw){
        if (status==false){
            System.out.println("Sorry!! No withdrawals allowed As Your Account is deactivated. ");
            System.out.println("Number Of Deposits : " +getNum_Of_Deposit()+
                    "; Number Of Withdraws : " +getNum_Of_Withdrawals()+
                    "; Balance : " +getBalance());
        }else{
            super.withdraw(amount_Of_Withdraw);
            if (getBalance()<50){
                status=false;
            }
        }
    }
}
