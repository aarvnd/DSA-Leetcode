<h2><a href="https://leetcode.com/problems/smallest-palindromic-rearrangement-i">Smallest Palindromic Rearrangement I</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given a <strong><span data-keyword="palindrome-string">palindromic</span></strong> string <code>s</code>.</p>

<p>Return the <strong><span data-keyword="lexicographically-smaller-string">lexicographically smallest</span></strong> palindromic <span data-keyword="permutation-string">permutation</span> of <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;z&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;z&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>A string of only one character is already the lexicographically smallest palindrome.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;babab&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;abbba&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Rearranging <code>&quot;babab&quot;</code> &rarr; <code>&quot;abbba&quot;</code> gives the smallest lexicographic palindrome.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;daccad&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;acddca&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Rearranging <code>&quot;daccad&quot;</code> &rarr; <code>&quot;acddca&quot;</code> gives the smallest lexicographic palindrome.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
	<li><code>s</code> is guaranteed to be palindromic.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
To form the lexicographically smallest palindrome, we must place the smallest available characters as close to the beginning of the string as possible. Since the input string is guaranteed to be a valid palindrome, we can simply count character frequencies, build the first half in alphabetical order, place any odd-count character in the exact middle, and mirror the first half to complete the string.

### Approach
- Count the frequency of each character in the input string using an integer array of size 26.
- Iterate through the alphabet from 'a' to 'z' to ensure characters are processed in strict lexicographical order.
- For each character, append exactly half of its total frequency to a `firstHalf` string builder.
- If a character has an odd frequency, store it as the `middle` character (a valid palindrome has at most one such character).
- Create the second half of the palindrome by making a reversed copy of the `firstHalf` string.
- Concatenate the first half, the middle character (if one exists), and the second half to form and return the final result.

### Complexity
- **Time:** O(N) — where N is the length of the string, as we traverse the string once to count characters and then perform operations proportional to N to build the result.
- **Space:** O(N) — to store the string builders used to construct the first half, second half, and the final output string.
