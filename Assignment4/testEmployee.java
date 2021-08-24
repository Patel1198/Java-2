package Assignment4;

import java.util.Scanner;
// this is test class to test the employee and employeeException class.
public class testEmployee {
    public static void main(String[] args) {
        /* 
            this try-catch blocks will take the id number and hourlyWage and
            catch an exception if the value of the hourlyWage is less than 6.00
            or greater than 50.00.

        */
        try {
            employee ep =new employee("111",112.56);
        }catch (employeeException e){
            System.out.println("Employee error: " + e);
        }

        try {
            employee ep =new employee("222",2.56);
        }catch (employeeException e){
            System.out.println("Employee error: " + e);
        }
        try {
            employee ep =new employee("333",12.56);
        }catch (employeeException e){
            System.out.println("Employee error: " + e);
        }

    }
}
