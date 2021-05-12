package Assignment4;

/**
 * @author Jay Patel
 * @version 1.0
 */

public class employee {
    /*
   variables ID number will print employee's id number and
   hourlyWage will have the per hour pay of the employee.
    */
    private String idNumber;
    private double hourlyWage;

    //Default constructor
    employee(){
        idNumber=null;
        hourlyWage=0.00;
    }

    //Parameterized constructor
    /*  It will check if the entered value of the hourly wage. If, it is less than 6.00
         or greater than 50.00 than it will throw new exception using employeeException class
         which will print the message to the employee or else show message no problem.   */
    /**
     *
     * @param idNumber - String value
     * @param hourlyWage - Double value
     * @throws employeeException - throw an exception if the conditions matches
     */
    employee(String idNumber,double hourlyWage) throws employeeException{
       if (hourlyWage< 6.00 || hourlyWage> 50.00){
           throw new employeeException(idNumber,hourlyWage);
       }else {
           System.out.println("No Problem!=> Employee ID: " +idNumber+", Pay Rate: $"+ hourlyWage);
        }
        }
    }
