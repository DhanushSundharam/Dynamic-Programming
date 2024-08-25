import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1,10,2,4,10,5,6,1};

        System.out.println(rob(nums));
    }

    public static int recur (int[] arr , int i){
        if (i >= arr.length) return 0 ;

        int inc = arr[i] + recur(arr,i+2);
        int exc = recur(arr, i+1);

        return Math.max(inc, exc);
    }

    public static int memo (int[] arr , int i , int[] dp){
        if (i >= arr.length){
            return 0 ;
        }

        if (dp[i] != -1){
            return dp[i];
        }

        int inc = arr[i] + memo(arr, i+2 ,dp);
        int exc = memo(arr, i + 1 ,dp);

        dp[i] = Math.max(inc, exc);


        return dp[i];
    }

    public static int tabulation (int[] arr, int[] dp){
        for (int i = arr.length-1; i >= 0; i--) {
            
    
           
    
            int inc = arr[i] + (i+2 >= arr.length ? 0 : dp[i+2]);
            int exc = (i+1 >= arr.length ? 0 : dp[i+1]);
    
            dp[i] = Math.max(inc, exc);
    
    
           

            
        }
        return dp[0];
    }

    public static int spaceOpti (int[] nums){
        int previnc = 0 ;
        int prevexc = 0 ;
        for (int i = 0; i < nums.length; i++) {
            
            int currInc = nums[i] + prevexc ;
            int currExc = Math.max(previnc , prevexc);

            //This ith house will become prev for the 
            // next house, so update variables
            previnc = currInc ;
            prevexc = currExc ;

            
        }

        return Math.max(previnc , prevexc);
    }

    public static int rob (int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return spaceOpti(nums);
    }
    
}
