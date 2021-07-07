import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TestCaseGenerator {
    private final Random random = new Random();
    private final int bound = 100000;
    private final int ara_size = 10000;

    public int[] blank_list(){
        return new int[]{};
    }

    public int[] one_number_list(){
        return new int[]{random.nextInt(bound)};
    }

    public int[] two_number_list(){
        return new int[]{random.nextInt(bound) , random.nextInt(bound)};
    }

    public int[] ranom_sized_list(){
        int sz = random.nextInt(bound);
        int ara[] = new int[sz];
        for(int i=0;i<sz;i++){
            ara[i] = random.nextInt(bound);
        }
        return ara;
    }

    public int[] random_numbers_list(){
        int sz = ara_size;
        int ara[] = new int[sz];
        for(int i=0;i<sz;i++){
            ara[i] = random.nextInt(bound);
        }
        return ara;
    }

    public int[] sorted_ascendingly(){
        int nums[] = random_numbers_list();
        Arrays.sort(nums);
        return nums;
    }

    public int[] sorted_descendingly(){
        int arr[] = random_numbers_list();
        int n = arr.length;
        int temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] < arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public int[] equal_number_list(){
        int num = random.nextInt(bound);
        int sz = ara_size;
        int ara[] = new int[sz];
        for(int i=0;i<sz;i++){
            ara[i] = num;
        }
        return ara;
    }




}
