<h2><a href="https://leetcode.com/problems/stone-game-iii">Stone Game III</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>Alice and Bob continue their games with piles of stones. There are several stones <strong>arranged in a row</strong>, and each stone has an associated value which is an integer given in the array <code>stoneValue</code>.</p>

<p>Alice and Bob take turns, with Alice starting first. On each player&#39;s turn, that player can take <code>1</code>, <code>2</code>, or <code>3</code> stones from the <strong>first</strong> remaining stones in the row.</p>

<p>The score of each player is the sum of the values of the stones taken. The score of each player is <code>0</code> initially.</p>

<p>The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie. The game continues until all the stones have been taken.</p>

<p>Assume Alice and Bob <strong>play optimally</strong>.</p>

<p>Return <code>&quot;Alice&quot;</code><em> if Alice will win, </em><code>&quot;Bob&quot;</code><em> if Bob will win, or </em><code>&quot;Tie&quot;</code><em> if they will end the game with the same score</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> stoneValue = [1,2,3,7]
<strong>Output:</strong> &quot;Bob&quot;
<strong>Explanation:</strong> Alice will always lose. Her best move will be to take three piles and the score become 6. Now the score of Bob is 7 and Bob wins.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> stoneValue = [1,2,3,-9]
<strong>Output:</strong> &quot;Alice&quot;
<strong>Explanation:</strong> Alice must choose all the three piles at the first move to win and leave Bob with negative score.
If Alice chooses one pile her score will be 1 and the next move Bob&#39;s score becomes 5. In the next move, Alice will take the pile with value = -9 and lose.
If Alice chooses two piles her score will be 3 and the next move Bob&#39;s score becomes 3. In the next move, Alice will take the pile with value = -9 and also lose.
Remember that both play optimally so here Alice will choose the scenario that makes her win.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> stoneValue = [1,2,3,6]
<strong>Output:</strong> &quot;Tie&quot;
<strong>Explanation:</strong> Alice cannot win this game. She can end the game in a draw if she decided to choose all the first three piles, otherwise she will lose.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= stoneValue.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= stoneValue[i] &lt;= 1000</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The game can be modeled by tracking the maximum possible difference in scores between the current player and their opponent. By working backwards from the last stone, we can determine the maximum relative score advantage a player can guarantee from any given position by taking the value of the chosen stones and subtracting the opponent's best possible future advantage.

### Approach
- Use dynamic programming to compute the maximum score difference the current player can achieve starting from any index.
- Iterate backwards from the end of the array down to the first stone.
- For each position, simulate taking 1, 2, or 3 stones. Calculate the net score difference by adding the value of the taken stones and subtracting the opponent's optimal score difference for the remaining stones.
- Record the maximum of these up to three choices as the optimal play for the current state.
- Optimize space by using a circular array of size 4 (accessed via modulo 4 arithmetic), since calculating the current state only requires the results of the next three possible states.
- Evaluate the final score difference at the starting index: a positive value means Alice wins, a negative value means Bob wins, and zero indicates a tie.

### Complexity
- **Time:** O(N) — We iterate through the array of N stones exactly once, performing at most 3 constant-time operations per stone.
- **Space:** O(1) — We only use a fixed-size array of 4 elements to store the dynamic programming states.
