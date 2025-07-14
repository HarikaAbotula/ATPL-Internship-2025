 import java.io.*;
 public class CheckingFirstCharacter {
 	public static void main(String[] args)  {
 	    try{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			//br.read() is a method,to read just one character at a time from the input stream. First Character never printed because you don't print ch.
			int ch = bufferedReader.read();
			System.out.print((char)ch); // To print the first character
			while(bufferedReader.ready()){
				System.out.println(bufferedReader.readLine());
			}	
            bufferedReader.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
 }