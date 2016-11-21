1. Lagrange's four-square theorem
Time:  O(n^(1/2))
Space: O(1)
https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
https://zh.wikipedia.org/wiki/%E5%9B%9B%E5%B9%B3%E6%96%B9%E5%92%8C%E5%AE%9A%E7%90%86
https://www.alpertron.com.ar/4SQUARES.HTM

2. Dp
Time:  O(n^(3/2))
Space: O(n)
    令Q(i) 為所有小於 n 的平方數之集合, Q1 = 1, Q2 = 4, Q3 = 9 , ... 
    則d(n) = min (d(n-Q1), d(n-Q2), d(n-Q3), ....) 
    
3.Branch and bound - BFS瀏覽狀態空間樹 
Time:  O(n^(3/2)
Space: O(n)
https://discuss.leetcode.com/topic/26262/short-python-solution-using-bfs/2
