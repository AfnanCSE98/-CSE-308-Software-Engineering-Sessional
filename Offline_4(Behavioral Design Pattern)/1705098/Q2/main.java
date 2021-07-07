import java.util.*;
import java.io.*;

public class main {
  public static void main(String[] args) {
      org jwsa_ = new jwsa("WATER");
      org jpdc_ = new jpdc("POWER");
      org jrta_ = new jrta("TRANSPORT");
      org jtrc_ = new jtrc("TELECOM");

      mediator_org m_org = new mediator_org(4);

      m_org.add_org(jwsa_);
      m_org.add_org(jpdc_);
      m_org.add_org(jrta_);
      m_org.add_org(jtrc_);

      Scanner sc = new Scanner(System.in);
      String init = sc.nextLine();
      String data;
      String[] commands;
      if(init.equalsIgnoreCase("Init")){
        while(true){
          data = sc.nextLine();
          commands = data.split(" ");
          if(commands[0].equalsIgnoreCase("JWSA")){
            if(commands[1].equalsIgnoreCase("SERVE")){
              jwsa_.serve();
            }
            else{
              jwsa_.request(commands[1]);
            }
          }
          else if(commands[0].equalsIgnoreCase("JPDC")){
            if(commands[1].equalsIgnoreCase("SERVE")){
              jpdc_.serve();
            }
            else{
              jpdc_.request(commands[1]);
            }
          }
          else if(commands[0].equalsIgnoreCase("JRTA")){
            if(commands[1].equalsIgnoreCase("SERVE")){
              jrta_.serve();
            }
            else{
              jrta_.request(commands[1]);
            }
          }
          else if(commands[0].equalsIgnoreCase("JTRC")){
            if(commands[1].equalsIgnoreCase("SERVE")){
              jtrc_.serve();
            }
            else{
              jtrc_.request(commands[1]);
            }
          }
        }
      }
      /*
      jwsa_.request("POWER");
      jrta_.request("POWER");
      jpdc_.request("TELECOM");
      jpdc_.serve();
      jpdc_.serve();
      jpdc_.request("WATER");
      jrta_.request("WATER");
      jwsa_.serve();
      jwsa_.serve();
      jtrc_.serve();
      */
  }
}
