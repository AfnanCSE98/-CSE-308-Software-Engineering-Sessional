import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
class BubbleSortTest {

    BubbleSort b = new BubbleSort();
    TestCaseGenerator t = new TestCaseGenerator();

    public boolean is_sorted(int nums[]){
        boolean neg = false;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
    public boolean is_freq_same(int[]num1 , int num2[]){
        if(num1.length != num2.length)return false;

        HashMap<Integer,Integer> h1 = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> h2 = new HashMap<Integer,Integer>();
        //for num1
        for(int i=0; i<num1.length; i++){
            if(h1.containsKey(num1[i])){
                h1.put(num1[i], h1.get(num1[i]) + 1);
            } else {
                h1.put(num1[i], 1);
            }
        }
        //for num2
        for(int i=0; i<num2.length; i++){
            if(h2.containsKey(num2[i])){
                h2.put(num2[i], h2.get(num2[i]) + 1);
            } else {
                h2.put(num2[i], 1);
            }
        }
        if(h1.equals(h2))return true;
        else return false;
    }
    @org.junit.jupiter.api.Test
    @DisplayName("sorting successful")
    void bubbleSort() {
        int nums[];
        nums = t.blank_list();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting blank_list failed");

        nums = t.one_number_list();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting one_number_list failed");

        nums = t.two_number_list();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting two_numbers_list failed");

        nums = t.ranom_sized_list();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting random_sized_list failed");

        nums = t.random_numbers_list();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting random_numbers_list failed");

        nums = t.sorted_ascendingly();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting sorted_list failed");

        nums = t.sorted_descendingly();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting descendingly_sorted_list failed");

        nums = t.equal_number_list();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting equal_number_list failed");

        nums = t.negative_numbers_list();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting equal_number_list failed");

        nums = t.pos_neg_list();
        assertTrue(is_sorted(b.sort(nums)) && is_freq_same(b.sort(nums) , nums), "Sorting equal_number_list failed");

    }
}