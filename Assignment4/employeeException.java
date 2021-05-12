package Assignment4;
/**
 * @author Jay Patel
 * @version 1.0
 */

public class employeeException extends Exception {
    /*
    variables employeeID to print employee's id number and
    payRate will have the per hour pay of the employee.
     */
    private String employeeId;
    private double payRate;

    //Default constructor
    employeeException(){
        employeeId=null;
        payRate=0.00;
    }

    //Parameterized constructor
    /**
     *
     * @param employeeId - String value
     * @param payRate - Double value
     */
    employeeException(String employeeId,double payRate){
        this.employeeId=employeeId;
        this.payRate=payRate;
    }

    /**
     *
     * @return -String value
     */
    //Will print the employee id and payRate
    public String toString(){

        return "Employee ID: " +employeeId+", Pay Rate: $"+payRate;
    }
}
