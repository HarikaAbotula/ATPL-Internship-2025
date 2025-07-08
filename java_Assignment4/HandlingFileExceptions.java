import java.io.*;
public class HandlingFileExceptions{
    public static void main(String args[]){
        loadFile("password.txt");
    }
    public static void loadFile(String fileName){
        try{
            FileInputStream fi=new FileInputStream(fileName);
            int ch;
            System.out.println("Content of the file: ");
            while((ch=fi.read())!=-1){
                System.out.print((char)ch);
            }
            fi.close();
        }
        catch(FileNotFoundException fnf){
            System.out.println("File not found,ensure the file exists");
        }
        catch(IOException ie){
            System.out.println("Error occured while reading the file");
        }

    }
} 