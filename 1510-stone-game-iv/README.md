<h2><a href="https://leetcode.com/problems/stone-game-iv">Stone Game IV</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>Alice and Bob take turns playing a game, with Alice starting first.</p>

<p>Initially, there are <code>n</code> stones in a pile. On each player&#39;s turn, that player makes a <em>move</em> consisting of removing <strong>any</strong> non-zero <strong>square number</strong> of stones in the pile.</p>

<p>Also, if a player cannot make a move, he/she loses the game.</p>

<p>Given a positive integer <code>n</code>, return <code>true</code> if and only if Alice wins the game otherwise return <code>false</code>, assuming both players play optimally.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> true
<strong>Explanation: </strong>Alice can remove 1 stone winning the game because Bob doesn&#39;t have any moves.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> false
<strong>Explanation: </strong>Alice can only remove 1 stone, after that Bob removes the last one winning the game (2 -&gt; 1 -&gt; 0).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 4
<strong>Output:</strong> true
<strong>Explanation:</strong> n is already a perfect square, Alice can win with one move, removing 4 stones (4 -&gt; 0).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The game can be modeled using dynamic programming by recognizing that a player wins if they can make at least one move that forces the opponent into a losing state. By evaluating smaller pile sizes first, we can systematically determine the winning or losing nature of any pile size up to `n`.

### Approach
- Initialize a boolean array `dp` of size `n + 1`, where `dp[i]` represents whether the current player will win starting with `i` stones. (Note that `dp[0]` defaults to `false`, correctly representing that a player with 0 stones to draw from has already lost).
- Iterate through every possible stone count `i` from 1 up to `n` to build the solutions bottom-up.
- For each `i`, try removing every possible perfect square `k * k` (where `k * k <= i`).
- If removing `k * k` stones leaves the opponent with a state evaluated as `false` (`!dp[i - k * k]`), it means the current player can force a win.
- Upon finding such a winning move, set `dp[i]` to `true`, break out of the inner loop to save time, and move to the next `i`.
- Finally, return `dp[n]` to determine if Alice wins starting with `n` stones.

### Complexity
- **Time:** O(n * sqrt(n)) — For each of the n states, we iterate through at most sqrt(n) perfect squares to find a winning move.
- **Space:** O(n) — The dynamic programming array requires n + 1 boolean values to store the state of each pile size.
