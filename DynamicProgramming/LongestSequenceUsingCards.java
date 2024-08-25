import java.util.*;
public class LongestSequenceUsingCards {
    public static TreeSet<Integer> lengthOfLIS (int[] nums){

        TreeSet<Integer> ts = new TreeSet<>() ;
        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            Integer justBigger = ts.ceiling(x);

            if (justBigger != null){
                ts.remove(justBigger);
            }
            ts.add(x);
            System.out.println(ts);
            
        }

        return ts ;
        
    }

    public static void main(String[] args) {
        int[] nums = {10,5,8,3,9,4,12,11} ;

        System.out.println(lengthOfLIS(nums));
    }
    
}
