<h2><a href="https://leetcode.com/problems/stone-game-ii">Stone Game II</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Alice and Bob continue their games with piles of stones. There are a number of piles <strong>arranged in a row</strong>, and each pile has a positive integer number of stones <code>piles[i]</code>. The objective of the game is to end with the most stones.</p>

<p>Alice and Bob take turns, with Alice starting first.</p>

<p>On each player&#39;s turn, that player can take <strong>all the stones</strong> in the <strong>first</strong> <code>X</code> remaining piles, where <code>1 &lt;= X &lt;= 2M</code>. Then, we set <code>M = max(M, X)</code>. Initially, M = 1.</p>

<p>The game continues until all the stones have been taken.</p>

<p>Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">piles = [2,7,9,4,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get <code>2 + 4 + 4 = 10</code> stones in total.</li>
	<li>If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get <code>2 + 7 = 9</code> stones in total.</li>
</ul>

<p>So we return 10 since it&#39;s larger.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">piles = [1,2,3,4,5,100]</span></p>

<p><strong>Output:</strong> <span class="example-io">104</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 100</code></li>
	<li><code>1 &lt;= piles[i]&nbsp;&lt;= 10<sup>4</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Since both players play optimally to maximize their own score, this game can be modeled using dynamic programming. The key insight is that the maximum stones a player can collect from a given position is simply the total remaining stones minus the maximum stones the opponent can collect from the resulting next state.

### Approach
- Precompute a `suffixSum` array where `suffixSum[i]` holds the total number of stones from index `i` to the end of the piles.
- Initialize a 2D table `dp[i][m]` representing the maximum stones a player can get starting at index `i` with the current multiplier `m`.
- Iterate backwards through the piles (from `n-1` down to 0) and for all possible values of `m` (from 1 to `n`).
- If the current player can take all remaining piles (`i + 2 * m >= n`), set `dp[i][m]` to `suffixSum[i]`.
- Otherwise, simulate taking `x` piles (from 1 to `2 * m`). The opponent will then get `dp[i + x][max(m, x)]` stones. Update `dp[i][m]` to the maximum possible value of `suffixSum[i] - dp[i + x][max(m, x)]`.
- Return `dp[0][1]`, which evaluates Alice's optimal score starting at index 0 with `M = 1`.

### Complexity
- **Time:** O(N^3) — We evaluate O(N^2) states (for `i` and `m`), and each state requires an inner loop of up to O(N) iterations to check all valid `x` choices.
- **Space:** O(N^2) — The 2D `dp` array of size (N+1) x (N+1) dominates the memory usage.
