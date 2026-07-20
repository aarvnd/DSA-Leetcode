<h2><a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string">Find the Index of the First Occurrence in a String</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Given two strings <code>needle</code> and <code>haystack</code>, return the index of the first occurrence of <code>needle</code> in <code>haystack</code>, or <code>-1</code> if <code>needle</code> is not part of <code>haystack</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> haystack = &quot;sadbutsad&quot;, needle = &quot;sad&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> &quot;sad&quot; occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> haystack = &quot;leetcode&quot;, needle = &quot;leeto&quot;
<strong>Output:</strong> -1
<strong>Explanation:</strong> &quot;leeto&quot; did not occur in &quot;leetcode&quot;, so we return -1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= haystack.length, needle.length &lt;= 10<sup>4</sup></code></li>
	<li><code>haystack</code> and <code>needle</code> consist of only lowercase English characters.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The core requirement of this problem perfectly matches the functionality of standard string search methods available in modern programming languages. Rather than manually implementing a pattern-matching algorithm like the naive sliding window or Knuth-Morris-Pratt (KMP), we can rely on Java's highly optimized, built-in string methods to handle the search efficiently and concisely.

### Approach
* Invoke the built-in `indexOf` method on the `haystack` string.
* Pass the `needle` string as the argument to search for its first occurrence.
* The method internally scans the characters of the `haystack` to locate the exact sequence of the `needle`.
* Directly return the result, which automatically yields the correct starting index or `-1` if no match exists.

### Complexity
- **Time:** O(N * M) — where N is the length of the haystack and M is the length of the needle, representing the worst-case scenario for standard library string matching, though it performs much faster in practice.
- **Space:** O(1) — the search is performed in-place without requiring any additional memory scaling with input size.
