<h2><a href="https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence">Find the Lexicographically Smallest Valid Sequence</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given two strings <code>word1</code> and <code>word2</code>.</p>

<p>A string <code>x</code> is called <strong>almost equal</strong> to <code>y</code> if you can change <strong>at most</strong> one character in <code>x</code> to make it <em>identical</em> to <code>y</code>.</p>

<p>A sequence of indices <code>seq</code> is called <strong>valid</strong> if:</p>

<ul>
	<li>The indices are sorted in <strong>ascending</strong> order.</li>
	<li><em>Concatenating</em> the characters at these indices in <code>word1</code> in <strong>the same</strong> order results in a string that is <strong>almost equal</strong> to <code>word2</code>.</li>
</ul>

<p>Return an array of size <code>word2.length</code> representing the <span data-keyword="lexicographically-smaller-array">lexicographically smallest</span> <strong>valid</strong> sequence of indices. If no such sequence of indices exists, return an <strong>empty</strong> array.</p>

<p><strong>Note</strong> that the answer must represent the <em>lexicographically smallest array</em>, <strong>not</strong> the corresponding string formed by those indices.<!-- notionvc: 2ff8e782-bd6f-4813-a421-ec25f7e84c1e --></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word1 = &quot;vbcca&quot;, word2 = &quot;abc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,1,2]</span></p>

<p><strong>Explanation:</strong></p>

<p>The lexicographically smallest valid sequence of indices is <code>[0, 1, 2]</code>:</p>

<ul>
	<li>Change <code>word1[0]</code> to <code>&#39;a&#39;</code>.</li>
	<li><code>word1[1]</code> is already <code>&#39;b&#39;</code>.</li>
	<li><code>word1[2]</code> is already <code>&#39;c&#39;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word1 = &quot;bacdc&quot;, word2 = &quot;abc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,4]</span></p>

<p><strong>Explanation:</strong></p>

<p>The lexicographically smallest valid sequence of indices is <code>[1, 2, 4]</code>:</p>

<ul>
	<li><code>word1[1]</code> is already <code>&#39;a&#39;</code>.</li>
	<li>Change <code>word1[2]</code> to <code>&#39;b&#39;</code>.</li>
	<li><code>word1[4]</code> is already <code>&#39;c&#39;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word1 = &quot;aaaaaa&quot;, word2 = &quot;aaabc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no valid sequence of indices.</p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word1 = &quot;abc&quot;, word2 = &quot;ab&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,1]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word2.length &lt; word1.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>word1</code> and <code>word2</code> consist only of lowercase English letters.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
To find the lexicographically smallest sequence of indices, we must greedily match characters from left to right, picking the earliest possible indices in `word1`. When characters don't match, we can use our single allowed change, but only if we are guaranteed that the remaining suffix of `word2` can still be found as a subsequence in the remaining portion of `word1`. By precomputing the rightmost possible starting positions for every suffix of `word2` within `word1`, we can instantly check in $O(1)$ time if using our one change at the current index leaves enough room to complete the sequence.

### Approach
- Create a `last` array of size $m + 1$ where `last[j]` stores the rightmost index in `word1` that can match `word2[j]` such that the entire suffix `word2[j...m-1]` is a valid subsequence.
- Populate this `last` array by iterating backwards through both strings, greedily matching characters from right to left.
- Iterate forwards through `word1` (pointer `i`) and `word2` (pointer `j`) to build the result.
- If `word1[i] == word2[j]`, record the index `i` in the answer and advance both pointers.
- If they do not match, check if we haven't used our change yet and if the remaining suffix of `word2` can be safely matched after index `i` (`last[j + 1] > i`). If so, record `i`, mark the change as used, and advance both pointers.
- If neither condition is met, advance only `i` to look for the next possible match. Return the collected indices if all characters of `word2` were matched, otherwise return an empty array.

### Complexity
- **Time:** O(N) — where N is the length of `word1`, as we perform one backward pass and one forward pass through the strings.
- **Space:** O(M) — where M is the length of `word2`, required to store the `last` suffix array and the resulting answer array.
