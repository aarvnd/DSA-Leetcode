<h2><a href="https://leetcode.com/problems/sorted-gcd-pair-queries">Sorted GCD Pair Queries</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>You are given an integer array <code>nums</code> of length <code>n</code> and an integer array <code>queries</code>.</p>

<p>Let <code>gcdPairs</code> denote an array obtained by calculating the <span data-keyword="gcd-function">GCD</span> of all possible pairs <code>(nums[i], nums[j])</code>, where <code>0 &lt;= i &lt; j &lt; n</code>, and then sorting these values in <strong>ascending</strong> order.</p>

<p>For each query <code>queries[i]</code>, you need to find the element at index <code>queries[i]</code> in <code>gcdPairs</code>.</p>

<p>Return an integer array <code>answer</code>, where <code>answer[i]</code> is the value at <code>gcdPairs[queries[i]]</code> for each query.</p>

<p>The term <code>gcd(a, b)</code> denotes the <strong>greatest common divisor</strong> of <code>a</code> and <code>b</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,3,4], queries = [0,2,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,2]</span></p>

<p><strong>Explanation:</strong></p>

<p><code>gcdPairs = [gcd(nums[0], nums[1]), gcd(nums[0], nums[2]), gcd(nums[1], nums[2])] = [1, 2, 1]</code>.</p>

<p>After sorting in ascending order, <code>gcdPairs = [1, 1, 2]</code>.</p>

<p>So, the answer is <code>[gcdPairs[queries[0]], gcdPairs[queries[1]], gcdPairs[queries[2]]] = [1, 2, 2]</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,4,2,1], queries = [5,3,1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,2,1,1]</span></p>

<p><strong>Explanation:</strong></p>

<p><code>gcdPairs</code> sorted in ascending order is <code>[1, 1, 1, 2, 2, 4]</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,2], queries = [0,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">[2,2]</span></p>

<p><strong>Explanation:</strong></p>

<p><code>gcdPairs = [2]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n == nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= queries[i] &lt; n * (n - 1) / 2</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Instead of generating all $O(N^2)$ pairs, we can count the number of pairs for each possible GCD value up to the maximum element in the array. By counting how many numbers are multiples of a candidate GCD, we can find the number of pairs whose GCD is a multiple of that candidate, and then use a sieve-like inclusion-exclusion approach to deduce the exact number of pairs for each specific GCD.

### Approach
* Find the maximum value in `nums` (`maxVal`) and build a frequency array of the elements.
* For each candidate GCD `g` from 1 to `maxVal`, count the total numbers in `nums` that are multiples of `g`. Calculate the number of pairs formed by these multiples as `count * (count - 1) / 2`, which represents all pairs whose GCD is a multiple of `g`.
* Iterate backwards from `maxVal` down to 1, subtracting the pair counts of all strict multiples of `g` from the pair count of `g` to isolate the exact number of pairs with a GCD of exactly `g`.
* Transform this exact count array into a prefix sum array, where the value at index `g` represents the total number of pairs with a GCD less than or equal to `g`.
* For each query, perform a binary search over this prefix sum array to efficiently find the smallest GCD value whose cumulative pair count is strictly greater than the queried index.

### Complexity
- **Time:** O(N + M log M + Q log M) — where N is the length of `nums`, M is the maximum value in `nums`, and Q is the number of queries; the harmonic series sieve takes O(M log M) and each query takes O(log M) via binary search.
- **Space:** O(M) — for the frequency and pair count arrays of size up to the maximum element in `nums`.
