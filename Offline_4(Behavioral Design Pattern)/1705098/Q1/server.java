import java.io.*;
import java.net.*;
import java.util.*;

public class server implements Runnable{

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static List<stock>stock_list;

    public server(Socket socket){
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        stock_list = new ArrayList<stock>();
        readFile("input.txt");

        try {
            ServerSocket ss = new ServerSocket(9000);
            new Thread(()->takeinput()).start();
            while (true){
                Socket sock = ss.accept();
                System.out.println("connected.");
                new Thread(new server(sock)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void takeinput(){

      Scanner sc = new Scanner(System.in);
      while(true){
        System.out.println("Enter Command(I/D/C):");
        String cmd = sc.nextLine();
        modify_stock(cmd);
      }
    }

    @Override
    public void run() {
        String data=null;
          while(true){
            try{
              data = in.readLine();
              observer o = new user();
              o.set_server(this);
              if(data!=null)sub_or_unsub(data,o);
            }
            catch(Exception e){
              continue;
            }
          }
    }

    public void sub_or_unsub(String data,observer o){
      String[] commands = data.split(" ");
      stock s = get_stock_obj(commands[1]);

      if(commands[0].equalsIgnoreCase("S")){
        s.registerUser(o);
        //stock_stats();
      }
      else if(commands[0].equalsIgnoreCase("U")){
        s.removeUser(this);
        //stock_stats();
      }
    }


    public static void modify_stock(String data){
      String[] commands = data.split(" ");
      stock s = get_stock_obj(commands[1]);
      if(commands[0].equalsIgnoreCase("I")){
        Inc_Price(s , commands[2]);
      }
      else if(commands[0].equalsIgnoreCase("D")){
        Dec_Price(s , commands[2]);
      }
      else if(commands[0].equalsIgnoreCase("C")){
        Change_Count(s , commands[2]);
      }
    }

    public static void Inc_Price(stock s, String price){
      double n = Double.parseDouble(price);
      s.increase_price(n);
    }

    public static void Dec_Price(stock s, String price){
      double n = Double.parseDouble(price);
      s.decrease_price(n);
    }

    public static void Change_Count(stock s, String cnt){
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
    //debugging purpose
    public void stock_stats(){
      for(stock el : stock_list){
        System.out.print(el.get_name());
        System.out.println(el.get_subscribers_cnt());
        for(observer u : el.get_user_list()){
          System.out.println(u.get_server_obj());
        }
      }
    }

    private static stock get_stock_obj(String name){
      stock s=null;
      //System.out.println(stock_list.size());
      for(stock el : stock_list){
        if(el.get_name().equalsIgnoreCase(name)){
          s = el;
          break;
        }
      }
      return s;
    }
}
