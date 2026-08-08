<h2><a href="https://leetcode.com/problems/generate-parentheses">Generate Parentheses</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given <code>n</code> pairs of parentheses, write a function to <em>generate all combinations of well-formed parentheses</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> ["((()))","(()())","(())()","()(())","()()()"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> ["()"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem can be solved by building valid sequences one character at a time using backtracking. The key insight is to maintain running counts of open and close parentheses: we can safely add an open parenthesis as long as we haven't reached our limit of `n`, and we can only add a close parenthesis if it has a corresponding unmatched open parenthesis (i.e., the count of close parentheses is strictly less than the count of open parentheses).

### Approach
- Initialize a result list and a character array of size `2 * n` to build combinations efficiently in place.
- Use a recursive helper function that tracks the current index in the array, along with the counts of `open` and `close` parentheses used so far.
- **Base Case:** When the index reaches `2 * n`, the character array is full and represents a valid combination; convert it to a string and add it to the result list.
- **Add Open:** If `open < n`, place an `(` at the current index and recursively call the function with `open + 1` and `index + 1`.
- **Add Close:** If `close < open`, place a `)` at the current index and recursively call the function with `close + 1` and `index + 1`.

### Complexity
- **Time:** O(4^n / √n) — The time complexity is bounded by the nth Catalan number, which represents the total number of valid parenthesis combinations.
- **Space:** O(n) — The maximum depth of the recursion stack is `2 * n`, and the character array requires `2 * n` space, both simplifying to O(n) auxiliary space.
