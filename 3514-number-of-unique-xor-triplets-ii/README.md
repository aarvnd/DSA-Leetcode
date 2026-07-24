<h2><a href="https://leetcode.com/problems/number-of-unique-xor-triplets-ii">Number of Unique XOR Triplets II</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p data-end="261" data-start="147">You are given an integer array <code>nums</code>.</p>

<p>A <strong>XOR triplet</strong> is defined as the XOR of three elements <code>nums[i] XOR nums[j] XOR nums[k]</code> where <code>i &lt;= j &lt;= k</code>.</p>

<p>Return the number of <strong>unique</strong> XOR triplet values from all possible triplets <code>(i, j, k)</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p data-end="158" data-start="101">The possible XOR triplet values are:</p>

<ul data-end="280" data-start="159">
	<li data-end="188" data-start="159"><code>(0, 0, 0) &rarr; 1 XOR 1 XOR 1 = 1</code></li>
	<li data-end="218" data-start="189"><code>(0, 0, 1) &rarr; 1 XOR 1 XOR 3 = 3</code></li>
	<li data-end="248" data-start="219"><code>(0, 1, 1) &rarr; 1 XOR 3 XOR 3 = 1</code></li>
	<li data-end="280" data-start="249"><code>(1, 1, 1) &rarr; 3 XOR 3 XOR 3 = 3</code></li>
</ul>

<p data-end="343" data-start="282">The unique XOR values are <code data-end="316" data-start="308">{1, 3}</code>. Thus, the output is 2.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [6,7,8,9]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<p>The possible XOR triplet values are <code data-end="275" data-start="267">{6, 7, 8, 9}</code>. Thus, the output is 4.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1500</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1500</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that because indices can overlap (`i <= j <= k`), any single element `y` is inherently a valid triplet XOR (since `x ^ x ^ y = y`). The remaining valid triplet XORs are formed by three distinct elements. Instead of an $O(N^3)$ brute force, we can deduplicate the array and iteratively build the results by keeping track of all pairwise XORs in a highly efficient bitset, combining them with a third element on the fly.

### Approach
- Deduplicate `nums` into a list of unique elements, as duplicate values do not generate any new XOR combinations.
- Initialize a boolean array of `possible` triplet XORs, marking all single unique elements as valid (which covers the `x ^ x ^ y = y` and `x ^ x ^ x = x` cases).
- Maintain a custom bitset (using an array of 32 `long`s) to track all pairwise XORs (`x ^ y`) of the elements processed so far.
- Iterate through each unique element `z`. First, XOR `z` with every active bit in the pairwise bitset to find and mark new valid triplet XORs (`z ^ (x ^ y)`).
- Then, pair `z` with all previously processed unique elements to add new pairwise XORs (`z ^ x`) to the bitset.
- Finally, count and return the number of `true` flags in the `possible` array.

### Complexity
- **Time:** O(U^2 + U \cdot \frac{M}{64}) where $U \le 1500$ is the number of unique elements and $M = 2048$ is the max XOR value — iterating previous elements and the 32-long bitset takes quadratic time relative to the unique elements.
- **Space:** O(M) where $M = 2048$ — the bitset, boolean tracking arrays, and unique element arrays are all strictly bounded by the maximum possible XOR value.
