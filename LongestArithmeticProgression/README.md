[Sol 1](https://algnotes.wordpress.com/2013/06/01/finding-longest-arithmetic-progressions/)

對任一arithmetic progress subsequence而言，如果此子序列的前兩個元素為A[i]和A[j]，那接下來的元素必為A[j] + A[j] – A[i] = 2A[j] – A[i]。因此，我們可以嘗試所有可能的開始兩個元素，然後搜尋找出最長的arithmetic progression subsequence。因為起始兩元素有 O(n^2)組，而且每一組需要花O(n)搜尋，時間複雜度為O(n^3).

集合版本的問題可以有O(n^2)的解法，首先把S排序放入陣列A中。令L(i, j)為A[i]和A[j]開頭的最長arithmetic progression subsequence。我們可得到遞迴關係如下：

L(i, j) = L(j, k) + 1, **if k > i and A[i] + A[k] = 2A[j]**  
L(i, j) = 2, otherwise

