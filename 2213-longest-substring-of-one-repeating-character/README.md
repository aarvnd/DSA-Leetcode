<h2><a href="https://leetcode.com/problems/longest-substring-of-one-repeating-character">Longest Substring of One Repeating Character</a></h2> <img src='https://img.shields.io/badge/Difficulty-Hard-red' alt='Difficulty: Hard' /><hr><p>You are given a <strong>0-indexed</strong> string <code>s</code>. You are also given a <strong>0-indexed</strong> string <code>queryCharacters</code> of length <code>k</code> and a <strong>0-indexed</strong> array of integer <strong>indices</strong> <code>queryIndices</code> of length <code>k</code>, both of which are used to describe <code>k</code> queries.</p>

<p>The <code>i<sup>th</sup></code> query updates the character in <code>s</code> at index <code>queryIndices[i]</code> to the character <code>queryCharacters[i]</code>.</p>

<p>Return <em>an array</em> <code>lengths</code> <em>of length </em><code>k</code><em> where</em> <code>lengths[i]</code> <em>is the <strong>length</strong> of the <strong>longest substring</strong> of </em><code>s</code><em> consisting of <strong>only one repeating</strong> character <strong>after</strong> the</em> <code>i<sup>th</sup></code> <em>query</em><em> is performed.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;babacc&quot;, queryCharacters = &quot;bcb&quot;, queryIndices = [1,3,3]
<strong>Output:</strong> [3,3,4]
<strong>Explanation:</strong> 
- 1<sup>st</sup> query updates s = &quot;<u>b<strong>b</strong>b</u>acc&quot;. The longest substring consisting of one repeating character is &quot;bbb&quot; with length 3.
- 2<sup>nd</sup> query updates s = &quot;bbb<u><strong>c</strong>cc</u>&quot;. 
  The longest substring consisting of one repeating character can be &quot;bbb&quot; or &quot;ccc&quot; with length 3.
- 3<sup>rd</sup> query updates s = &quot;<u>bbb<strong>b</strong></u>cc&quot;. The longest substring consisting of one repeating character is &quot;bbbb&quot; with length 4.
Thus, we return [3,3,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abyzz&quot;, queryCharacters = &quot;aa&quot;, queryIndices = [2,1]
<strong>Output:</strong> [2,3]
<strong>Explanation:</strong>
- 1<sup>st</sup> query updates s = &quot;ab<strong>a</strong><u>zz</u>&quot;. The longest substring consisting of one repeating character is &quot;zz&quot; with length 2.
- 2<sup>nd</sup> query updates s = &quot;<u>a<strong>a</strong>a</u>zz&quot;. The longest substring consisting of one repeating character is &quot;aaa&quot; with length 3.
Thus, we return [2,3].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
	<li><code>k == queryCharacters.length == queryIndices.length</code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
	<li><code>queryCharacters</code> consists of lowercase English letters.</li>
	<li><code>0 &lt;= queryIndices[i] &lt; s.length</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
Since we need to perform point updates and efficiently query the global maximum length of a repeating character substring, a Segment Tree is the ideal data structure. By maintaining the longest repeating prefix, suffix, and overall maximum for each segment, we can easily merge adjacent segments in constant time and process updates in logarithmic time.

### Approach
- Build a segment tree where each node stores five properties for its substring: the character and length of its longest repeating prefix, the character and length of its longest repeating suffix, and the overall maximum length of any repeating character substring.
- Initialize the tree recursively, setting leaf nodes to represent individual characters with prefix, suffix, and max lengths of 1.
- Define a `merge` operation to combine two child nodes: the parent's maximum length is the maximum of the left child's max, the right child's max, or the sum of the left child's suffix and right child's prefix (if their characters match).
- Update the parent's prefix and suffix during the `merge` by checking if a child consists entirely of a single character that matches the adjacent child's prefix or suffix, extending the length accordingly.
- For each query, update the specific leaf node with the new character, recursively merge the changes up to the root, and append the root's maximum length to the results array.

### Complexity
- **Time:** O(N + K \log N) — Building the segment tree takes O(N) time, and each of the K updates takes O(\log N) time to traverse and merge.
- **Space:** O(N) — The segment tree requires five arrays of size 4N to store segment properties, taking linear space.
