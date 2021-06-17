import java.io.*;
import java.net.*;
import java.util.*;

public class client {

    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;
    private static Scanner input;
    private static List<stock>stock_list;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost",9000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            input = new Scanner(System.in);
            out = new PrintWriter(socket.getOutputStream(),true);
            stock_list = new ArrayList<stock>();

            readFile("input.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }



        Thread t = new Thread(()->receive());t.start();
        while(true) {
            System.out.println("Enter your command: ");
            String msg = input.nextLine();
            out.println(msg);

            if (msg.equals("quit")){
                break;
            }

        }

    }


    private static void receive() {
        while(true){
            try {
                String returnMessage = in.readLine();
                System.out.println(returnMessage);
            }
            catch(Exception e)
            {
                System.out.println("Could not receive msg");
            }
        }
    }

    private static void readFile(String f_name) {
      FileInputStream fstream;
      BufferedReader br ;
      try{
        fstream = new FileInputStream(f_name);
        br = new BufferedReader(new InputStreamReader(fstream));

        String str;
        int cnt;double price;
        System.out.println("Stocks , Count and Prices :");
        while ((str = br.readLine()) != null)   {
          String[] info = str.split(" ");
          cnt = Integer.parseInt(info[1]);
          price = Double.parseDouble(info[2]);
          stock s = new stock(info[0] , cnt , price);
          stock_list.add(s);
          System.out.println(info[0] + "  " + info[1] + "  " + info[2]);
        }

        //Close the input stream
        fstream.close();
      }
      catch(Exception e){e.printStackTrace();}
    }
}
