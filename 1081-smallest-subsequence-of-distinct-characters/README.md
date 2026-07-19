<h2><a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters">Smallest Subsequence of Distinct Characters</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a string <code>s</code>, return <em>the </em><span data-keyword="lexicographically-smaller-string"><em>lexicographically smallest</em></span> <span data-keyword="subsequence-string"><em>subsequence</em></span><em> of</em> <code>s</code> <em>that contains all the distinct characters of</em> <code>s</code> <em>exactly once</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bcabc&quot;
<strong>Output:</strong> &quot;abc&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbacdcbc&quot;
<strong>Output:</strong> &quot;acdb&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<strong>Note:</strong> This question is the same as 316: <a href="https://leetcode.com/problems/remove-duplicate-letters/" target="_blank">https://leetcode.com/problems/remove-duplicate-letters/</a>

<hr>

## Solution Explanation

### Intuition
To build the lexicographically smallest sequence, we should greedily place smaller characters as early as possible. We can achieve this using a monotonic stack: when we encounter a new character, we remove previously added characters that are larger than the current one, but only if we know those removed characters will appear again later in the string so we don't permanently lose them.

### Approach
- Make a first pass through the string to populate an array `last` with the last observed index of every character.
- Initialize a `StringBuilder` to act as a stack for our result and a boolean array `seen` to track which characters are currently in the stack.
- Iterate through the string character by character; if the current character is already `seen`, skip it to ensure distinctness.
- While the stack is not empty, the current character is smaller than the character at the top of the stack, and that top character appears again later in the string (checked via the `last` array), pop the top character and mark it as unseen.
- Append the current character to the stack and mark it as `seen`.
- After processing all characters, the `StringBuilder` contains the optimal subsequence.

### Complexity
- **Time:** O(N) — We iterate through the string of length N twice, and each character is pushed and popped from the stack at most once.
- **Space:** O(1) — The `last` and `seen` arrays, as well as the `StringBuilder`, use space bounded by the 26 lowercase English letters, which is constant.
