<h2><a href="https://leetcode.com/problems/stone-game">Stone Game</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Alice and Bob play a game with piles of stones. There are an <strong>even</strong> number of piles arranged in a row, and each pile has a <strong>positive</strong> integer number of stones <code>piles[i]</code>.</p>

<p>The objective of the game is to end with the most stones. The <strong>total</strong> number of stones across all the piles is <strong>odd</strong>, so there are no ties.</p>

<p>Alice and Bob take turns, with <strong>Alice starting first</strong>. Each turn, a player takes the entire pile of stones either from the <strong>beginning</strong> or from the <strong>end</strong> of the row. This continues until there are no more piles left, at which point the person with the <strong>most stones wins</strong>.</p>

<p>Assuming Alice and Bob play optimally, return <code>true</code><em> if Alice wins the game, or </em><code>false</code><em> if Bob wins</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [5,3,4,5]
<strong>Output:</strong> true
<strong>Explanation:</strong> 
Alice starts first, and can only take the first 5 or the last 5.
Say she takes the first 5, so that the row becomes [3, 4, 5].
If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,7,2,3]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= piles.length &lt;= 500</code></li>
	<li><code>piles.length</code> is <strong>even</strong>.</li>
	<li><code>1 &lt;= piles[i] &lt;= 500</code></li>
	<li><code>sum(piles[i])</code> is <strong>odd</strong>.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that Alice can always win by exploiting the even number of piles and the odd total number of stones. By mentally partitioning the array into even-indexed and odd-indexed piles, Alice can determine which set has a larger total sum. Because she moves first, she can dictate the game's flow to guarantee she collects all the piles from the larger set, leaving Bob with the smaller set.

### Approach
- Divide the piles into two sets based on their original indices: even-indexed (0, 2, 4, ...) and odd-indexed (1, 3, 5, ...).
- Recognize that since the total sum of stones is odd, the sum of the even-indexed set and the odd-indexed set cannot be equal; one must be strictly greater.
- If the even-indexed set is larger, Alice takes the first pile (index 0). This exposes only odd-indexed piles to Bob (index 1 and the last index).
- Whatever Bob chooses, he will inevitably expose another even-indexed pile to Alice, allowing her to collect all even-indexed piles by the end of the game.
- Conversely, if the odd-indexed set is larger, Alice takes the last pile (an odd index) and forces Bob to only ever choose even-indexed piles.
- Because Alice can always force a win using this parity strategy without needing to simulate the game, the algorithm simply returns `true`.

### Complexity
- **Time:** O(1) — returning a constant boolean value takes constant time.
- **Space:** O(1) — no additional memory is allocated.
