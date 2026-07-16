<h2><a href="https://leetcode.com/problems/longest-common-prefix">Longest Common Prefix</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>Write a function to find the longest common prefix string amongst an array of strings.</p>

<p>If there is no common prefix, return an empty string <code>&quot;&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;flower&quot;,&quot;flow&quot;,&quot;flight&quot;]
<strong>Output:</strong> &quot;fl&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> strs = [&quot;dog&quot;,&quot;racecar&quot;,&quot;car&quot;]
<strong>Output:</strong> &quot;&quot;
<strong>Explanation:</strong> There is no common prefix among the input strings.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
	<li><code>strs[i]</code> consists of only lowercase English letters if it is non-empty.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The longest common prefix of a collection of strings must be a prefix of the first string. By assuming the entire first string is the common prefix and iteratively shortening it from the end whenever it fails to match the beginning of the next string, we can efficiently narrow down the shared prefix.

### Approach
- Check for edge cases: if the input array is null or empty, immediately return an empty string.
- Initialize the `prefix` variable using the first string in the array.
- Iterate through the remaining strings in the array starting from the second element.
- For each string, use a `while` loop to check if the current string starts with the `prefix` (i.e., `indexOf(prefix) != 0`).
- If it does not start with the `prefix`, chop off the last character of the `prefix` using `substring`.
- If the `prefix` becomes empty during this truncation, there is no common prefix at all, so return an empty string immediately.
- Once all strings have been checked, return the surviving `prefix`.

### Complexity
- **Time:** O(S) — where S is the sum of all characters in all strings, as we compare the prefix against each string and shorten it at most by the length of the first string.
- **Space:** O(1) — we only use constant extra space to maintain the prefix variable (ignoring the temporary space used by Java to create substrings).
