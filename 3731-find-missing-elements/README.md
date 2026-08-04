<h2><a href="https://leetcode.com/problems/find-missing-elements">Find Missing Elements</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given an integer array <code>nums</code> consisting of <strong>unique</strong> integers.</p>

<p>Originally, <code>nums</code> contained <strong>every integer</strong> within a certain range. However, some integers might have gone <strong>missing</strong> from the array.</p>

<p>The <strong>smallest</strong> and <strong>largest</strong> integers of the original range are still present in <code>nums</code>.</p>

<p>Return a <strong>sorted</strong> list of all the missing integers in this range. If no integers are missing, return an <strong>empty</strong> list.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,4,2,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">[3]</span></p>

<p><strong>Explanation:</strong></p>

<p>The smallest integer is 1 and the largest is 5, so the full range should be <code>[1,2,3,4,5]</code>. Among these, only 3 is missing.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [7,8,6,9]</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>

<p><strong>Explanation:</strong></p>

<p>The smallest integer is 6 and the largest is 9, so the full range is <code>[6,7,8,9]</code>. All integers are already present, so no integer is missing.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [5,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">[2,3,4]</span></p>

<p><strong>Explanation:</strong></p>

<p>The smallest integer is 1 and the largest is 5, so the full range should be <code>[1,2,3,4,5]</code>. The missing integers are 2, 3, and 4.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that because the maximum possible integer value is very small (up to 100), we can use a fixed-size boolean array as a direct-address table to track seen numbers in constant time while simultaneously identifying the minimum and maximum bounds of the original range.

### Approach
- Initialize variables to track the minimum and maximum values found in the array.
- Create a boolean array `present` of size 101 to record the existence of each number.
- Iterate through the input array `nums`, updating the minimum and maximum bounds, and marking `present[num]` as `true` for each number encountered.
- Create an empty list to store the missing integers.
- Iterate sequentially from the minimum value to the maximum value.
- If a number in this range is not marked as present, add it to the result list (which naturally keeps the output sorted).

### Complexity
- **Time:** O(N) — where N is the length of the array, as we iterate through the array once and then loop through a constant maximum range of 100.
- **Space:** O(1) — because the boolean array requires a constant amount of space (size 101) regardless of the input size.
