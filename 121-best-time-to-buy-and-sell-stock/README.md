<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">Best Time to Buy and Sell Stock</a></h2> <img src='https://img.shields.io/badge/Difficulty-Easy-brightgreen' alt='Difficulty: Easy' /><hr><p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>


<hr>

## Solution Explanation

### Intuition
The key insight is that to maximize profit, you always want to buy at the lowest possible price seen before the current selling day. By keeping a running record of the minimum price encountered so far as we iterate through the array, we can calculate the maximum potential profit for each day and simply remember the highest profit we find.

### Approach
- Check for null or empty input, returning 0 if the array contains no prices.
- Initialize a variable `minPrice` to the first day's price and `maxProfit` to 0.
- Iterate through the array starting from the second day.
- If the current day's price is lower than `minPrice`, update `minPrice` to this new lowest value.
- Otherwise, calculate the profit if you sold today (current price minus `minPrice`) and update `maxProfit` if it exceeds the current known maximum.
- Return `maxProfit` after evaluating all days.

### Complexity
- **Time:** O(N) — We iterate through the prices array exactly once, performing constant-time operations at each step.
- **Space:** O(1) — We only use a few integer variables to maintain state, requiring no extra memory that scales with the input size.
