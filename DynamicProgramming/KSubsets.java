import java.util.Arrays;

public class KSubsets {

    public static int countP (int n , int k){
        if (n==0 || k==0) return  0 ;
        if ( k > n) return 0 ;
        if ( n == 1 || n==k ) return 1 ;

        int alone = countP(n-1, k-1);

        int others = k * countP(n-1, k);
        return alone + others ;
    }

    public static int memo (int n , int k , int[][] dp){
        if (n == 0 || k == 0) return 0 ;
        if (k > n) return 0 ;
        if ( n == 1 || n == k) return 1 ;

        if (dp[n][k] != -1){
            return dp[n][k];
        }

        int alone  = memo(n-1, k-1 , dp);
        int others =  k * memo(n-1, k , dp);

        return dp[n][k] = alone + others ;


    }

    public static int tabulation (int N , int K , int[][] dp){
        for (int n = 0 ; n <= N ; n++){
            for (int k = 0 ; k <= K ; k++){

                    if (n == 0 || k == 0 || k > n) {
                        dp[n][k] = 0;
                        continue ;

                    } 
                  
                    if ( n == 1 || n == k) {
                        dp[n][k] = 1 ;
                        continue ;
                    }                  

                    int alone  = dp[n-1][k-1];
                    int others =  k * dp[n-1][k];

                    dp[n][k] = alone + others ;


            }
        }

        return dp[N][K];
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {

            Arrays.fill(dp[i], -1);
            
            
        }
        System.out.println(tabulation(n, k, dp));
    }
    
}
