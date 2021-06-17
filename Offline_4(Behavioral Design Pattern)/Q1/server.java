import java.io.*;
import java.net.*;
import java.util.*;

public class server implements Runnable{

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean isLoggedIn;
    private String username;
    public static List<server> loggedInUsers;
    private static List<String> subscribed_to;
    private static List<stock>stock_list;
    private static observer ob;

    public server(Socket socket){

        this.socket = socket;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            ob.set_server(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String [] args){

        loggedInUsers = new ArrayList<server>();
        subscribed_to = new ArrayList<String>();
        stock_list = new ArrayList<stock>();

        readFile("input.txt");

        try {
            ServerSocket ss = new ServerSocket(9000);
            while (true){
                Socket sock = ss.accept();
                ob = new user();
                System.out.println("connected.");
                new Thread(new server(sock)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        loggedInUsers.add(this);

        while(true){
            try {
                String data = in.readLine();
                Manipulate(data);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public void Manipulate(String data){
        //msg sent by user

        char ch = data.charAt(0);
        if(ch=='S' || ch=='U'){
          sub_or_unsub(data);
        }
        //msg sent by admin(actually a client working as an admin)
        else if(ch=='I' || ch=='D' || ch=='C'){
          //extract stock_name
          String[] cmds = data.split(" ");
          String stock_name = cmds[1];
          modify_stock(data);

        }

    }


    public void sub_or_unsub(String data){
      String[] commands = data.split(" ");
      stock s = get_stock_obj(commands[1]);

      if(commands[0].equals("S")){
      //out.println("aaaaa");
        s.registerUser(ob);
        stock_stats();
      }
      else if(commands[0].equals("U")){
        //subscribed_to.remove(commands[1]);
        s.removeUser(ob);
      }
    }


    public void modify_stock(String data){
      String[] commands = data.split(" ");
      stock s = get_stock_obj(commands[1]);
      if(commands[0].equals("I") || commands[0].equals("D")){
        Change_Price(s , commands[2]);
      }
      else if(commands[0].equals("C")){
        Change_Count(s , commands[2]);
      }
    }

    public void Change_Price(stock s, String price){
      double new_price = Double.parseDouble(price);
      s.set_price(new_price);
    }

    public void Change_Count(stock s, String cnt){
      int new_cnt = Integer.parseInt(cnt);
      s.set_cnt(new_cnt);
    }

    private static void readFile(String f_name) {
      FileInputStream fstream;
      BufferedReader br ;
      try{
        fstream = new FileInputStream(f_name);
        br = new BufferedReader(new InputStreamReader(fstream));

        String str;
        int cnt;double price;
        //System.out.println("Stocks , Count and Prices :");
        while ((str = br.readLine()) != null)   {
          String[] info = str.split(" ");
          cnt = Integer.parseInt(info[1]);
          price = Double.parseDouble(info[2]);
          stock s = new stock(info[0] , cnt , price);
          stock_list.add(s);
          //System.out.println(info[0] + "  " + info[1] + "  " + info[2]);
        }

        //Close the input stream
        fstream.close();
      }
      catch(Exception e){e.printStackTrace();}
    }

    public PrintWriter get_printwriter(){
      return out;
    }

    public void stock_stats(){
      for(stock el : stock_list){
        System.out.print(el.get_name());
        System.out.println(el.get_subscribers_cnt());
      }
    }

    private stock get_stock_obj(String name){
      stock s=null;
      //System.out.println(stock_list.size());
      for(stock el : stock_list){
        if(el.get_name().equals(name)){
          s = el;
          break;
        }
      }
      return s;
    }
}
