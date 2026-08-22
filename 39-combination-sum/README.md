<h2><a href="https://leetcode.com/problems/combination-sum">Combination Sum</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given an array of <strong>distinct</strong> integers <code>candidates</code> and a target integer <code>target</code>, return <em>a list of all <strong>unique combinations</strong> of </em><code>candidates</code><em> where the chosen numbers sum to </em><code>target</code><em>.</em> You may return the combinations in <strong>any order</strong>.</p>

<p>The <strong>same</strong> number may be chosen from <code>candidates</code> an <strong>unlimited number of times</strong>. Two combinations are unique if the <span data-keyword="frequency-array">frequency</span> of at least one of the chosen numbers is different.</p>

<p>The test cases are generated such that the number of unique combinations that sum up to <code>target</code> is less than <code>150</code> combinations for the given input.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2,3,6,7], target = 7
<strong>Output:</strong> [[2,2,3],[7]]
<strong>Explanation:</strong>
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2,3,5], target = 8
<strong>Output:</strong> [[2,2,2,2],[2,3,3],[3,5]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2], target = 1
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= candidates.length &lt;= 30</code></li>
	<li><code>2 &lt;= candidates[i] &lt;= 40</code></li>
	<li>All elements of <code>candidates</code> are <strong>distinct</strong>.</li>
	<li><code>1 &lt;= target &lt;= 40</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
We need to explore all possible combinations of numbers that sum to the target, making this a classic backtracking problem. By sorting the candidates first, we can optimize the search by stopping early whenever a number exceeds the remaining target. Furthermore, by passing a starting index to our recursive function, we enforce an order of selection that naturally prevents duplicate combinations (like picking 2 then 3, and later 3 then 2).

### Approach
- Sort the `candidates` array in ascending order to enable early termination (pruning) during the search.
- Initialize a recursive `backtrack` function that tracks the remaining `target`, the `start` index to prevent backward selection, and the `current` list of chosen numbers.
- Check the base case: if the remaining `target` is exactly `0`, make a copy of the `current` list and add it to the results.
- Iterate through the candidates starting from the `start` index. If the current candidate is greater than the remaining `target`, break out of the loop immediately since all subsequent numbers will also be too large.
- Add the candidate to the `current` list and recursively call the function with the reduced target, passing the current index `i` (not `i + 1`) to allow the same number to be chosen an unlimited number of times.
- After the recursive call returns, remove the last added number from the `current` list to backtrack and explore other candidate branches.

### Complexity
- **Time:** O(N^(T/M)) where N is the number of candidates, T is the target, and M is the minimum value in candidates — representing the maximum number of nodes in the n-ary backtracking tree.
- **Space:** O(T/M) — representing the maximum depth of the recursion stack, which occurs when we repeatedly choose the smallest element to reach the target.
