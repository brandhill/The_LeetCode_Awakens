使用in-order traversal便可以處理.

Average Time: O(1)
Space: O(h)

另外[morris traversal](http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html)可以做到
Space: O(1)
> Morris方法有一个地方特别的是如果左子节点不为空的情况下，寻找它的前驱节点然后link起来，这样就可以让下层的节点和上层节点联系起来，等到第二次遍历的时候再让这种联系断开通过prev->right = nullptr;

# 檢討：
* [WY] 不知道 average time: O(1) 的意思
