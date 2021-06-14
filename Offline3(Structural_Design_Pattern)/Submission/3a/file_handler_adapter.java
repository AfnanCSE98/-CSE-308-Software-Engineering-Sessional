import java.io.*;
import java.util.*;

public class file_handler_adapter extends file_handler{
    private file_handler f_handler;

    public file_handler_adapter(String fnm){
      super(fnm);
      //modifying input file so that it contains ddigit instead of asciis if found
      String fnm_new="";
      try{
          fnm_new = create_new_file(fnm);
      }catch(Exception e){
        e.printStackTrace();
      }
      f_handler = new file_handler(fnm_new);
    }

    public void calculate_sum() throws Exception{
      f_handler.calculate_sum();
    }

    public String create_new_file(String fnm) throws Exception{
      File file = new File(fnm);
      BufferedReader br = new BufferedReader(new FileReader(file));
      String s = br.readLine();
      String [] vals = s.split(" ");

      //creating new file
      int n;char ch;
      String new_f_name = "input_adapter.txt";
      BufferedWriter output = null;
      try {
          File new_file = new File(new_f_name);
          FileWriter fw = new FileWriter(new_file);
          output = new BufferedWriter(fw);
          for(int i=0;i<vals.length;i++)
          {

            if(isNumeric(vals[i])){
              output.write(vals[i]+" ");
            }
            else{
              ch = vals[i].charAt(0);
              n = (int)ch;
              output.write(Integer.toString(n));output.write(" ");
            }
          }
      } catch ( IOException e ) {
          e.printStackTrace();
      }

      output.close();
      return new_f_name;
    }

    public static boolean isNumeric(String inputData) {
      Scanner sc = new Scanner(inputData);
      return sc.hasNextInt();
    }
}
