import java.util.Arrays;

public class MaximumSum {

    public static int maximumSum (int[] nums) {
        int[] ans = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] <= nums[i]) {
                    ans[i] += nums[j];
                }
            }
        }
        
        int maxi = 0 ;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > maxi){
                maxi = ans[i];
            }
            
        }
        return maxi ;
    }

    public static int maxSumIs (int arr[] , int n){
        int[] dp = new int[n];

        dp[0] = arr[0];

        for (int i = 0; i < n; i++) {
            int bestOfPrev = 0 ;
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] < arr[i]){
                    bestOfPrev = Math.max(bestOfPrev ,dp[j]);
                }
                
            }

            dp[i] = bestOfPrev + arr[i] ;
            
        }
        int  maxi = 0 ;
        for (int i = 0; i < n; i++) {

            maxi = Math.max(maxi, dp[i]);
            
        }
        return maxi ;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,101,2,3,100,4,5,6} ;
        System.out.println(maximumSum(arr));
        
    }
    
}
