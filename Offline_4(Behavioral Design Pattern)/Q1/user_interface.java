import java.io.*;
import java.net.*;

public class user_interface {
public static void main(String[] args){
try{
  int port = 6666;//Integer.parseInt(args[0]);
  ServerSocket ss=new ServerSocket(port);
  Socket s=ss.accept();//establishes connection
    while(s.isConnected()){
      DataInputStream dis=new DataInputStream(s.getInputStream());
      String  str=(String)dis.readUTF();
      System.out.println("message= "+str);
    }
}
  catch(Exception e){System.out.println(e);
  }
}
}
