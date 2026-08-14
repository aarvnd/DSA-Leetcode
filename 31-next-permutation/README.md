<h2><a href="https://leetcode.com/problems/next-permutation">Next Permutation</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>A <strong>permutation</strong> of an array of integers is an arrangement of its members into a sequence or linear order.</p>

<ul>
	<li>For example, for <code>arr = [1,2,3]</code>, the following are all the permutations of <code>arr</code>: <code>[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]</code>.</li>
</ul>

<p>The <strong>next permutation</strong> of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the <strong>next permutation</strong> of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).</p>

<ul>
	<li>For example, the next permutation of <code>arr = [1,2,3]</code> is <code>[1,3,2]</code>.</li>
	<li>Similarly, the next permutation of <code>arr = [2,3,1]</code> is <code>[3,1,2]</code>.</li>
	<li>While the next permutation of <code>arr = [3,2,1]</code> is <code>[1,2,3]</code> because <code>[3,2,1]</code> does not have a lexicographical larger rearrangement.</li>
</ul>

<p>Given an array of integers <code>nums</code>, <em>find the next permutation of</em> <code>nums</code>.</p>

<p>The replacement must be <strong><a href="http://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in place</a></strong> and use only constant extra memory.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [1,3,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> [1,2,3]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,5]
<strong>Output:</strong> [1,5,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
To find the next lexicographically greater permutation, we must modify the sequence as far to the right as possible. By finding the first element from the right that breaks the descending order (the pivot), swapping it with the next largest element to its right, and then reversing the remaining suffix, we achieve the smallest possible increase in the sequence's overall value.

### Approach
- Scan the array from right to left to find the first element `nums[i]` that is smaller than its right neighbor `nums[i + 1]`. This identifies the pivot.
- If no such pivot exists (the array is entirely in descending order), the array is at its maximum permutation, so we skip to the final reversal step to reset it.
- If a pivot is found, scan from right to left again to find the first element `nums[j]` that is strictly greater than `nums[i]`.
- Swap the elements at indices `i` and `j` to increment the prefix to its next lexicographical value.
- Reverse the suffix of the array starting from `i + 1` to the end. Because this suffix was originally in descending order, reversing it sorts it in ascending order, ensuring the new permutation is as small as possible.

### Complexity
- **Time:** O(n) — We make at most two linear passes over the array (finding indices and reversing the suffix), where n is the length of the array.
- **Space:** O(1) — All modifications are performed in-place using only a few variables for pointers.
