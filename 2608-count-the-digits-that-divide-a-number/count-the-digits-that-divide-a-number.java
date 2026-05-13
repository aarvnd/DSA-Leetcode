class Solution {
    public int countDigits(int num) {
        int count = 0;
        int temp = num;
        while(temp>0){
            int digit = temp%10;
            if(num%digit == 0){
                count++;
            }
            temp /=10;
        }
        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna