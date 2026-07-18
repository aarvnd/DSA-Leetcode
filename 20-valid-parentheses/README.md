<h2><a href="https://leetcode.com/problems/valid-parentheses">Valid Parentheses</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given a string <code>s</code> containing just the characters <code>&#39;(&#39;</code>, <code>&#39;)&#39;</code>, <code>&#39;{&#39;</code>, <code>&#39;}&#39;</code>, <code>&#39;[&#39;</code> and <code>&#39;]&#39;</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol>
	<li>Open brackets must be closed by the same type of brackets.</li>
	<li>Open brackets must be closed in the correct order.</li>
	<li>Every close bracket has a corresponding open bracket of the same type.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;()&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;()[]{}&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;(]&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;([])&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 5:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;([)]&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of parentheses only <code>&#39;()[]{}&#39;</code>.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem requires matching pairs of brackets in a Last-In-First-Out (LIFO) order, which makes a stack the perfect data structure. Whenever a closing bracket is encountered, it must correctly match the most recently seen unmatched opening bracket.

### Approach
- First, quickly return `false` if the string length is odd, as valid parentheses must always appear in pairs.
- Initialize a character array to simulate a stack and a `top` pointer set to `-1` for efficient, low-overhead tracking.
- Iterate through each character in the string. If it is an opening bracket (`(`, `{`, or `[`), push it onto the stack by incrementing the `top` pointer.
- If it is a closing bracket, check if the stack is empty (`top == -1`). If it is, return `false` because there is no corresponding opening bracket.
- Otherwise, pop the top character from the stack and verify that it is the correct matching opening bracket for the current closing bracket. If it mismatches, return `false`.
- After processing all characters, return `true` if the stack is empty (meaning all brackets were successfully matched) or `false` otherwise.

### Complexity
- **Time:** O(n) — We traverse the string of length n exactly once, with each stack operation taking constant time.
- **Space:** O(n) — In the worst-case scenario (e.g., a string of all opening brackets), the character array will store n elements.
