<h2><a href="https://leetcode.com/problems/container-with-most-water">Container With Most Water</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given an integer array <code>height</code> of length <code>n</code>. There are <code>n</code> vertical lines drawn such that the two endpoints of the <code>i<sup>th</sup></code> line are <code>(i, 0)</code> and <code>(i, height[i])</code>.</p>

<p>Find two lines that together with the x-axis form a container, such that the container contains the most water.</p>

<p>Return <em>the maximum amount of water a container can store</em>.</p>

<p><strong>Notice</strong> that you may not slant the container.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;" />
<pre>
<strong>Input:</strong> height = [1,8,6,2,5,4,8,3,7]
<strong>Output:</strong> 49
<strong>Explanation:</strong> The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> height = [1,1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The volume of water a container can hold is constrained by its shorter vertical boundary. By starting with the maximum possible width and iteratively moving the pointer of the shorter line inward, we trade width for the possibility of finding a taller line that could yield a larger total area.

### Approach
- Initialize two pointers, `left` at the start of the array and `right` at the end.
- Maintain a `maxArea` variable to track the largest container volume found so far.
- Loop while the `left` pointer is strictly less than the `right` pointer.
- Calculate the current area by multiplying the distance between the pointers by the minimum of the two heights, updating `maxArea` if this current area is larger.
- Advance the pointer pointing to the shorter line inward (`left++` if the left line is shorter, otherwise `right--`), because moving the taller line would only decrease the width without improving the height bottleneck.

### Complexity
- **Time:** O(n) — We traverse the array exactly once as the two pointers move toward each other and meet.
- **Space:** O(1) — We only use a few extra integer variables for the pointers and area calculations, requiring constant extra space.
