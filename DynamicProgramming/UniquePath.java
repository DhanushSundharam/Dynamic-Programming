class UniquePath {
    public static void main(String[] args) {
        int[][] gird = {{0,0,0},{0,0,0},{1,0,0}};
        System.out.println(uniquePathsWithObstacles(gird));
    }
    public static int recur (int[][] arr , int i , int j){
        
        int n = arr.length ;
        int m = arr[0].length ;
        if ( i == n || j == m){
            return 0 ;
        }
        if (arr[i][j] == 1){
            return 0 ; 
        }
        if ( i == n-1 && j == m-1){
            return 1 ;
        }

        int right  = recur(arr, i, j+1);
        int down = recur(arr, i+1, j);

        return right + down ;
    } 

    public static int memo (int[][] arr , int i , int j  , int[][] dp){
        int n = arr.length ;
        int m = arr[0].length ;
        if ( i == n || j == m){
            return 0 ;
        }
        if (arr[i][j] == 1){
            return 0 ; 
        }
        if ( i == n-1 && j == m-1){
            return 1 ;
        }

        if (dp[i][j] != 0){
            return dp[i][j];
        }

        int right  = memo(arr, i, j+1,dp);
        int down = memo(arr, i+1, j,dp);

        return dp[i][j] = right + down ;
    }

    public static int tabulation (int[][] arr , int[][] dp){
        int n = arr.length ;
        int m = arr[0].length ;
        for (int i = n-1; i >=0; i--) {
            for (int j = m-1; j >= 0; j--) {
                
                if (arr[i][j] == 1){
                    continue ;
                    
                }
                if ( i == n-1 && j == m-1){
                    dp[i][j] = 1 ;
                    continue ;
                }
        
               
        
                int right  = j+1 < n ? dp[i][j+1] : 0;
                int down =  i+1 < m ? dp[i+1][j] : 0;
        
                dp[i][j] = right + down ;
                
            }
            
        }
        return dp[0][0];
    }

    public static int uniquePathsWithObstacles (int[][]  arr){
        int[][] dp = new int[arr.length][arr[0].length];
        return tabulation(arr, dp);
    }
}