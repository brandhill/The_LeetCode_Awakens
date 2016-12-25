# Tree
## 树的遍历
Key Concepts
> Binary Tree遍历问题有一个关键点就是当指针走到底层以后如何返回的问题
實作上可以用選擇 recursive / iterative+stack

[Sample Code](../Basic/TreeTraversal.java)

### preorder
* recursive
* iterative
需要stack, 另外可以利用更新root本身来实现遍历O(lgN)的额外空间
* Morris
不需要额外空间

### inorder : in-order BST can get a list of values in ascending order
* recursive
* iterative + stack (loop to left)
* Morris
實作與preordr一樣，輸出順序不同

### postorder
* recursive
* iterative: like preorder (VLR, LRV), use another stack to save preorder traversal result
* Morris
實作很不一樣


### level order traversal
用 iterative 的方式，不過使用queue来代替stack的作用
