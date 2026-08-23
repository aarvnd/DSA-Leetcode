<h2><a href="https://leetcode.com/problems/sum-game">Sum Game</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Alice and Bob take turns playing a game, with <strong>Alice</strong><strong>&nbsp;starting first</strong>.</p>

<p>You are given a string <code>num</code> of <strong>even length</strong> consisting of digits and <code>&#39;?&#39;</code> characters. On each turn, a player will do the following if there is still at least one <code>&#39;?&#39;</code> in <code>num</code>:</p>

<ol>
	<li>Choose an index <code>i</code> where <code>num[i] == &#39;?&#39;</code>.</li>
	<li>Replace <code>num[i]</code> with any digit between <code>&#39;0&#39;</code> and <code>&#39;9&#39;</code>.</li>
</ol>

<p>The game ends when there are no more <code>&#39;?&#39;</code> characters in <code>num</code>.</p>

<p>For Bob&nbsp;to win, the sum of the digits in the first half of <code>num</code> must be <strong>equal</strong> to the sum of the digits in the second half. For Alice&nbsp;to win, the sums must <strong>not be equal</strong>.</p>

<ul>
	<li>For example, if the game ended with <code>num = &quot;243801&quot;</code>, then Bob&nbsp;wins because <code>2+4+3 = 8+0+1</code>. If the game ended with <code>num = &quot;243803&quot;</code>, then Alice&nbsp;wins because <code>2+4+3 != 8+0+3</code>.</li>
</ul>

<p>Assuming Alice and Bob play <strong>optimally</strong>, return <code>true</code> <em>if Alice will win and </em><code>false</code> <em>if Bob will win</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = &quot;5023&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> There are no moves to be made.
The sum of the first half is equal to the sum of the second half: 5 + 0 = 2 + 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = &quot;25??&quot;
<strong>Output:</strong> true
<strong>Explanation: </strong>Alice can replace one of the &#39;?&#39;s with &#39;9&#39; and it will be impossible for Bob to make the sums equal.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> num = &quot;?3295???&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> It can be proven that Bob will always win. One possible outcome is:
- Alice replaces the first &#39;?&#39; with &#39;9&#39;. num = &quot;93295???&quot;.
- Bob replaces one of the &#39;?&#39; in the right half with &#39;9&#39;. num = &quot;932959??&quot;.
- Alice replaces one of the &#39;?&#39; in the right half with &#39;2&#39;. num = &quot;9329592?&quot;.
- Bob replaces the last &#39;?&#39; in the right half with &#39;7&#39;. num = &quot;93295927&quot;.
Bob wins because 9 + 3 + 2 + 9 = 5 + 9 + 2 + 7.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= num.length &lt;= 10<sup>5</sup></code></li>
	<li><code>num.length</code> is <strong>even</strong>.</li>
	<li><code>num</code> consists of only digits and <code>&#39;?&#39;</code>.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The game's outcome is entirely deterministic based on the initial difference in sums and the distribution of question marks. Since Bob wants equality and Alice wants inequality, Bob can only win if he gets the last move (meaning the total number of '?' is even) and the initial difference in sums is perfectly offset by the remaining '?' characters, where each pair of '?' allows Bob to balance exactly 9 points of difference.

### Approach
- Iterate through the first half of the string to calculate the sum of known digits (`sL`) and count the question marks (`qL`).
- Iterate through the second half of the string to calculate its sum of known digits (`sR`) and count its question marks (`qR`).
- Check if the total number of question marks (`qL + qR`) is odd. If it is, Alice gets the final move and can always pick a digit to force an inequality, guaranteeing her a win.
- If the total is even, Bob gets the last move. Bob can only win if the initial difference in sums (`sL - sR`) is exactly compensated by the difference in question marks.
- Because Bob can always force any pair of question marks (one played by Alice, one by Bob) to sum to exactly 9, Bob wins if and only if `sL - sR == 9 * (qR - qL) / 2`. 
- The algorithm returns `true` (Alice wins) if this equation does not hold, which is rewritten as `2 * (sL - sR) != 9 * (qR - qL)` to avoid floating-point division.

### Complexity
- **Time:** O(N) — where N is the length of the string, as we iterate through the characters exactly once.
- **Space:** O(1) — because we only use a few integer variables to store the running sums and counts.
