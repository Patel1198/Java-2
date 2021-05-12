import java.util.Scanner;

public class TestCar {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int yearModel=0,speed=0;
        String make=null;
        System.out.println("enter the year model");
        yearModel=input.nextInt();
        System.out.println("enter the current speed of the car");
        speed=input.nextInt();
        System.out.println("enter maker of the car");
        make=input.next();

        try {
            Car myCar= new Car(yearModel,make,speed);
            System.out.println(myCar.toString());
            myCar.accelerate();
            myCar.accelerate();
            myCar.accelerate();
            System.out.println();
            myCar.brake();
            myCar.brake();
            myCar.brake();
        }catch (IllegalArgumentException msg){
            System.out.println(msg.getMessage());
        }
    }
}
