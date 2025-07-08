import java.io.*;
import java.util.Scanner;
public class TryWithResourcesScanner{
    
    public static void main(String args[]){
        scanFile("D://Git Repo//password.txt");
    }
    public static void scanFile(String fileName){
        try(Scanner sc=new Scanner (new File(fileName));){
            while(sc.hasNext()){
                System.out.println("Content of the file: "+sc.nextLine());
            }
        }
        catch(FileNotFoundException fne){
            System.out.println("Error reading the file: "+fne.getMessage());
        }
    }
}