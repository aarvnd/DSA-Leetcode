<h2><a href="https://leetcode.com/problems/3sum">3Sum</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given an integer array nums, return all the triplets <code>[nums[i], nums[j], nums[k]]</code> such that <code>i != j</code>, <code>i != k</code>, and <code>j != k</code>, and <code>nums[i] + nums[j] + nums[k] == 0</code>.</p>

<p>Notice that the solution set must not contain duplicate triplets.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,0,1,2,-1,-4]
<strong>Output:</strong> [[-1,-1,2],[-1,0,1]]
<strong>Explanation:</strong> 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,1]
<strong>Output:</strong> []
<strong>Explanation:</strong> The only possible triplet does not sum up to 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,0]
<strong>Output:</strong> [[0,0,0]]
<strong>Explanation:</strong> The only possible triplet sums up to 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 3000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Sorting the array is the key insight, as it allows us to fix one number and reduce the rest of the problem to a standard "Two Sum" search using an efficient two-pointer approach. Furthermore, the sorted order makes it trivial to skip adjacent duplicate values, guaranteeing that we do not generate duplicate triplets in our final result.

### Approach
- Sort the input array in ascending order to enable the two-pointer technique and simplify deduplication.
- Iterate through the array with an index `i` to fix the first element of the triplet. If `nums[i] > 0`, break early because the array is sorted and no subsequent numbers can sum to zero.
- Skip any duplicate values for `nums[i]` (where `nums[i] == nums[i-1]`) to ensure unique triplets in the result.
- Initialize two pointers, `left` at `i + 1` and `right` at the end of the array, and calculate the sum of the three elements.
- If the sum is zero, add the triplet to the result, then move both pointers inward while skipping any adjacent duplicate values for both `left` and `right`.
- If the sum is less than zero, increment the `left` pointer to increase the sum; if the sum is greater than zero, decrement the `right` pointer to decrease it.

### Complexity
- **Time:** O(N^2) — Sorting takes O(N log N) time, and the nested two-pointer traversal takes O(N) time for each of the N elements.
- **Space:** O(log N) to O(N) — Auxiliary space required by the sorting algorithm, excluding the space needed to store the output list.
