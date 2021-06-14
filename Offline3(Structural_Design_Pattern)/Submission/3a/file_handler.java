import java.io.*;
public class file_handler{

    private String f_name;
    public file_handler(String fnm){
      f_name = fnm;
    }

    public void calculate_sum() throws Exception{
        File file = new File(f_name);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = br.readLine();
        String [] nums = s.split(" ");
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=Integer.parseInt(nums[i]);
        }
        System.out.println("The sum is : ");
        System.out.println(sum);
    }

}
