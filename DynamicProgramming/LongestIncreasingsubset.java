import java.util.Arrays;

public class LongestIncreasingsubset {

    public static int tabulation (int[] nums , int[] dp){
        int n = nums.length ;
        for (int i = 0; i < n; i++) {
            int bestofPrev = 0 ;
            for (int j = i-1; j >= 0; j--) {

                if (nums[i] > nums[j]){
                    bestofPrev = Math.max(bestofPrev , dp[j]);

                }
                dp[i] = bestofPrev + 1;

                
            }
            
        }

        int maxi = 0 ;
        for (int i = 0; i < n; i++) {

            maxi = Math.max (dp[i],maxi);
            
        }

        System.out.println(Arrays.toString(dp));

        return maxi ;
    }

    public static void main(String[] args) {
       
        int[] nums = {10 , 9 , 2 , 5 ,3 ,7 ,  101 , 10};
        int[] dp = new int[nums.length] ;
        System.out.println(tabulation(nums, dp));
    }
    
}
