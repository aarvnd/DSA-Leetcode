import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        List<Integer> filtered = new ArrayList<>();
        for (int c : coins) {
            boolean keep = true;
            for (int f : filtered) {
                if (c % f == 0) {
                    keep = false;
                    break;
                }
            }
            if (keep) {
                filtered.add(c);
            }
        }
        int n = filtered.size();
        int[] activeCoins = new int[n];
        for (int i = 0; i < n; i++) {
            activeCoins[i] = filtered.get(i);
        }

        int numSubsets = 1 << n;
        long[] lcms = new long[numSubsets];
        int[] signs = new int[numSubsets];
        lcms[0] = 1;
        signs[0] = -1;

        long limit = 100000000000L;
        long inf = 1000000000000L;

        for (int i = 1; i < numSubsets; i++) {
            int p = Integer.numberOfTrailingZeros(i);
            long prevLcm = lcms[i ^ (1 << p)];
            if (prevLcm > limit) {
                lcms[i] = inf;
            } else {
                lcms[i] = lcm(prevLcm, activeCoins[p], limit, inf);
            }
            signs[i] = -signs[i ^ (1 << p)];
        }

        long low = 1;
        long high = (long) activeCoins[0] * k;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long cnt = 0;
            for (int i = 1; i < numSubsets; i++) {
                cnt += signs[i] * (mid / lcms[i]);
            }
            if (cnt >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b, long limit, long inf) {
        long g = gcd(a, b);
        long bg = b / g;
        if (a > limit / bg) {
            return inf;
        }
        long res = a * bg;
        if (res > limit) {
            return inf;
        }
        return res;
    }
}
