import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        int n = 4 ;
        int w = 8 ;
        int[] values = {2,3,1,4};
        int[] weight = {3,4,6,5};

        System.out.println(knapSack(w, weight, values, n));
    }

    static int recur(int[] val , int[] wt , int i , int rewt){
        if (rewt < 0) return Integer.MIN_VALUE ;
        if (rewt == 0) return 0 ;
        if (i == val.length) return 0 ;

        int include = recur(val, wt, i+1, rewt - wt[i]) + val[i];
        int exclude = recur(val, wt, i+1, rewt);

        return Math.max(include, exclude);
    }

    static int memo (int[] val , int[] wt , int i , int rewt , int[][] dp){

        if (rewt < 0) return Integer.MIN_VALUE ;
        if (rewt == 0) return 0 ;
        if (i == val.length) return 0 ;

        if (dp[i][rewt] != -1){

            return dp[i][rewt];

        }

        int include = memo(val, wt, i+1, rewt - wt[i] , dp) + val[i];
        int exclude =  memo(val, wt, i+1, rewt ,dp);

        return dp[i][rewt] = Math.max(include, exclude);
        
    }

    static int tabulation (int[] val , int[] wt , int[][] dp , int W){
        int n = val.length ;
        for (int i = n-1; i >= 0; i--) {
            for (int rewt = 0; rewt <= W; rewt++) {


    
        if (rewt == 0) {
            dp[i][rewt] = 0;
            continue ;
        }
        
    


        int include = val[i];
        if (rewt - wt[i] < 0) {
            include = Integer.MAX_VALUE ;
        }
        else if (i+1 == n || rewt - wt[i] == 0) {
            include += 0;

        }
        else {
            include += dp[i+1][rewt-wt[i]];
        }

        int exclude = i+1 < n ?  dp[i+1][rewt] : 0;

        dp[i][rewt] = Math.max(include, exclude);
        

                
            }
            
        }

        return dp[0][W];
    }

    public static int tabulationmethod (int[] val , int[] wt , int n , int w , int[][] dp){
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }


        for (int i = 0; i < 1; i++) {
            for (int j = 1; j <= w; j++) {

                if (j<wt[i]){
                    dp[i][j] = i-1 >= 0 ? dp[i-1][j] : 0;
                }else{
                    int include =  dp[i][j - wt[i]] ;
                    int exclude = i-1 > 0 ? dp[i-1][j] : 0 ;
                    dp[i][j] = Math.max(include ,val[i] + exclude);
                }

                
                
            }
            
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {

                if (j<wt[i]){
                    dp[i][j] =  dp[i-1][j] ;
                }else{
                    int include = val[i] + dp[i-1][j - wt[i]] ;
                    int exclude = dp[i-1][j] ;
                    dp[i][j] = Math.max(include , exclude);
                }

                
                
            }
            
        }
        return dp[n-2][w];

    }

    static int knapSack (int W , int[] wt , int[] val , int n){
        int[][] dp =  new int[n][W+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            
        }
        
        tabulationmethod(val, wt, n, W, dp);
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
            
        }
        return 0 ;
    }
    
}
