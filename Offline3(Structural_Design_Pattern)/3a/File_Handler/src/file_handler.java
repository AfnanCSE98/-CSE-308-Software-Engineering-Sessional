import java.io.*;
public class file_handler{
   
    public void calculate_sum(String fname) throws Exception{
        File file = new File(fname);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = br.readLine();
        String [] nums = s.split(" ");
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=Integer.parseInt(nums[i]);
        }
        System.out.println(sum);
    }

} 