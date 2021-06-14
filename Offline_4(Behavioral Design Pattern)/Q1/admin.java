//## To compile all java files in a directory,run in terminal
//find -name "*.java" > filenames.txt
//javac @filenames.txt
import java.util.Scanner;
import java.io.*;
import java.net.*;
public class admin {
public static void main(String[] args) {
try{
  Socket s=new Socket("localhost",6666);
  while(s.isConnected()){

    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    dout.writeUTF(str);
    dout.flush();

  }

}
    catch(Exception e){
      System.out.println(e);
    }
  }
}
