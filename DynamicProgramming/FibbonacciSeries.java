import java.util.Arrays;

public class FibbonacciSeries {

    public static int fibbo (int n){
        if (n == 0){
            return 0 ;
        }
        if (n == 1){
            return 1;
        }

        int nm1 = fibbo(n-1);
        int nm2 = fibbo(n-2);

        int ans = nm1 + nm2 ;

        return ans ;
    }

    public static int memo (int n , int[] dp){
        if (n == 0){
            return 0 ;

        }
        if (n == 1){
            return 1 ;
        }

        if (dp[n] != -1){

            return dp[n];

        }

        int fmp1 = memo(n-1, dp);
        int fmp2 = memo(n-2, dp);
        
        dp[n] = fmp1 + fmp2 ;

        return dp[n];
        
    }

    // Memosiation to Tabulation
    public static int tabulation (int n , int[] dp){
        for (int i = 0; i < n; i++) {

            if (i == 0){
                dp[i] = 0 ;
                continue ;
    
            }
            if (i == 1){
                dp[i] = 1 ;
                continue ;
            }
    
           
    
            int fmp1 = dp[i-1];
            int fmp2 = dp[i-2];
            
            dp[i] = fmp1 + fmp2 ;
    
            
            
            
        }

        return dp[n-1];
    } 

    public static int spaceOpti (int n){
        int ip1 = 0 ;
        int ip2 = 1 ;

        for (int i = 2; i <= n; i++) {

            int curr = ip1 + ip2 ;
            ip2 = ip1 ;
            ip1 = curr ;
            
        }
        return ip1 ;

    }

    public static void main(String[] args) {
        int n = 5 ;
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);

        System.out.println(spaceOpti(n));
    }
    
}
