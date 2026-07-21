<h2><a href="https://leetcode.com/problems/maximize-active-section-with-trade-i">Maximize Active Section with Trade I</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given a binary string <code>s</code> of length <code>n</code>, where:</p>

<ul>
	<li><code>&#39;1&#39;</code> represents an <strong>active</strong> section.</li>
	<li><code>&#39;0&#39;</code> represents an <strong>inactive</strong> section.</li>
</ul>

<p>You can perform <strong>at most one trade</strong> to maximize the number of active sections in <code>s</code>. In a trade, you:</p>

<ul>
	<li>Convert a contiguous block of <code>&#39;1&#39;</code>s that is surrounded by <code>&#39;0&#39;</code>s to all <code>&#39;0&#39;</code>s.</li>
	<li>Afterward, convert a contiguous block of <code>&#39;0&#39;</code>s that is surrounded by <code>&#39;1&#39;</code>s to all <code>&#39;1&#39;</code>s.</li>
</ul>

<p>Return the <strong>maximum</strong> number of active sections in <code>s</code> after making the optimal trade.</p>

<p><strong>Note:</strong> Treat <code>s</code> as if it is <strong>augmented</strong> with a <code>&#39;1&#39;</code> at both ends, forming <code>t = &#39;1&#39; + s + &#39;1&#39;</code>. The augmented <code>&#39;1&#39;</code>s <strong>do not</strong> contribute to the final count.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;01&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>Because there is no block of <code>&#39;1&#39;</code>s surrounded by <code>&#39;0&#39;</code>s, no valid trade is possible. The maximum number of active sections is 1.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;0100&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>String <code>&quot;0100&quot;</code> &rarr; Augmented to <code>&quot;101001&quot;</code>.</li>
	<li>Choose <code>&quot;0100&quot;</code>, convert <code>&quot;10<u><strong>1</strong></u>001&quot;</code> &rarr; <code>&quot;1<u><strong>0000</strong></u>1&quot;</code> &rarr; <code>&quot;1<u><strong>1111</strong></u>1&quot;</code>.</li>
	<li>The final string without augmentation is <code>&quot;1111&quot;</code>. The maximum number of active sections is 4.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;1000100&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>String <code>&quot;1000100&quot;</code> &rarr; Augmented to <code>&quot;110001001&quot;</code>.</li>
	<li>Choose <code>&quot;000100&quot;</code>, convert <code>&quot;11000<u><strong>1</strong></u>001&quot;</code> &rarr; <code>&quot;11<u><strong>000000</strong></u>1&quot;</code> &rarr; <code>&quot;11<u><strong>111111</strong></u>1&quot;</code>.</li>
	<li>The final string without augmentation is <code>&quot;1111111&quot;</code>. The maximum number of active sections is 7.</li>
</ul>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;01010&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>String <code>&quot;01010&quot;</code> &rarr; Augmented to <code>&quot;1010101&quot;</code>.</li>
	<li>Choose <code>&quot;010&quot;</code>, convert <code>&quot;10<u><strong>1</strong></u>0101&quot;</code> &rarr; <code>&quot;1<u><strong>000</strong></u>101&quot;</code> &rarr; <code>&quot;1<u><strong>111</strong></u>101&quot;</code>.</li>
	<li>The final string without augmentation is <code>&quot;11110&quot;</code>. The maximum number of active sections is 4.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
By conceptually augmenting the string with '1's at both ends, it becomes an alternating sequence of '1' and '0' blocks. A valid trade sacrifices an internal '1' block—merging it with its two adjacent '0' blocks—and then converts *any* '0' block into '1's. The optimal strategy either flips this newly merged '0' block (yielding a net gain equal to the sizes of both adjacent '0' blocks) or flips the largest '0' block elsewhere in the string (yielding a net gain of its size minus the sacrificed '1' block).

### Approach
- Count the initial number of '1's in the original string.
- Parse the augmented string to extract the lengths of all contiguous '1' blocks into an array `A` and '0' blocks into an array `B`.
- If there are fewer than three '1' blocks, no internal '1' block exists to trade, so return the initial count immediately.
- Precompute prefix and suffix maximums for array `B` to efficiently find the largest '0' block outside of any given adjacent pair.
- Iterate through each internal '1' block `A[i]` and evaluate two options: flipping the newly merged block (net gain: `B[i-1] + B[i]`) or flipping the largest disjoint '0' block (net gain: `maxOtherB - A[i]`).
- Track the maximum net gain across all internal blocks and add it to the initial count of '1's to get the final answer.

### Complexity
- **Time:** O(n) — Parsing the string and computing the prefix/suffix maximums require a constant number of linear passes.
- **Space:** O(n) — Storing the block lengths and the prefix/suffix maximum arrays requires space proportional to the number of blocks, which is bounded by the string length.
