public class PalindromicSubstring {

    public static boolean recur (String s , int sp ,int ep){
        if (sp == ep) return true ;
        if (sp > ep) return true ;

        if (s.charAt(sp) != s.charAt(ep)) return false ;

        return recur(s, sp+1, ep-1);
    }

    public static boolean memo(String s , int sp ,int ep,int[][] dp){
        if (sp == ep) return true ;
        if (sp > ep) return true ;

        if (dp[sp][ep] != 0) return dp[sp][ep] == 1  ;



        if (s.charAt(sp) != s.charAt(ep)) return false ;

        dp[sp][ep] = memo(s, sp + 1, ep - 1, dp) ? 1 : 1 ;

        return dp[sp][ep] == 1  ;
    }

    public static int countSubString(String s){
        int cnt = 0 ;
        int n = s.length() ;

        // generate all the substring 
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                boolean isPali = recur (s , i , j );
                if (isPali){
                    cnt++;
                }
                
            }
            
        }

        return cnt ;
    }

    public static int tabulation (String s){
        int n = s.length() ;
        boolean[][] dp = new boolean[n][n] ;

        for(int gap = 0 ; gap < n ; gap++){
            for (int sp = 0 , ep = gap ; ep < n ; sp++ , ep++){
                if (gap == 0){
                    dp[sp][ep] = true ;
                }
                else if (gap == 1){
                    dp[sp][ep] = s.charAt(sp) == s.charAt(ep);
                }
                else{
                    if (s.charAt(sp) == s.charAt(ep)){
                        dp[sp][ep] = dp[sp+1][ep-1];
                    }
                }

            }
        }

        int cnt = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] = true){
                    cnt++;
                }
                
            }
            
        }

        return cnt ;
    }
    public static void main(String[] args) {
        
        String s = "aba";
        int[][] dp = new int[s.length()][s.length()];
        System.out.println(countSubString(s));
    }
    
}
