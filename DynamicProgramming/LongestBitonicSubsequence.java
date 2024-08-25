public class LongestBitonicSubsequence {

    public int longestBitonicSubsequence (int[] nums){
        int n = nums.length ;

        int[] dp_l2r = new int[n];

        dp_l2r[0] = 1 ;
        for (int i = 0; i < n; i++) {
            int bestOfPrev = 0 ;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]){
                    bestOfPrev = Math.max(dp_l2r[j], bestOfPrev);
                }
                
            }

           dp_l2r[i] = bestOfPrev + 1;
             
        }

        int[] dp_r2l = new int[n];
        dp_r2l[n-1] = 1;
        for (int i = n-2; i >= 0; i++) {
            int bestOfPrev = 0 ;
            for (int j = i+1; j < n; j++) {
                if (nums[j] <  nums[i]){

                    bestOfPrev = Math.max(dp_r2l[j], bestOfPrev);

                }
               
                
            }

            dp_r2l[i] = bestOfPrev + 1;
            
        }
        int  ans = 0 ;
        for (int i = 0; i < n; i++) {
            int left = dp_l2r[i];
            int right = dp_r2l[i];

            int lenIfIMid = left + right - 1;
            ans = Math.max(ans,lenIfIMid);
            
        }

        return ans ;

    }
    
    
}
