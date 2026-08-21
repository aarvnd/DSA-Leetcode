<h2><a href="https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination">Kth Smallest Amount With Single Denomination Combination</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>k</code>.</p>

<p>You have an infinite number of coins of each denomination. However, you are <strong>not allowed</strong> to combine coins of different denominations.</p>

<p>Return the <code>k<sup>th</sup></code> <strong>smallest</strong> amount that can be made using these coins.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block" style="
    border-color: var(--border-tertiary);
    border-left-width: 2px;
    color: var(--text-secondary);
    font-size: .875rem;
    margin-bottom: 1rem;
    margin-top: 1rem;
    overflow: visible;
    padding-left: 1rem;
">
<p><strong>Input:</strong> <span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">coins = [3,6,9], k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
"> 9</span></p>

<p><strong>Explanation:</strong> The given coins can make the following amounts:<br />
Coin 3 produces multiples of 3: 3, 6, 9, 12, 15, etc.<br />
Coin 6 produces multiples of 6: 6, 12, 18, 24, etc.<br />
Coin 9 produces multiples of 9: 9, 18, 27, 36, etc.<br />
All of the coins combined produce: 3, 6, <u><strong>9</strong></u>, 12, 15, etc.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block" style="
    border-color: var(--border-tertiary);
    border-left-width: 2px;
    color: var(--text-secondary);
    font-size: .875rem;
    margin-bottom: 1rem;
    margin-top: 1rem;
    overflow: visible;
    padding-left: 1rem;
">
<p><strong>Input:</strong><span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
"> coins = [5,2], k = 7</span></p>

<p><strong>Output:</strong><span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
"> 12 </span></p>

<p><strong>Explanation:</strong> The given coins can make the following amounts:<br />
Coin 5 produces multiples of 5: 5, 10, 15, 20, etc.<br />
Coin 2 produces multiples of 2: 2, 4, 6, 8, 10, 12, etc.<br />
All of the coins combined produce: 2, 4, 5, 6, 8, 10, <u><strong>12</strong></u>, 14, 15, etc.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= coins.length &lt;= 15</code></li>
	<li><code>1 &lt;= coins[i] &lt;= 25</code></li>
	<li><code>1 &lt;= k &lt;= 2 * 10<sup>9</sup></code></li>
	<li><code>coins</code> contains pairwise distinct integers.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem asks for the $k$-th smallest number in the union of multiples of given coin denominations. Because the count of valid amounts less than or equal to a target value $x$ is monotonically increasing, we can binary search for the exact value of $x$. To efficiently count how many valid amounts exist up to $x$, we can use the Principle of Inclusion-Exclusion (PIE) to add the multiples of individual coins, subtract the multiples of their pairs (using their Least Common Multiples), add the triplets, and so forth.

### Approach
- Sort the `coins` array and filter out any coin that is a multiple of a smaller coin, as its multiples are already completely covered by the smaller denomination.
- Iterate through all $2^n$ subsets of the filtered coins using bitmasking to precompute their Least Common Multiples (LCMs).
- Cap the precomputed LCMs at a safe upper limit to prevent integer overflow, and precompute an alternating sign array (+1 for odd-sized subsets, -1 for even-sized) to apply PIE.
- Perform a binary search for the answer within the range `[1, min_coin * k]`.
- For each candidate `mid`, count the valid amounts $\le mid$ by summing `sign * (mid / subset_lcm)` across all precomputed subsets.
- If the count is greater than or equal to $k$, update the potential answer and search the lower half; otherwise, search the upper half.

### Complexity
- **Time:** $O(2^n \log(\min(coins) \cdot k))$ — Precomputing subsets takes $O(2^n)$ and the binary search takes $O(\log(\min(coins) \cdot k))$ steps, each evaluating $2^n$ subsets, where $n \le 15$.
- **Space:** $O(2^n)$ — We store the precomputed LCMs and signs for all $2^n$ subsets in arrays.
