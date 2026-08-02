<h2><a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number">Letter Combinations of a Phone Number</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a string containing digits from <code>2-9</code> inclusive, return all possible letter combinations that the number could represent. Return the answer in <strong>any order</strong>.</p>

<p>A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.</p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png" style="width: 300px; height: 243px;" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> digits = &quot;23&quot;
<strong>Output:</strong> [&quot;ad&quot;,&quot;ae&quot;,&quot;af&quot;,&quot;bd&quot;,&quot;be&quot;,&quot;bf&quot;,&quot;cd&quot;,&quot;ce&quot;,&quot;cf&quot;]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> digits = &quot;2&quot;
<strong>Output:</strong> [&quot;a&quot;,&quot;b&quot;,&quot;c&quot;]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= digits.length &lt;= 4</code></li>
	<li><code>digits[i]</code> is a digit in the range <code>[&#39;2&#39;, &#39;9&#39;]</code>.</li>
</ul>


<hr>

## Solution Explanation

### Intuition
The problem asks for all possible combinations of letters from a sequence of digits, which naturally forms a decision tree. The key insight is to use backtracking to traverse this tree depth-first, incrementally building each string character by character and undoing choices to explore every valid path.

### Approach
- Define a static array to map each digit (from 0 to 9) to its corresponding telephone letters.
- Handle the edge case of an empty input string by immediately returning an empty list.
- Initiate a recursive backtracking function starting at index 0, using a `StringBuilder` to maintain the current combination of letters.
- In the recursive function, check the base case: if the current index equals the length of the input digits, a complete combination has been formed, so add it to the result list and return.
- If not at the base case, fetch the letters mapped to the current digit and iterate through them.
- For each letter, append it to the `StringBuilder`, recursively call the function for the next digit index, and then delete the character (backtrack) to explore the next possible letter.

### Complexity
- **Time:** O(4^n * n) — where n is the length of the input string; there are up to 4^n combinations (since digits 7 and 9 map to 4 letters), and converting the `StringBuilder` to a string takes O(n) time.
- **Space:** O(n) — the maximum depth of the recursion call stack and the size of the `StringBuilder` are both proportional to the length of the input string (excluding the space required for the output list).
