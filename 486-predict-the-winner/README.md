<h2><a href="https://leetcode.com/problems/predict-the-winner">Predict the Winner</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given an integer array <code>nums</code>. Two players are playing a game with this array: player 1 and player 2.</p>

<p>Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of <code>0</code>. At each turn, the player takes one of the numbers from either end of the array (i.e., <code>nums[0]</code> or <code>nums[nums.length - 1]</code>) which reduces the size of the array by <code>1</code>. The player adds the chosen number to their score. The game ends when there are no more elements in the array.</p>

<p>Return <code>true</code> if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return <code>true</code>. You may assume that both players are playing optimally.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,5,2]
<strong>Output:</strong> false
<strong>Explanation:</strong> Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return false.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,5,233,7]
<strong>Output:</strong> true
<strong>Explanation:</strong> Player 1 first chooses 1. Then player 2 has to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 20</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>7</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The game can be modeled by calculating the maximum score difference the current player can achieve over their opponent. By working bottom-up from smaller subarrays to the full array, a player's optimal move is to pick an element from either end and subtract the opponent's best possible score difference for the remaining elements. 

### Approach
- Create a 1D dynamic programming array `dp` where `dp[i]` tracks the maximum score difference a player can achieve from a subarray starting at index `i`.
- Initialize `dp` with the base cases: for subarrays of length 1, the maximum score difference is simply the element itself (`nums[i]`).
- Use an outer loop to gradually increase the evaluated subarray length from 2 up to the total length of the array.
- Use an inner loop to slide a window of the current length across the array, calculating the end index `j` for each starting index `i`.
- Update `dp[i]` by taking the maximum of picking the left element (`nums[i] - dp[i + 1]`) or picking the right element (`nums[j] - dp[i]`).
- Return true if `dp[0] >= 0`, which indicates that Player 1's final score difference for the entire array is zero or greater, guaranteeing a win or a tie.

### Complexity
- **Time:** O(n^2) — The algorithm uses two nested loops to evaluate all possible subarrays of length 2 through n.
- **Space:** O(n) — The traditional 2D DP table is optimized into a 1D array of size n that only stores the results of the previous subarray length.
