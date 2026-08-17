<h2><a href="https://leetcode.com/problems/valid-palindrome">Valid Palindrome</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>A phrase is a <strong>palindrome</strong> if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.</p>

<p>Given a string <code>s</code>, return <code>true</code><em> if it is a <strong>palindrome</strong>, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;A man, a plan, a canal: Panama&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> &quot;amanaplanacanalpanama&quot; is a palindrome.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;race a car&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> &quot;raceacar&quot; is not a palindrome.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot; &quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> s is an empty string &quot;&quot; after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of printable ASCII characters.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
Instead of creating a new filtered string which would require extra memory, we can use a two-pointer approach to evaluate the string in place. By placing one pointer at the beginning and another at the end, we can move them inward, skipping any non-alphanumeric characters, and comparing the valid characters on the fly to verify if the string reads the same forwards and backwards.

### Approach
- Initialize two pointers: `left` at the start of the string (index 0) and `right` at the end of the string (index `s.length() - 1`).
- Loop as long as the `left` pointer is strictly less than the `right` pointer.
- Inside the loop, increment the `left` pointer until it lands on an alphanumeric character (or meets the `right` pointer).
- Decrement the `right` pointer until it also lands on an alphanumeric character.
- Convert the characters at both pointers to lowercase and compare them; if they do not match, return `false`.
- If they match, move both pointers inward (`left++` and `right--`) and continue the process, returning `true` if the loop finishes without finding any mismatches.

### Complexity
- **Time:** O(n) — where n is the length of the string, because each character is visited at most once by the pointers.
- **Space:** O(1) — because the algorithm only uses two integer pointers, requiring constant extra memory regardless of the input size.
