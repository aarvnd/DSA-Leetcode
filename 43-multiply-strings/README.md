<h2><a href="https://leetcode.com/problems/multiply-strings">Multiply Strings</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given two non-negative integers <code>num1</code> and <code>num2</code> represented as strings, return the product of <code>num1</code> and <code>num2</code>, also represented as a string.</p>

<p><strong>Note:</strong>&nbsp;You must not use any built-in BigInteger library or convert the inputs to integer directly.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> num1 = "2", num2 = "3"
<strong>Output:</strong> "6"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> num1 = "123", num2 = "456"
<strong>Output:</strong> "56088"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num1.length, num2.length &lt;= 200</code></li>
	<li><code>num1</code> and <code>num2</code> consist of digits only.</li>
	<li>Both <code>num1</code> and <code>num2</code>&nbsp;do not contain any leading zero, except the number <code>0</code> itself.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem can be solved by simulating the standard grade-school multiplication algorithm. The key insight is mapping the string indices to the result array: when multiplying a digit at index `i` of the first string by a digit at index `j` of the second string, their product directly affects indices `i + j` (for the carry) and `i + j + 1` (for the current digit) in the final result.

### Approach
- Create an integer array of size `m + n` to store the digits of the product, since the maximum possible length of the multiplied result is the sum of the lengths of the two input strings.
- Iterate backwards through both strings, multiplying each digit of `num1` at index `i` with each digit of `num2` at index `j`.
- Add this product to the existing value at position `i + j + 1` to properly accumulate sums and previous carries.
- Store the single-digit remainder (`sum % 10`) at `i + j + 1` and add the new carry (`sum / 10`) to the preceding position `i + j`.
- Traverse the computed array to build the final string while skipping any leading zeros, returning "0" if the resulting string is completely empty.

### Complexity
- **Time:** O(m * n) — where m and n are the lengths of the two strings, as we use nested loops to multiply every digit of `num1` by every digit of `num2`.
- **Space:** O(m + n) — to store the intermediate positional sums in an array and to build the final output string.
