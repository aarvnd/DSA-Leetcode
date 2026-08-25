<h2><a href="https://leetcode.com/problems/smallest-missing-multiple-of-k">Smallest Missing Multiple of K</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given an integer array <code>nums</code> and an integer <code>k</code>, return the <strong>smallest positive multiple</strong> of <code>k</code> that is <strong>missing</strong> from <code>nums</code>.</p>

<p>A <strong>multiple</strong> of <code>k</code> is any positive integer divisible by <code>k</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [8,2,3,4,6], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<p>The multiples of <code>k = 2</code> are 2, 4, 6, 8, 10, 12... and the smallest multiple missing from <code>nums</code> is 10.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,4,7,10,15], k = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p>The multiples of <code>k = 5</code> are 5, 10, 15, 20... and the smallest multiple missing from <code>nums</code> is 5.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= 100</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
To efficiently find the smallest missing multiple, we can use a Hash Set to achieve constant-time lookups. By generating multiples of `k` in increasing order and checking against the set, the first one we don't find is guaranteed to be our answer.

### Approach
- Create a Hash Set and populate it with all the integers from the input array `nums`.
- Initialize a variable `multiple` to `k`, representing the first positive multiple of `k`.
- Continuously check if `multiple` exists in the Hash Set using a `while` loop.
- If it is present, increment `multiple` by `k` to check the next valid multiple.
- When the loop exits, return `multiple` as it is the smallest multiple missing from the array.

### Complexity
- **Time:** O(N) — Populating the set takes O(N) time, and we check at most N + 1 multiples before finding a missing one, resulting in linear overall time.
- **Space:** O(N) — The Hash Set stores at most N unique elements from the input array.
