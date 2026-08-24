<h2><a href="https://leetcode.com/problems/combination-sum-ii">Combination Sum II</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given a collection of candidate numbers (<code>candidates</code>) and a target number (<code>target</code>), find all unique combinations in <code>candidates</code>&nbsp;where the candidate numbers sum to <code>target</code>.</p>

<p>Each number in <code>candidates</code>&nbsp;may only be used <strong>once</strong> in the combination.</p>

<p><strong>Note:</strong>&nbsp;The solution set must not contain duplicate combinations.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> candidates = [10,1,2,7,6,1,5], target = 8
<strong>Output:</strong> 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> candidates = [2,5,2,1,2], target = 5
<strong>Output:</strong> 
[
[1,2,2],
[5]
]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;candidates.length &lt;= 100</code></li>
	<li><code>1 &lt;=&nbsp;candidates[i] &lt;= 50</code></li>
	<li><code>1 &lt;= target &lt;= 30</code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
To find all valid combinations without generating duplicates, we can use backtracking on a sorted array, which allows us to easily skip identical elements at the same recursive depth and terminate search paths early when a number exceeds the remaining target.

### Approach
- Sort the `candidates` array to group duplicate numbers together and enable early termination during the search.
- Use a recursive backtracking function that tracks the current index, the remaining target, and the current combination of numbers.
- If the remaining target reaches exactly zero, add a copy of the current combination to the result list.
- Iterate through the candidates starting from the current index. If the current candidate is greater than the remaining target, break the loop immediately since all subsequent numbers will also be too large.
- Skip duplicate numbers at the same depth of the recursion tree by checking if `candidates[i] == candidates[i - 1]` (and ensuring `i > start`).
- Add the candidate to the current combination, recurse with the next index (`i + 1`) and the reduced target, then remove the candidate to backtrack and explore other possibilities.

### Complexity
- **Time:** O(2^n) — in the worst case we explore all subsets, though sorting and early pruning significantly reduce the actual execution time.
- **Space:** O(n) — for the recursion stack and the temporary list used to build current combinations, where n is the length of the candidates array.
