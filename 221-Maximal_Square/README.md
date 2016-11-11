** The key to any DP problem is to come up with the state equation. **

In this problem, we define the state to be the maximal size of the square that can be achieved at point (i, j)

we have the following state equations.
* P[0][j] = matrix[0][j] (topmost row); **boundary conditions**
* P[i][0] = matrix[i][0] (leftmost column); **boundary conditions**
* For i > 0 and j > 0:
 * if matrix[i][j] = 0, P[i][j] = 0;
 * if matrix[i][j] = 1, P[i][j] = min(P[i - 1][j], P[i][j - 1], P[i - 1][j - 1]) + 1.

**boundary conditions** can be solved by using auxiliary array (one extra row and column)

![sol](https://raw.githubusercontent.com/hot13399/leetcode-graphic-answer/master/221.%20Maximal%20Square.jpg)
