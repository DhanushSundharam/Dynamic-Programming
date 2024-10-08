import java.util.Arrays;

public class LongestCommonSubstring {

    public static int recur(String s1 , String s2 , int i , int j , int asf){
        if ( i == s1.length() || j == s2.length()) return asf ;

        int inc = 0;

        if (s1.charAt(i) == s2.charAt(j)){

            inc = recur(s1, s2, i + 1, j + 1, asf + 1);

        }

        int excludeS2j = recur(s1, s2, i, j+1, 0);
        int excludeS1i = recur(s1, s2, i+1, j, 0);

        return Math.max(Math.max(asf, inc) , Math.max(excludeS1i, excludeS2j));
    }

    public static int memo(String s1 , String s2 , int i , int j , int asf , int[][][] dp){
        if ( i == s1.length() || j == s2.length()) return asf ;
        
        if(dp[i][j][asf] != -1) return dp[i][j][asf];

        int inc = 0;

        if (s1.charAt(i) == s2.charAt(j)){

            inc = memo(s1, s2, i + 1, j + 1, asf + 1,dp);

        }

        int excludeS2j = memo(s1, s2, i, j+1, 0,dp);
        int excludeS1i = memo(s1, s2, i+1, j, 0,dp);

        return dp[i][j][asf] = Math.max(Math.max(asf, inc) , Math.max(excludeS1i, excludeS2j));
    }

    public static int tabulation (String s1 , String s2 , int n , int m ){
        int[][] dp = new int[n+1][m+1];

        for (int i = n-1; i >= 0; i++) {
            for (int j =  m-1 ; j >= 0 ; j++) {

                if (s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                
            }
            
        }

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                maxi = Math.max(maxi, dp[i][j]);
                
            }
            
        }

        return maxi ;
    }



    public static int longestCommonSubstring(String s1 , String s2 , int n , int m){
        
        int[][][] dp = new int[n][m][Math.min(n, m)];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
                
            }
            
        }


        return recur (s1 , s2 , 0 , 0 , 0);
    }

    
}
