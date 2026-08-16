<h2><a href="https://leetcode.com/problems/stone-game-ix">Stone Game IX</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Alice and Bob continue their games with stones. There is a row of n stones, and each stone has an associated value. You are given an integer array <code>stones</code>, where <code>stones[i]</code> is the <strong>value</strong> of the <code>i<sup>th</sup></code> stone.</p>

<p>Alice and Bob take turns, with <strong>Alice</strong> starting first. On each turn, the player may remove any stone from <code>stones</code>. The player who removes a stone <strong>loses</strong> if the <strong>sum</strong> of the values of <strong>all removed stones</strong> is divisible by <code>3</code>. Bob will win automatically if there are no remaining stones (even if it is Alice&#39;s turn).</p>

<p>Assuming both players play <strong>optimally</strong>, return <code>true</code> <em>if Alice wins and</em> <code>false</code> <em>if Bob wins</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> stones = [2,1]
<strong>Output:</strong> true
<strong>Explanation:</strong>&nbsp;The game will be played as follows:
- Turn 1: Alice can remove either stone.
- Turn 2: Bob removes the remaining stone. 
The sum of the removed stones is 1 + 2 = 3 and is divisible by 3. Therefore, Bob loses and Alice wins the game.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> stones = [2]
<strong>Output:</strong> false
<strong>Explanation:</strong>&nbsp;Alice will remove the only stone, and the sum of the values on the removed stones is 2. 
Since all the stones are removed and the sum of values is not divisible by 3, Bob wins the game.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> stones = [5,1,2,4,3]
<strong>Output:</strong> false
<strong>Explanation:</strong> Bob will always win. One possible way for Bob to win is shown below:
- Turn 1: Alice can remove the second stone with value 1. Sum of removed stones = 1.
- Turn 2: Bob removes the fifth stone with value 3. Sum of removed stones = 1 + 3 = 4.
- Turn 3: Alices removes the fourth stone with value 4. Sum of removed stones = 1 + 3 + 4 = 8.
- Turn 4: Bob removes the third stone with value 2. Sum of removed stones = 1 + 3 + 4 + 2 = 10.
- Turn 5: Alice removes the first stone with value 5. Sum of removed stones = 1 + 3 + 4 + 2 + 5 = 15.
Alice loses the game because the sum of the removed stones (15) is divisible by 3. Bob wins the game.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= stones.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= stones[i] &lt;= 10<sup>4</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The game revolves entirely around the stones' values modulo 3. Stones that are multiples of 3 (type 0) act as turn-skippers, while type 1 and type 2 stones dictate the required sequence of moves to avoid a divisible-by-3 sum (the safe sequences are either `1, 1, 2, 1, 2, 1...` or `2, 2, 1, 2, 1, 2...`). The parity of type 0 stones determines whether the "turn-skipping" effect cancels out or flips the advantage, dictating Alice's winning conditions based on the availability and imbalance of type 1 and type 2 stones.

### Approach
- Count the frequencies of the stones' values modulo 3, storing them in an array where indices 0, 1, and 2 represent the respective remainders.
- Evaluate the parity of the type 0 stones (`cnt[0]`). Since type 0 stones don't change the running sum's modulo but do consume a turn, an even count means their turn-flipping effect entirely cancels out.
- If `cnt[0]` is even, Alice can win by choosing to start the sequence with either a type 1 or type 2 stone. She only needs at least one of each (`cnt[1] > 0` and `cnt[2] > 0`) to successfully trap Bob in a forced sequence.
- If `cnt[0]` is odd, the extra turn-skip flips the game's parity, effectively giving Bob a defensive advantage. 
- In this odd `cnt[0]` scenario, Alice can only win if there is a severe imbalance between type 1 and type 2 stones. Specifically, the absolute difference between `cnt[1]` and `cnt[2]` must be strictly greater than 2 to completely exhaust Bob's safe options.

### Complexity
- **Time:** O(n) — We iterate through the `stones` array exactly once to calculate the modulo frequencies.
- **Space:** O(1) — We only use a fixed-size array of length 3 to store the counts, requiring constant extra space.
