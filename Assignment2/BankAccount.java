package Inheritance;

/**
 * @author Jay Patel
 * @version 1.0
 *
 */
public class BankAccount {
    //Variables
    private double balance;
    private int num_Of_Deposit;
    private int num_Of_Withdrawals;
    private double annual_Int_Rate;
    private double monthly_Ser_Charge;
    //Default Constructor
    BankAccount(){
        balance = 0.0;
        num_Of_Deposit = 0;
        num_Of_Withdrawals = 0;
        annual_Int_Rate = 0.0;
        monthly_Ser_Charge = 0.0;
    }
    //Parameterized Constructor
    BankAccount(double balance,double monthly_Ser_Charge,
                double annual_Int_Rate){
        this.balance = balance;
        this.monthly_Ser_Charge = monthly_Ser_Charge;
        this.annual_Int_Rate = annual_Int_Rate;
    }
    //accessor methods

    /**
     *
     * @return Balance- double value
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     *
     * @return Number Of Deposit - int value
     */
    public int getNum_Of_Deposit()
    {
        return num_Of_Deposit;
    }

    /**
     *
     * @return Number of Withdrawals - int value
     */
    public int getNum_Of_Withdrawals() {

        return num_Of_Withdrawals;
    }

    /**
     *
     * @return Annual Interest Rate - double value
     */
    public double getAnnual_Int_Rate()
    {
        return annual_Int_Rate;
    }

    /**
     *
     * @return Monthly Service Charge - double value
     */
    public double getMonthly_Ser_Charge()
    {
        return monthly_Ser_Charge;
    }
    // mutator methods

    /**
     *
     * @param balance - double value
     */
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    /**
     *
     * @param num_Of_Deposit - int value
     */
    public void setNum_Of_Deposit(int num_Of_Deposit)
    {
        this.num_Of_Deposit = num_Of_Deposit;
    }

    /**
     *
     * @param num_Of_Withdrawals - int value
     */
    public void setNum_Of_Withdrawals(int num_Of_Withdrawals)
    {
        this.num_Of_Withdrawals = num_Of_Withdrawals;
    }

    /**
     *
     * @param annual_Int_Rate - double value
     */
    public void setAnnual_Int_Rate(double annual_Int_Rate) {

        this.annual_Int_Rate = annual_Int_Rate;
    }

    /**
     *
     * @param monthly_Ser_Charge - double value
     */
    public void setMonthly_Ser_Charge(double monthly_Ser_Charge) {

        this.monthly_Ser_Charge = monthly_Ser_Charge;
    }
    // methods

    /**
     *
     * @param amount_Of_Deposit -double value
     */
    public void deposit(double amount_Of_Deposit){
        balance += amount_Of_Deposit;
        num_Of_Deposit++;
        System.out.println("Number Of Deposits : "+getNum_Of_Deposit() +
                "; Number Of Withdraws : "+getNum_Of_Withdrawals()+"; Balance : " + getBalance());
    }

    /**
     *
     * @param amount_Of_Withdraw - double value
     */
    public void withdraw(double amount_Of_Withdraw){
        if (balance < amount_Of_Withdraw){
        System.out.println("Sorry! Your Balance is too low for this withdrawal!");
        }else
        {
            balance -= amount_Of_Withdraw;
            num_Of_Withdrawals++;
            if (balance<50)
                System.out.println("Your Account balance is to low.\n" +
                        "And if you will not deposit a few money within few months then " +
                        "your account will be deactivated within 45 days.");
        }
        System.out.println("Number Of Deposits : " +getNum_Of_Deposit()+
                "; Number Of Withdraws : " +getNum_Of_Withdrawals()+
                "; Balance : " +getBalance());
    }
    public double calcInterest(){
        double monthly_Int_Rate,monthly_Interest;
        monthly_Int_Rate = annual_Int_Rate/12;
        monthly_Interest = balance*monthly_Int_Rate;
        balance += monthly_Interest;
        return balance+monthly_Interest;
    }
    public void monthlyProcess(){
        balance -= monthly_Ser_Charge;
        calcInterest();
        num_Of_Withdrawals=0;
        num_Of_Deposit=0;
        monthly_Ser_Charge=0.0;
    }

}
