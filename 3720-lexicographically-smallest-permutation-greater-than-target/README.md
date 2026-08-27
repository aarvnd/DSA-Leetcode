<h2><a href="https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target">Lexicographically Smallest Permutation Greater Than Target</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given two strings <code>s</code> and <code>target</code>, both having length <code>n</code>, consisting of lowercase English letters.</p>

<p>Return the <strong>lexicographically smallest <span data-keyword="permutation-string">permutation</span></strong> of <code>s</code> that is <strong>strictly</strong> greater than <code>target</code>. If no permutation of <code>s</code> is lexicographically strictly greater than <code>target</code>, return an empty string.</p>

<p>A string <code>a</code> is <strong>lexicographically strictly greater </strong>than a string <code>b</code> (of the same length) if in the first position where <code>a</code> and <code>b</code> differ, string <code>a</code> has a letter that appears later in the alphabet than the corresponding letter in <code>b</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abc&quot;, target = &quot;bba&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;bca&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The permutations of <code>s</code> (in lexicographical order) are <code>&quot;abc&quot;</code>, <code>&quot;acb&quot;</code>, <code>&quot;bac&quot;</code>, <code>&quot;bca&quot;</code>, <code>&quot;cab&quot;</code>, and <code>&quot;cba&quot;</code>.</li>
	<li>The lexicographically smallest permutation that is strictly greater than <code>target</code> is <code>&quot;bca&quot;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;leet&quot;, target = &quot;code&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;eelt&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The permutations of <code>s</code> (in lexicographical order) are <code>&quot;eelt&quot;</code>, <code>&quot;eetl&quot;</code>, <code>&quot;elet&quot;</code>, <code>&quot;elte&quot;</code>, <code>&quot;etel&quot;</code>, <code>&quot;etle&quot;</code>, <code>&quot;leet&quot;</code>, <code>&quot;lete&quot;</code>, <code>&quot;ltee&quot;</code>, <code>&quot;teel&quot;</code>, <code>&quot;tele&quot;</code>, and <code>&quot;tlee&quot;</code>.</li>
	<li>The lexicographically smallest permutation that is strictly greater than <code>target</code> is <code>&quot;eelt&quot;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;baba&quot;, target = &quot;bbaa&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The permutations of <code>s</code> (in lexicographical order) are <code>&quot;aabb&quot;</code>, <code>&quot;abab&quot;</code>, <code>&quot;abba&quot;</code>, <code>&quot;baab&quot;</code>, <code>&quot;baba&quot;</code>, and <code>&quot;bbaa&quot;</code>.</li>
	<li>None of them is lexicographically strictly greater than <code>target</code>. Therefore, the answer is <code>&quot;&quot;</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length == target.length &lt;= 300</code></li>
	<li><code>s</code> and <code>target</code> consist of only lowercase English letters.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
To find the lexicographically smallest permutation of `s` that is strictly greater than `target`, we must maximize the length of the common prefix they share. By iterating backwards through the indices of `target`, we can find the longest possible prefix where we can exactly match `target`, and then place a character strictly greater than `target`'s character at the very next position. 

### Approach
- Count the character frequencies of the string `s` to know our available character pool.
- Build a prefix frequency array for `target` to quickly determine the exact character counts required to match any prefix of `target` up to a given index.
- Iterate backwards from the end of `target` to index `0`. This index `i` represents the point where our new permutation will diverge from `target`.
- For each index `i`, check if `s` has enough characters to perfectly match the prefix of `target` up to `i-1`. If it does, calculate the remaining available characters.
- Look for the smallest available character in our remaining pool that is strictly greater than `target[i]`. 
- If such a character is found, construct the final string: append the matching prefix, append the chosen greater character, and finally append all remaining characters in alphabetical order. Return this string immediately.

### Complexity
- **Time:** O(n) — Precomputing the prefix counts and iterating backwards both take O(n) time, as the inner loops over the alphabet run in constant O(26) time, and the string construction occurs at most once.
- **Space:** O(n) — The prefix frequency array requires O(26 * n) space, and the StringBuilder requires O(n) space to form the result.
