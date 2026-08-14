<h2><a href="https://leetcode.com/problems/maximum-length-substring-with-two-occurrences">Maximum Length Substring With Two Occurrences</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr>Given a string <code>s</code>, return the <strong>maximum</strong> length of a <span data-keyword="substring">substring</span>&nbsp;such that it contains <em>at most two occurrences</em> of each character.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;bcbbbcba&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>
The following substring has a length of 4 and contains at most two occurrences of each character: <code>&quot;bcbb<u>bcba</u>&quot;</code>.</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aaaa&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>
The following substring has a length of 2 and contains at most two occurrences of each character: <code>&quot;<u>aa</u>aa&quot;</code>.</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem asks for the longest contiguous sequence satisfying a frequency constraint, making it a perfect candidate for the sliding window technique. By dynamically expanding a window and shrinking it only when a character's frequency exceeds the allowed limit, we can efficiently track the maximum valid substring without checking all possible combinations.

### Approach
- Initialize an integer array of size 26 to store the frequency of each lowercase letter in the current window.
- Use two pointers, `left` and `right`, starting at the beginning of the string to represent the boundaries of the sliding window.
- Iterate through the string by moving the `right` pointer and incrementing the frequency count of the current character.
- Whenever the count of the newly added character exceeds 2, shrink the window by moving the `left` pointer forward and decrementing the counts of the removed characters until the window is valid again.
- After ensuring the window is valid, calculate its length (`right - left + 1`) and update the maximum length recorded so far.

### Complexity
- **Time:** O(n) — where n is the length of the string, as both the `left` and `right` pointers traverse the string at most once.
- **Space:** O(1) — because the frequency array uses a constant amount of extra space (exactly 26 integers) regardless of the input size.
