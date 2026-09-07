class Solution {
  static int helper2(String s, String t){
        int dp[][] = new int[1005][1005];   

        for(var a : dp) Arrays.fill(a,0);

        for(int i=0; i<=s.length(); i++){
            dp[i][t.length()]=1;
        }

        for(int idxS=s.length()-1; idxS>=0; idxS--){
            for(int idxT=t.length()-1; idxT>=0; idxT--){
                if(s.charAt(idxS)==t.charAt(idxT)){
                    dp[idxS][idxT] = dp[idxS+1][idxT+1]+dp[idxS+1][idxT];
                }else{
                    dp[idxS][idxT] = dp[idxS+1][idxT];
                }   
            }
        }

        return dp[0][0];
    }
    public int numDistinct(String s , String t) {

        if(s.length()<t.length()) return 0;
        return helper2(s,t);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna