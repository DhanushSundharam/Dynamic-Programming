public class CoinChange {

    public static int recur (int[] coins , int amount){
        //Base Case 
        if (amount == 0 ){
            return 0 ;
        }
        if (amount < 0){
            return Integer.MAX_VALUE ;
        }
        // i have to return the min number
        // of coinsi need to make amt 

        int ans = Integer.MAX_VALUE ;
        for (int coin : coins) {

            int remSum = amount - coin ;
            int countSum = recur(coins, remSum);
            ans = Math.min(countSum, ans);

            
        }
        return ans + 1 ;

    }

    public static int memo (int[] coins , int amount , int[] dp){
        //Base Case 
        if (amount == 0 ){
            return 0 ;
        }
        if (amount < 0){
            return Integer.MAX_VALUE ;
        }
        // i have to return the min number
        // of coinsi need to make amt 

        if (dp[amount] != 0){
            return dp[amount];
        }

        int ans = Integer.MAX_VALUE ;
        for (int coin : coins) {

            int remSum = amount - coin ;
            int countSum = memo(coins, remSum ,dp);
            ans = Math.min(countSum, ans);

            
        }
        return dp[amount] = ans + 1 ;

    }

    public static int tabulation (int[] coins , int[] dp , int amount){
        for (int i = 0; i <= amount; i++) {
            //Base Case 
        if (i == 0 ){
            dp[i] =  0 ;
            continue ;
        }
        

        int ans = Integer.MAX_VALUE ;
        for (int coin : coins) {

            int remSum = amount - coin ;
            int countSum = remSum >=0 ? dp[remSum] : Integer.MAX_VALUE ;
            ans = Math.min(countSum, ans);

            
        }
        dp[i] = ans + 1 ;

       
        }
        return dp[amount];
    }


    public static int coinChange (int[] coins , int amount){
        int[] dp = new int[amount+1];
        int ans = recur(coins, amount);
        if (ans >= Integer.MAX_VALUE){
            return -1 ;
        }
        return ans ;

    }
    
}
