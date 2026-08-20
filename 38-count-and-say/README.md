<h2><a href="https://leetcode.com/problems/count-and-say">Count and Say</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>The <strong>count-and-say</strong> sequence is a sequence of digit strings defined by the recursive formula:</p>

<ul>
	<li><code>countAndSay(1) = &quot;1&quot;</code></li>
	<li><code>countAndSay(n)</code> is the run-length encoding of <code>countAndSay(n - 1)</code>.</li>
</ul>

<p><a href="http://en.wikipedia.org/wiki/Run-length_encoding" target="_blank">Run-length encoding</a> (RLE) is a string compression method that works by replacing each maximal group of consecutive identical characters with the concatenation of the length of the group followed by the character itself. For example, to compress the string <code>&quot;3322251&quot;</code> we replace <code>&quot;33&quot;</code> with <code>&quot;23&quot;</code>, replace <code>&quot;222&quot;</code> with <code>&quot;32&quot;</code>, replace <code>&quot;5&quot;</code> with <code>&quot;15&quot;</code>, and replace <code>&quot;1&quot;</code> with <code>&quot;11&quot;</code>. Thus the compressed string becomes <code>&quot;23321511&quot;</code>.</p>

<p>Given a positive integer <code>n</code>, return <em>the </em><code>n<sup>th</sup></code><em> element of the <strong>count-and-say</strong> sequence</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;1211&quot;</span></p>

<p><strong>Explanation:</strong></p>

<pre>
countAndSay(1) = &quot;1&quot;
countAndSay(2) = RLE of &quot;1&quot; = &quot;11&quot;
countAndSay(3) = RLE of &quot;11&quot; = &quot;21&quot;
countAndSay(4) = RLE of &quot;21&quot; = &quot;1211&quot;
</pre>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;1&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>This is the base case.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 30</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve it iteratively?

<hr>

## Solution Explanation

### Intuition
The problem inherently describes a step-by-step transformation where each sequence term depends entirely on reading the previous one aloud. By starting at the base case ("1") and iteratively applying run-length encoding rules, we can build the target string progressively without needing complex recursion.

### Approach
* Initialize the base case string `current` as `"1"`.
* Loop from 2 up to `n`, building the next sequence term in each iteration using a `StringBuilder`.
* Use a pointer `j` to iterate through the characters of the `current` string.
* For each character, use an inner `while` loop to count how many consecutive times it appears before the character changes or the string ends.
* Append the computed `count` followed by the character itself to the `StringBuilder`.
* Update `current` with the newly built string and repeat until the `n`th sequence is reached.

### Complexity
- **Time:** O(2^n) — In the worst case, the length of the string doubles with each iteration, meaning the total number of characters processed across all steps is bounded by an exponential curve (more precisely, it grows by Conway's constant, roughly O(1.3^n)).
- **Space:** O(2^n) — The `StringBuilder` and the new string allocations require space proportional to the length of the generated sequence, which grows exponentially.
