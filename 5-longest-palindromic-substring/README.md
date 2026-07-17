<h2><a href="https://leetcode.com/problems/longest-palindromic-substring">Longest Palindromic Substring</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a string <code>s</code>, return <em>the longest</em> <span data-keyword="palindromic-string"><em>palindromic</em></span> <span data-keyword="substring-nonempty"><em>substring</em></span> in <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;babad&quot;
<strong>Output:</strong> &quot;bab&quot;
<strong>Explanation:</strong> &quot;aba&quot; is also a valid answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbbd&quot;
<strong>Output:</strong> &quot;bb&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consist of only digits and English letters.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
A palindrome mirrors around its center, meaning we can efficiently find palindromes by picking a center point and expanding outwards. Instead of checking every possible substring to see if it is valid, we can iterate through every possible center in the string—both single characters for odd-length palindromes and adjacent character pairs for even-length palindromes—and expand outwards as long as the characters match.

### Approach
* Convert the string to a character array for efficient index access and initialize `start` and `end` variables to track the boundaries of the longest palindrome found so far.
* Iterate through each index `i` in the array, treating it as the center of a potential palindrome.
* For each center `i`, calculate the length of the longest palindrome by expanding outwards in two ways: centered exactly on `i` (for odd-length palindromes) and centered between `i` and `i + 1` (for even-length palindromes).
* Use a helper function to expand the window by decrementing a left pointer and incrementing a right pointer as long as they stay within bounds and the characters match, returning the total length of the valid palindrome.
* Compare the maximum length found at the current center to the length of the previously recorded maximum (`end - start`); if it is longer, mathematically update the `start` and `end` indices to reflect the new boundaries.
* After checking all possible centers, extract and return the substring from the original string using the final `start` and `end` indices.

### Complexity
- **Time:** O(n^2) — We iterate through 2n - 1 potential centers, and expanding around each center takes up to O(n) time in the worst case.
- **Space:** O(n) — Converting the string to a character array requires O(n) auxiliary space.
