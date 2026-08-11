<h2><a href="https://leetcode.com/problems/pascals-triangle">Pascal's Triangle</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given an integer <code>numRows</code>, return the first numRows of <strong>Pascal&#39;s triangle</strong>.</p>

<p>In <strong>Pascal&#39;s triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
<img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif" style="height:240px; width:260px" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> numRows = 5
<strong>Output:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> numRows = 1
<strong>Output:</strong> [[1]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= numRows &lt;= 30</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that each row of Pascal's triangle can be constructed dynamically using just the previously generated row. Since the first and last elements of every row are always 1, we only need to calculate the inner elements by summing the two adjacent values directly above them from the preceding row.

### Approach
- Initialize a main `result` list to store each row of the triangle.
- Iterate `i` from 0 to `numRows - 1` to generate each row sequentially.
- For each row, create a new list and iterate `j` from 0 to `i` to populate its elements.
- If the element is at the start (`j == 0`) or the end (`j == i`) of the row, simply add `1`.
- Otherwise, compute the value by adding the elements at index `j - 1` and `j` from the immediately preceding row.
- Append the completed row to the `result` list, returning it after all rows are built.

### Complexity
- **Time:** O(numRows^2) — We iterate through a nested loop that performs 1 + 2 + 3 + ... + numRows operations, which scales quadratically.
- **Space:** O(numRows^2) — The space is used to store the output list of lists, which contains exactly (numRows * (numRows + 1)) / 2 elements.
