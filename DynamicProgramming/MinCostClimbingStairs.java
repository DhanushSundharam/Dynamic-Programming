import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {

        int[] cost = {10,15,20};

        System.out.println(minCostClimbingStairs(cost));
        
    }

    public static int recur (int[] cost , int i){
        if (i == cost.length){
            return 0 ; // already on top 
        }
        if ( i > cost.length) {
            return (int)1e9; // i have exceeded
        }

        int ip1 = recur(cost, i+1);
        int ip2 = recur(cost, i+2);

        return Math.min(ip1+cost[i], ip2+cost[i]);

    }
    public static int memo (int[] cost , int i , int[] dp){

        if (i == cost.length){
            return 0 ;

        }
        if (i > cost.length){
            return (int)1e9 ;
        }

        if (dp[i] != -1){
            return dp[i];
        }

        int ip1 = memo (cost , i + 1 , dp);
        int ip2 = memo (cost , i + 2 , dp);

        dp[i] = Math.min(ip1 + cost[i] , ip2 + cost[i]);
        return dp[i];





    }

    public static int tabulation (int[] cost , int[] dp){
        for (int i = cost.length - 1; i >= 0; i--) {

            // if (i == cost.length){
            //     return 0 ;
    
            // }
            // if (i > cost.length){
            //     return (int)1e9 ;
            // }
    
           
    
            int ip1 = i+1 == cost.length ? 0 : dp[i+1]; //memo (cost , i + 1 , dp);
            int ip2 ; //memo (cost , i + 2 , dp);
            if (i+2 == cost.length) ip2 = 0 ;
            else if (i+2 > cost.length) ip2 =  (int)1e9;
            else ip2 = dp[i+2];
    
            dp[i] = Math.min(ip1 + cost[i] , ip2 + cost[i]);
          
    


            
        }
        return Math.min(dp[0], dp[1]);
    }

    public static int spaceOpti (int[] cost){
        
        for (int i = cost.length-1; i >= 0; i--) {
            int ip1 = i+1 == cost.length ? 0 : cost[i+1] ;
            int ip2 ;
            if (i+2 == cost.length){
                ip2 = 0 ;
            }
            else if (i+2 > cost.length){
                ip2  = (int)1e9 ;
            }
            else {
                ip2 = cost[i+2];
            }
            

        

            int current = Math.min(ip1, ip2) + cost[i];
            ip2 = ip1 ;
            ip1 = current ;

            if (i == 0){
                return Math.min(ip1 , ip2) ;
            }

            
        }

        return 0 ;


    }

    public static int minCostClimbingStairs (int[] cost){
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return spaceOpti(cost);


        //return Math.min(memo(cost, 0,dp),memo(cost, 1,dp));

    }
    
}
