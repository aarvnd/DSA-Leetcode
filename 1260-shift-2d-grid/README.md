<h2><a href="https://leetcode.com/problems/shift-2d-grid">Shift 2D Grid</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given a 2D <code>grid</code> of size <code>m x n</code>&nbsp;and an integer <code>k</code>. You need to shift the <code>grid</code>&nbsp;<code>k</code> times.</p>

<p>In one shift operation:</p>

<ul>
	<li>Element at <code>grid[i][j]</code> moves to <code>grid[i][j + 1]</code>.</li>
	<li>Element at <code>grid[i][n - 1]</code> moves to <code>grid[i + 1][0]</code>.</li>
	<li>Element at <code>grid[m&nbsp;- 1][n - 1]</code> moves to <code>grid[0][0]</code>.</li>
</ul>

<p>Return the <em>2D grid</em> after applying shift operation <code>k</code> times.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/11/05/e1.png" style="width: 400px; height: 178px;" />
<pre>
<strong>Input:</strong> <code>grid</code> = [[1,2,3],[4,5,6],[7,8,9]], k = 1
<strong>Output:</strong> [[9,1,2],[3,4,5],[6,7,8]]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2019/11/05/e2.png" style="width: 400px; height: 166px;" />
<pre>
<strong>Input:</strong> <code>grid</code> = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
<strong>Output:</strong> [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> <code>grid</code> = [[1,2,3],[4,5,6],[7,8,9]], k = 9
<strong>Output:</strong> [[1,2,3],[4,5,6],[7,8,9]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m ==&nbsp;grid.length</code></li>
	<li><code>n ==&nbsp;grid[i].length</code></li>
	<li><code>1 &lt;= m &lt;= 50</code></li>
	<li><code>1 &lt;= n &lt;= 50</code></li>
	<li><code>-1000 &lt;= grid[i][j] &lt;= 1000</code></li>
	<li><code>0 &lt;= k &lt;= 100</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Treating the 2D grid as a continuous 1D array simplifies the shifting logic. Instead of simulating the shifts step-by-step, we can use modular arithmetic to directly calculate which original element belongs at each position in the final shifted grid, completely avoiding the overhead of intermediate states.

### Approach
- Calculate the total number of elements in the grid as `total = m * n`.
- Normalize the shift amount `k` using `k % total` to eliminate redundant full-cycle shifts that result in the exact same grid.
- Iterate through every row `i` and column `j` to construct the new shifted grid cell by cell.
- For each target position `(i, j)`, calculate its equivalent 1D index as `currentIdx = i * n + j`.
- Find the 1D index of the element that originally belongs in this new position by looking backwards: `origIdx = (currentIdx - k + total) % total`.
- Convert this original 1D index back into 2D coordinates using `origIdx / n` for the row and `origIdx % n` for the column, and place that element into the result.

### Complexity
- **Time:** O(m * n) — We iterate through each of the m * n cells in the grid exactly once to construct the result.
- **Space:** O(m * n) — We allocate a new list of lists of size m * n to store and return the shifted grid.
