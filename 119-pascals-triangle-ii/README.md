<h2><a href="https://leetcode.com/problems/pascals-triangle-ii">Pascal's Triangle II</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given an integer <code>rowIndex</code>, return the <code>rowIndex<sup>th</sup></code> (<strong>0-indexed</strong>) row of the <strong>Pascal&#39;s triangle</strong>.</p>

<p>In <strong>Pascal&#39;s triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
<img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif" style="height:240px; width:260px" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> rowIndex = 3
<strong>Output:</strong> [1,3,3,1]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> rowIndex = 0
<strong>Output:</strong> [1]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> rowIndex = 1
<strong>Output:</strong> [1,1]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= rowIndex &lt;= 33</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you optimize your algorithm to use only <code>O(rowIndex)</code> extra space?</p>


<hr>

## Solution Explanation

### Intuition
Instead of simulating the addition of previous rows, we can leverage the mathematical definition of Pascal's Triangle where each element is a binomial coefficient. By recognizing that each term in a row can be derived directly from the previous term using the relationship `current = current * (n - k + 1) / k`, we can compute the target row in a single pass without needing to build or store the rows above it.

### Approach
- Initialize a list to hold the elements of the target row, pre-allocating space for `rowIndex + 1` elements.
- Declare a `long` variable `current` starting at `1` (the first element of any row) to prevent integer overflow during intermediate multiplications.
- Add this initial `1` to the result list.
- Loop `i` from `1` to `rowIndex`, calculating the next element by multiplying `current` by `(rowIndex - i + 1)` and dividing by `i`.
- Cast the updated `current` value to an integer, add it to the list, and repeat until the row is fully populated.

### Complexity
- **Time:** O(rowIndex) — We iterate exactly `rowIndex` times, performing constant-time arithmetic operations in each step.
- **Space:** O(rowIndex) — We only use a single list of size `rowIndex + 1` to store and return the result, requiring O(1) auxiliary space beyond the output itself.
