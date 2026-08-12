<h2><a href="https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency">Length of Longest Subarray With at Most K Frequency</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p>

<p>The <strong>frequency</strong> of an element <code>x</code> is the number of times it occurs in an array.</p>

<p>An array is called <strong>good</strong> if the frequency of each element in this array is <strong>less than or equal</strong> to <code>k</code>.</p>

<p>Return <em>the length of the <strong>longest</strong> <strong>good</strong> subarray of</em> <code>nums</code><em>.</em></p>

<p>A <strong>subarray</strong> is a contiguous non-empty sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,1,2,3,1,2], k = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3 occur at most twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
It can be shown that there are no good subarrays with length more than 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,1,2,1,2,1,2], k = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> The longest possible good subarray is [1,2] since the values 1 and 2 occur at most once in this subarray. Note that the subarray [2,1] is also good.
It can be shown that there are no good subarrays with length more than 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,5,5,5,5,5,5], k = 4
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest possible good subarray is [5,5,5,5] since the value 5 occurs 4 times in this subarray.
It can be shown that there are no good subarrays with length more than 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem asks for the longest contiguous subarray satisfying a frequency constraint, making it a perfect candidate for the sliding window technique. By using two pointers to represent the window and a hash map to track element frequencies, we can continuously expand the window to the right and only shrink it from the left when the newly added element causes its frequency to exceed `k`.

### Approach
- Initialize a hash map to store the frequencies of elements in the current window, along with a `left` pointer and a `maxLen` tracker set to 0.
- Iterate through the array using a `right` pointer to expand the window, incrementing the frequency of the current element `nums[right]` in the hash map.
- Check if the frequency of the newly added element exceeds the allowed limit `k`.
- If the limit is exceeded, enter a `while` loop to shrink the window from the left by decrementing the frequency of `nums[left]` and advancing the `left` pointer until the window becomes valid again.
- Once the window is valid, calculate its current length (`right - left + 1`) and update `maxLen` with the maximum length found so far.

### Complexity
- **Time:** O(N) — Both the `left` and `right` pointers traverse the array of size N at most once, and hash map operations take O(1) average time.
- **Space:** O(N) — In the worst case, all elements in the array are unique, requiring the hash map to store N distinct key-value pairs.
