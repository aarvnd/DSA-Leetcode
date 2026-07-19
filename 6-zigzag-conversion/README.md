<h2><a href="https://leetcode.com/problems/zigzag-conversion">Zigzag Conversion</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>The string <code>&quot;PAYPALISHIRING&quot;</code> is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)</p>

<pre>
P   A   H   N
A P L S I I G
Y   I   R
</pre>

<p>And then read line by line: <code>&quot;PAHNAPLSIIGYIR&quot;</code></p>

<p>Write the code that will take a string and make this conversion given a number of rows:</p>

<pre>
string convert(string s, int numRows);
</pre>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;PAYPALISHIRING&quot;, numRows = 3
<strong>Output:</strong> &quot;PAHNAPLSIIGYIR&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;PAYPALISHIRING&quot;, numRows = 4
<strong>Output:</strong> &quot;PINALSIGYAHRPI&quot;
<strong>Explanation:</strong>
P     I    N
A   L S  I G
Y A   H R
P     I
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;A&quot;, numRows = 1
<strong>Output:</strong> &quot;A&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consists of English letters (lower-case and upper-case), <code>&#39;,&#39;</code> and <code>&#39;.&#39;</code>.</li>
	<li><code>1 &lt;= numRows &lt;= 1000</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Instead of simulating the zigzag pattern in a 2D matrix, we can directly calculate the indices of the characters that belong to each row by observing the repeating cycle of the pattern. The distance between the vertical columns of the zigzag forms a predictable cycle length, allowing us to construct the final string row by row mathematically.

### Approach
- Handle edge cases immediately: if `numRows` is 1 or greater than or equal to the string length, the zigzag pattern doesn't change the string, so return it directly.
- Calculate the `cycleLen` as `2 * numRows - 2`, which represents the number of characters in one full downward and upward zigzag cycle.
- Iterate through each row `i` from `0` to `numRows - 1`.
- For each row, iterate through the string in steps of `cycleLen` (using a base index `j`). Append the character at `j + i`, which corresponds to the vertical downward stroke of the zigzag.
- If the current row is a middle row (neither the first nor the last), calculate and append the character on the upward diagonal stroke at index `j + cycleLen - i`, ensuring it falls within the string's bounds.

### Complexity
- **Time:** O(N) — where N is the length of the string, as we calculate the index and append each character exactly once.
- **Space:** O(N) — to store the resulting characters in the string builder before returning.
