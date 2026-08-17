<h2><a href="https://leetcode.com/problems/stone-game-v">Stone Game V</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>There are several stones <strong>arranged in a row</strong>, and each stone has an associated value which is an integer given in the array <code>stoneValue</code>.</p>

<p>In each round of the game, Alice divides the row into <strong>two non-empty rows</strong> (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice&#39;s score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.</p>

<p>The game ends when there is only <strong>one stone remaining</strong>. Alice&#39;s score is initially <strong>zero</strong>.</p>

<p>Return <i>the maximum score that Alice can obtain</i>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> stoneValue = [6,2,3,4,5,5]
<strong>Output:</strong> 18
<strong>Explanation:</strong> In the first round, Alice divides the row to [6,2,3], [4,5,5]. The left row has the value 11 and the right row has value 14. Bob throws away the right row and Alice&#39;s score is now 11.
In the second round Alice divides the row to [6], [2,3]. This time Bob throws away the left row and Alice&#39;s score becomes 16 (11 + 5).
The last round Alice has only one choice to divide the row which is [2], [3]. Bob throws away the right row and Alice&#39;s score is now 18 (16 + 2). The game ends because only one stone is remaining in the row.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> stoneValue = [7,7,7,7,7,7,7]
<strong>Output:</strong> 28
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> stoneValue = [4]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= stoneValue.length &lt;= 500</code></li>
	<li><code>1 &lt;= stoneValue[i] &lt;= 10<sup>6</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem can be solved using dynamic programming by evaluating the optimal split point for each subarray, but a standard approach requires $O(N^3)$ time. To optimize this to $O(N^2)$, we can leverage the fact that since all stone values are positive, the critical split point—where the sum of the left part exceeds the sum of the right part—moves monotonically to the right as the subarray expands. By maintaining auxiliary arrays that track the maximum possible scores for the left and right halves, we can compute the optimal transition for any subarray in $O(1)$ amortized time.

### Approach
- Compute a prefix sum array to quickly calculate the sum of any subarray in $O(1)$ time.
- Initialize a 2D `dp` array where `dp[i][j]` represents the maximum score Alice can achieve from the subarray `[i...j]`.
- Maintain two auxiliary arrays, `valL` and `valR`, which store the running maximums of `dp[i][k] + sum(i, k)` and `dp[k][j] + sum(k, j)` respectively, allowing $O(1)$ retrieval of the best split score instead of iterating through all possible split points.
- Iterate through all possible subarray lengths. For each starting index `i`, maintain a monotonic pointer `mid[i]` that tracks the largest split point where the left half's sum is less than or equal to the right half's sum.
- Calculate `dp[i][j]` by using `valL` for split points up to `mid[i]` (where Bob discards the heavier right half) and `valR` for split points beyond `mid[i]` (where Bob discards the heavier left half), handling the exact tie condition explicitly.
- Update `valL[i][j]` and `valR[i][j]` with the newly computed `dp[i][j]` so they can be used to compute larger encompassing subarrays.

### Complexity
- **Time:** O(N^2) — There are $O(N^2)$ subarray states, and thanks to the monotonic `mid` pointer and auxiliary `valL`/`valR` arrays, each state is computed in $O(1)$ amortized time.
- **Space:** O(N^2) — The `dp`, `valL`, and `valR` tables each require $N \times N$ space to store the results for all subarray ranges.
