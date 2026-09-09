class Solution {
        
        int[] dp=new int[370];
        int fun(int i,int[] days, int[]costs){
            if(i>=days.length) return 0;

            if(dp[i]!=-1) return dp[i];
            int id7 = days.length;
            int id30 = days.length;
    
            for(int j=0;j<days.length;j++){
                if(days[j]>=days[i]+7){
                    id7=j;
                    break; 
                } 
            }

            for(int j=0;j<days.length;j++){
                if(days[j]>=days[i]+30){
                    id30=j;
                    break; 
                } 
            }

            int c1=costs[0]+fun(i+1,days,costs);
            int c2=costs[1]+fun(id7,days,costs);
            int c3=costs[2]+fun(id30,days,costs);

            int ans=Math.min(c1,Math.min(c2,c3));
            dp[i]=ans;
            return ans;

        }
        public int mincostTickets(int[] days, int[] costs) {

            Arrays.fill(dp,-1);

            return fun(0,days,costs);
    }
}



// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna