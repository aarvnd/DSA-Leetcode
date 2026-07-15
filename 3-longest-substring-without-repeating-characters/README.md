<h2><a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">Longest Substring Without Repeating Characters</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a string <code>s</code>, find the length of the <strong>longest</strong> <span data-keyword="substring-nonempty"><strong>substring</strong></span> without duplicate characters.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcabcbb&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is &quot;abc&quot;, with the length of 3. Note that <code>&quot;bca&quot;</code> and <code>&quot;cab&quot;</code> are also correct answers.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bbbbb&quot;
<strong>Output:</strong> 1
<strong>Explanation:</strong> The answer is &quot;b&quot;, with the length of 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;pwwkew&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is &quot;wke&quot;, with the length of 3.
Notice that the answer must be a substring, &quot;pwke&quot; is a subsequence and not a substring.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem can be efficiently solved using a sliding window approach. By keeping track of the most recent index where each character was seen, we can instantly shrink our window's left boundary past the previous occurrence of a duplicate character, ensuring the current window always contains strictly unique characters.

### Approach
- Initialize an integer array of size 128 to act as a direct-mapped hash table, storing the last seen index of each ASCII character (initially filled with `-1`).
- Maintain a sliding window using two pointers, where `left` marks the start of the current valid substring and `right` iterates through the string.
- As `right` moves forward, check if the current character has already been seen at an index greater than or equal to `left`.
- If a duplicate is found within the current window, instantly jump the `left` pointer to one position immediately after the previous occurrence of that character.
- Update the character's last seen index to the current `right` position and update the maximum substring length recorded so far.

### Complexity
- **Time:** O(n) — We iterate through the string of length n exactly once using the `right` pointer.
- **Space:** O(1) — The array used to track character indices is of fixed size (128), requiring constant extra space regardless of the input size.
