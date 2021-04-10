import java.io.*;

public class file_handler_adapter extends file_handler{
    private file_handler f_handler;

    public file_handler_adapter(file_handler fh){
        file_handler f_handler = fh;
    }

    public void calculate_sum(String fname) throws Exception{
        File file = new File(fname);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = br.readLine();
        String [] nums = s.split(" ");
        int sum = 0,n;
        char ch;
        for(int i=0;i<nums.length;i++){
            ch = nums[i].charAt(0);
            n = (int)ch;
            sum+=n;
        }
        System.out.println(sum);
    }
}