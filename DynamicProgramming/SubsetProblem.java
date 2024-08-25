public class SubsetProblem {
    public static void main(String[] args) {
        int[] arr = {3,34,4,12,5,2};
        int N = 6 ;
        int Sum = 9;
        System.out.println(isSubsetSum(N, arr, Sum));
    }

    public static boolean recur (int[] arr , int i , int sum){
        if (sum == 0){
            return true ;

        }

        if (sum < 0){
            return false ;
        }
        if (i == arr.length){
            return false ;
        }

        boolean  come  = recur(arr, i+1, sum - arr[i]);
        boolean  dont = recur(arr, i+1, sum);

        return come || dont ;

    }

    public static boolean memo  (int[] arr , int i , int sum , int[][] dp){
        if (sum == 0){
            return true ;

        }

        if (sum < 0){
            return false ;
        }
        if (i == arr.length){
            return false ;
        }

        if (dp[i][sum] != 0){
            return dp[i][sum] == 1 ;
        }

        

        boolean  come  = memo(arr, i+1, sum - arr[i] ,dp);
        boolean  dont = memo(arr, i+1, sum , dp);

        dp[i][sum] = come || dont ? 1 : -1 ;

        return come || dont ;

    }
    
   
    

    public static boolean tabulation (int[] arr , boolean[][] dp  , int N , int Sum ){
        for (int i = 0; i < N ; i++) {
            // set true as 0th column in upto N+1 row in 0th column
            dp[i][0] = true ;
            
        }

        for (int i = 1; i < Sum + 1; i++) {

            if (arr[0] == i){

                dp[0][i] = true ;

            }
            else {
                dp[0][i] = false ;
            }

            
        }

        for (int i = 1; i < N ; i++) {
            for (int j = 1; j < Sum + 1; j++) {


                if (j  < arr[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]] ;
                }
                
            }
            
        }

        return dp[N-1][Sum];
    }

    public static boolean isSubsetSum (int N , int arr[] ,  int sum){
        //code here 

        boolean[][] dp = new boolean[N][sum+1];


       

        

        return tabulation(arr, dp, N, sum) ;

    }
    
}
