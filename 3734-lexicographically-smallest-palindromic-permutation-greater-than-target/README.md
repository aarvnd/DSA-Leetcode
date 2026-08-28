<h2><a href="https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target">Lexicographically Smallest Palindromic Permutation Greater Than Target</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>You are given two strings <code>s</code> and <code>target</code>, each of length <code>n</code>, consisting of lowercase English letters.</p>

<p>Return the <strong><span data-keyword="lexicographically-smaller-string">lexicographically smallest</span> string</strong> that is <strong>both</strong> a <strong><span data-keyword="palindrome-string">palindromic</span> <span data-keyword="permutation">permutation</span></strong> of <code>s</code> and <strong>strictly</strong> greater than <code>target</code>. If no such permutation exists, return an empty string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;baba&quot;, target = &quot;abba&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;baab&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The palindromic permutations of <code>s</code> (in lexicographical order) are <code>&quot;abba&quot;</code> and <code>&quot;baab&quot;</code>.</li>
	<li>The lexicographically smallest permutation that is strictly greater than <code>target</code> is <code>&quot;baab&quot;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;baba&quot;, target = &quot;bbaa&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The palindromic permutations of <code>s</code> (in lexicographical order) are <code>&quot;abba&quot;</code> and <code>&quot;baab&quot;</code>.</li>
	<li>None of them is lexicographically strictly greater than <code>target</code>. Therefore, the answer is <code>&quot;&quot;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abc&quot;, target = &quot;abb&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p><code>s</code> has no palindromic permutations. Therefore, the answer is <code>&quot;&quot;</code>.</p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aac&quot;, target = &quot;abb&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;aca&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The only palindromic permutation of <code>s</code> is <code>&quot;aca&quot;</code>.</li>
	<li><code>&quot;aca&quot;</code> is strictly greater than <code>target</code>. Therefore, the answer is <code>&quot;aca&quot;</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == s.length == target.length &lt;= 300</code></li>
	<li><code>s</code> and <code>target</code> consist of only lowercase English letters.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
Because a palindrome is entirely dictated by its first half (and an optional middle character), we can reduce the problem to finding the lexicographically smallest valid first half that makes the entire resulting palindrome strictly greater than the target. By greedily attempting to match the longest possible prefix of the target's first half and then incrementing the very next character, we guarantee finding the smallest valid permutation.

### Approach
- Count the character frequencies in `s` to verify if a palindrome is possible (it must have at most one character with an odd frequency). 
- Extract the pool of available characters for the first half of the palindrome by dividing each character's frequency by two.
- Iterate a prefix length `L` from half the string's length down to 0, representing how many characters of the target's first half we want to match exactly.
- If `L` equals the half-length, check if mirroring this exact first half (along with the middle character, if any) forms a palindrome that is already strictly greater than `target`. If so, return it.
- If `L` is less than the half-length, verify if we have enough characters to match the first `L` characters of `target`. Then, look for the smallest available character in our pool that is strictly greater than the target's `L`-th character.
- If such a character is found, append it, sort all remaining available characters in ascending order to ensure the lexicographically smallest result, construct the full palindrome, and return it.

### Complexity
- **Time:** O(n^2) — The outer loop runs O(n) times, and in the worst case, we spend O(n) time inside the loop verifying prefix character counts and comparing strings.
- **Space:** O(n) — We use auxiliary arrays of size 26 for character counting and string builders that store up to O(n) characters.
