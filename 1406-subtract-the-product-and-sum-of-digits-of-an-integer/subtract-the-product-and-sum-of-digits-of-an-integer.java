class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int Product = 1;
        while(n>0) {
            int digit = n % 10;
            sum += digit;
            Product *= digit;
            n=n/10;
        }
        return Product-sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna