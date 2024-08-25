class ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(climbStairs(3));
        
    }
    public static int recur (int n){
        if (n == 0 || n == 1) return 1 ;

        int nm1 = recur(n-1);
        int nm2 = recur(n-2);
        int ans = nm1 + nm2 ;
        return ans ;
    }
    public static int memo (int n , int[] dp){
        if (n == 0 || n == 1) return 1 ;
        // check if i already have the answer
        if (dp[n] != 0) return 1 ;

        int nm1 = memo(n-1,dp);
        int nm2 = memo(n-2,dp);
        int ans = nm1 + nm2 ;
        dp[n] = ans ; // remember before return
        return ans ;
    }

    public static int tabulation (int n ,int[] dp){
        for (int i = 0; i <= n; i++) {

            if (i == 0 || i == 1){
                dp[i] = 1 ;
                continue ;
            }

    
            int nm1 = dp[i-1];
            int nm2 = dp[i-2];
            int ans = nm1 + nm2 ;
            dp[i] = ans ; 
            

            
        }

        return dp[n];
    }

    public static int spaceOpti (int n){
        if (n<=1) return 1 ;
        int nm1 = 1 ;
        int nm2 = 1 ;

        for (int i = 2; i <= n; i++) {
            int curr = nm1 + nm2 ;
            if (i == n) return curr ;
            nm2 = nm1 ;
            nm1 = curr ;

            
        }

        return 0 ;
    }

    public static int climbStairs (int n){
        int[] dp = new int[n+1];
        
        return spaceOpti(n) ;

    }
}