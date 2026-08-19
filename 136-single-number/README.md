<h2><a href="https://leetcode.com/problems/single-number">Single Number</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given a <strong>non-empty</strong>&nbsp;array of integers <code>nums</code>, every element appears <em>twice</em> except for one. Find that single one.</p>

<p>You must&nbsp;implement a solution with a linear runtime complexity and use&nbsp;only constant&nbsp;extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,2,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,1,2,1,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-3 * 10<sup>4</sup> &lt;= nums[i] &lt;= 3 * 10<sup>4</sup></code></li>
	<li>Each element in the array appears twice except for one element which appears only once.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is leveraging the properties of the bitwise XOR operation, specifically that XORing a number with itself results in zero (a ⊕ a = 0) and XORing a number with zero yields the number itself (a ⊕ 0 = a). Because XOR is both commutative and associative, the order of operations does not matter; all numbers that appear twice will cancel each other out, leaving only the single unpaired number.

### Approach
- Initialize a variable `result` to 0, which will accumulate the bitwise operations.
- Iterate through each integer in the given `nums` array.
- Update `result` by XORing it with the current integer.
- As the loop progresses, every pair of identical numbers will evaluate to 0, effectively removing themselves from the running total.
- Once the loop completes, return `result`, which now contains the only number that did not have a pair to cancel it out.

### Complexity
- **Time:** O(n) — We iterate through the array of n elements exactly once.
- **Space:** O(1) — We only use a single integer variable to keep track of the XOR sum, requiring no additional scaling memory.
