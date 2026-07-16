<h2><a href="https://leetcode.com/problems/sum-of-gcd-of-formed-pairs">Sum of GCD of Formed Pairs</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given an integer array <code>nums</code> of length <code>n</code>.</p>

<p>Construct an array <code>prefixGcd</code> where for each index <code>i</code>:</p>

<ul>
	<li>Let <code>mx<sub>i</sub> = max(nums[0], nums[1], ..., nums[i])</code>.</li>
	<li><code>prefixGcd[i] = gcd(nums[i], mx<sub>i</sub>)</code>.</li>
</ul>

<p>After constructing <code>prefixGcd</code>:</p>

<ul>
	<li>Sort <code>prefixGcd</code> in <strong>non-decreasing</strong> order.</li>
	<li>Form pairs by taking the <strong>smallest unpaired</strong> element and the <strong>largest unpaired</strong> element.</li>
	<li>Repeat this process until no more pairs can be formed.</li>
	<li>For each formed pair, <strong>compute</strong> the <code>gcd</code> of the two elements.</li>
	<li>If <code>n</code> is odd, the <strong>middle</strong> element in the <code>prefixGcd</code> array remains <strong>unpaired</strong> and should be ignored.</li>
</ul>

<p>Return an integer denoting the <strong>sum of the GCD</strong> values of all formed pairs.</p>
The term <code>gcd(a, b)</code> denotes the <strong>greatest common divisor</strong> of <code>a</code> and <code>b</code>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,6,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>Construct <code>prefixGcd</code>:</p>

<table style="border: 1px solid black;">
	<thead>
		<tr>
			<th style="border: 1px solid black;"><code>i</code></th>
			<th style="border: 1px solid black;"><code>nums[i]</code></th>
			<th style="border: 1px solid black;"><code>mx<sub>i</sub></code></th>
			<th style="border: 1px solid black;"><code>prefixGcd[i]</code></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="border: 1px solid black;">0</td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">2</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">6</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">4</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">2</td>
		</tr>
	</tbody>
</table>

<p><code>prefixGcd = [2, 6, 2]</code>. After sorting, it forms <code>[2, 2, 6]</code>.</p>

<p>Pair the smallest and largest elements: <code>gcd(2, 6) = 2</code>. The remaining middle element 2 is ignored. Thus, the sum is 2.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,6,2,8]</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p>Construct <code>prefixGcd</code>:</p>

<table style="border: 1px solid black;">
	<thead>
		<tr>
			<th style="border: 1px solid black;"><code>i</code></th>
			<th style="border: 1px solid black;"><code>nums[i]</code></th>
			<th style="border: 1px solid black;"><code>mx<sub>i</sub></code></th>
			<th style="border: 1px solid black;"><code>prefixGcd[i]</code></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="border: 1px solid black;">0</td>
			<td style="border: 1px solid black;">3</td>
			<td style="border: 1px solid black;">3</td>
			<td style="border: 1px solid black;">3</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">1</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">6</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">2</td>
			<td style="border: 1px solid black;">6</td>
			<td style="border: 1px solid black;">2</td>
		</tr>
		<tr>
			<td style="border: 1px solid black;">3</td>
			<td style="border: 1px solid black;">8</td>
			<td style="border: 1px solid black;">8</td>
			<td style="border: 1px solid black;">8</td>
		</tr>
	</tbody>
</table>

<p><code>prefixGcd = [3, 6, 2, 8]</code>. After sorting, it forms <code>[2, 3, 6, 8]</code>.</p>

<p>Form pairs: <code>gcd(2, 8) = 2</code> and <code>gcd(3, 6) = 3</code>. Thus, the sum is <code>2 + 3 = 5</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>​​​​​​​9</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem is a direct simulation of the described steps, and the key insight is that maintaining a running maximum allows us to construct the prefix GCD array in a single pass. Once constructed and sorted, a standard two-pointer technique efficiently pairs the smallest and largest available elements to compute the final sum while naturally handling the odd-length edge case.

### Approach
- Initialize a running maximum variable to track the largest element seen so far.
- Iterate through the input array, updating the running maximum at each step.
- Populate the `prefixGcd` array by computing the GCD of the current element and the running maximum.
- Sort the `prefixGcd` array in non-decreasing order.
- Use two pointers, starting at the beginning and the end of the sorted array, to pair the smallest and largest unpaired elements.
- Compute the GCD of each pair, add it to a running total, and move the pointers inward until they meet or cross (which automatically ignores the middle element if the array length is odd).

### Complexity
- **Time:** O(N log N + N log M) — where N is the length of the array and M is the maximum value in the array; sorting takes O(N log N) and computing the GCDs takes O(N log M) time.
- **Space:** O(N) — for allocating the `prefixGcd` array to store the intermediate GCD values.
