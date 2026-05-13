class Solution {
        public int sumOfMultiples(int n) {
                int sum = 0;
                        for (int i = 1; i <= n; i++) {
                                    if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                                                    sum += i;
                                                                }
                                                                        }
                                                                                return sum;
                                                                                    }
                                                                                    }

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna