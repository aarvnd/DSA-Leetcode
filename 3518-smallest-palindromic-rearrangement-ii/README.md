<h2><a href="https://leetcode.com/problems/smallest-palindromic-rearrangement-ii">Smallest Palindromic Rearrangement II</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p data-end="332" data-start="99">You are given a <strong><span data-keyword="palindrome-string">palindromic</span></strong> string <code>s</code> and an integer <code>k</code>.</p>

<p>Return the <strong>k-th</strong> <strong><span data-keyword="lexicographically-smaller-string">lexicographically smallest</span></strong> palindromic <span data-keyword="permutation-string">permutation</span> of <code>s</code>. If there are fewer than <code>k</code> distinct palindromic permutations, return an empty string.</p>

<p><strong>Note:</strong> Different rearrangements that yield the same palindromic string are considered identical and are counted once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abba&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;baab&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The two distinct palindromic rearrangements of <code>&quot;abba&quot;</code> are <code>&quot;abba&quot;</code> and <code>&quot;baab&quot;</code>.</li>
	<li>Lexicographically, <code>&quot;abba&quot;</code> comes before <code>&quot;baab&quot;</code>. Since <code>k = 2</code>, the output is <code>&quot;baab&quot;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aa&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is only one palindromic rearrangement: <code data-end="1112" data-start="1106">&quot;aa&quot;</code>.</li>
	<li>The output is an empty string since <code>k = 2</code> exceeds the number of possible rearrangements.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;bacab&quot;, k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;abcba&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The two distinct palindromic rearrangements of <code>&quot;bacab&quot;</code> are <code>&quot;abcba&quot;</code> and <code>&quot;bacab&quot;</code>.</li>
	<li>Lexicographically, <code>&quot;abcba&quot;</code> comes before <code>&quot;bacab&quot;</code>. Since <code>k = 1</code>, the output is <code>&quot;abcba&quot;</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
	<li><code>s</code> is guaranteed to be palindromic.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>6</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that a palindrome is entirely determined by its first half, reducing the problem to finding the $k$-th lexicographically smallest permutation of the first half's characters. By systematically counting the number of valid permutations for the remaining characters, we can greedily construct the optimal first half character by character from left to right without actually generating all permutations.

### Approach
- Precompute binomial coefficients (nCr) up to a maximum value of $1,000,001$ (since $k \le 10^6$) to allow for fast retrieval while preventing integer overflow.
- Count the frequencies of each character in the input string, halving them to determine the exact character pool available for the first half, and isolate the single odd-frequency character (if any) to serve as the fixed middle.
- Calculate the total possible permutations of the first half using a multinomial coefficient approach; if this total is strictly less than $k$, return an empty string.
- Construct the first half iteratively: for each position, test available characters from 'a' to 'z' in alphabetical order.
- For each candidate character, calculate the number of valid permutations of the remaining characters; if this number is at least $k$, lock in the character and proceed to the next position, otherwise subtract the permutations count from $k$ and try the next letter.
- Assemble and return the final palindrome by concatenating the constructed first half, the middle character, and the reversed first half.

### Complexity
- **Time:** O(N) — where N is the length of the string, as we iterate through N/2 positions, checking up to 26 characters per position, with each permutation calculation taking O(26) time.
- **Space:** O(N) — for the precomputed combinations table of size (N/2) × 22 and the string builders used to construct the final result.
