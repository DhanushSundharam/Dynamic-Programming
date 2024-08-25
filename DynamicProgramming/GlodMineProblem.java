import java.util.Arrays;

public class GlodMineProblem {
    public static void main(String[] args) {
        
    }

    public static int recur (int[][] arr , int i , int j){
        int n = arr.length ;
        int m = arr[0].length ;

        if (i < 0 || j >= m || i>= n){
            return 0 ;
        }
        int diagUp = recur(arr, i-1, j+1);
        int right = recur(arr, i, j+1);
        int diagdown = recur(arr, i+1, j+1);

        return Math.max(right,Math.max(diagUp, diagdown)) + arr[i][j];

    }

    public static int memo (int[][] arr , int i , int j , int[][] dp){
        int n = arr.length ;
        int m = arr[0].length ;

        if (i < 0 || j >= m || i>= n){
            return 0 ;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }


        int diagUp = memo(arr, i-1, j+1 ,dp);
        int right = memo(arr, i, j+1 ,dp);
        int diagdown = memo(arr, i+1, j+1 ,dp);

        dp[i][j] = Math.max(right,Math.max(diagUp, diagdown)) + arr[i][j];

        return Math.max(right,Math.max(diagUp, diagdown)) + arr[i][j];

    }

    public static int maxGold (int n , int m ,int[][] arr){

        int[][] dp = new int[n][m];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
            
        }

        int maxi = 0 ;
        for (int i = 0; i < n; i++) {

            int goldICanGetifStartOnThisRow = memo(arr, i, 0,dp);
            maxi = Math.max(maxi, goldICanGetifStartOnThisRow);
            
        }

        return tabulation(arr, dp) ;

    }

    public static int tabulation (int[][] arr , int[][] dp){
        int n = arr.length ;
        int m = arr[0].length ;
        for (int j = m-1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                // base
                if (j == m-1){
                    dp[i][j] = arr[i][j];
                }else {
                    int diaUp = dp[i-1][j+1];
                    int right = dp[i][j+1];
                    int diagDown = dp[i+1][j+1];
                    dp[i][j] = Math.max(right , Math.max(diaUp, diagDown)) + arr[i][j];
                }
                
            }
            
        }
        int maxi  = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp[i][0]);
            
        }
        return maxi ;

    }
    
}
