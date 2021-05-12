/**
 * @author Jay Patel
 * @version 1.0
 */
package Assignment_File_Processing;
//import statements
import java.io.*;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class fileProcessing
{
    //method to write 10 random numbers of double data type between 0 and 1.
    public void toWr(){
        //try-catch will try the code and if any error occurred then throw an exception
        //otherwise just take and random numbers from 0 to 1.
    try
    {
        File fileT = new File("double.dat");
        FileOutputStream fos = new FileOutputStream(fileT);
        DataOutputStream data = new DataOutputStream(fos);

        for (int sub = 0; sub < 10; sub++ )
        {
            if (Math.random() < 1 && Math.random() > 0){
                Double num=Math.random();
                data.writeDouble(num);
                System.out.println("Writing  "+num +" in data");
            }

        }

        fos.close();
    }
    catch(IOException e)
    {
        System.out.println("Error: " + e.getMessage());
    }
    System.out.println("Writing finished.");
}
    //method to read 10 random generated numbers of double data type between 0 and 1.
public void toRe(){
    System.out.println("Will read the data \n");
    //try-catch will try the code and if any error occurred then throw an exception
    //otherwise just show random generated numbers from 0 to 1.
    try
    {
        File fileI = new File("double.dat");
        FileInputStream fis = new FileInputStream(fileI);
        DataInputStream data = new DataInputStream(fis);

        try
        {
            Double num = data.readDouble();
            do {
                System.out.print(num+"\n");
                num = data.readDouble();
            }while (fis.available() != 1);
        }
        catch(EOFException eof)
        {
            System.out.println("");
            fis.close();
        }
    }
    catch(IOException e)
    {
        System.out.println("Error: " + e.getMessage());
    }
    System.out.println("read all the numbers.");
}
//method to delete the file
public void toDel(){
        File fileDel = new File("double.dat");
    System.out.println("Deleting file.");
    if (fileDel.exists() && fileDel.delete()){
        System.out.println("File deleted.");
    }
}
public static void main(String[] args) {
        //will call the methods and generate the 10 numbers.
    fileProcessing filePro = new fileProcessing();
    filePro.toWr();
    filePro.toRe();
    filePro.toDel();
    }
}
