class Solution {
    public int countSpecialIntegers(int[] nums) {
        
        
        Set<Integer> seen = new HashSet<> ();
        Set<Integer> notSpecial =new HashSet<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            int x = nums[i];
            
            if(notSpecial.contains(x)) continue;
            if(seen.contains(x)){
                notSpecial.add(x);
            } else {
                seen.add(x);
                int j = i;
                while(j<n && nums[j] == x){
                    j++;
                }
                i=j-1;
            }
        }
        return seen.size()-notSpecial.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna