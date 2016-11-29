# Problem-solving process
1. ask a lot of questions
* walking through examples  
**repeat until you fully understand**
* build a naive solution (no need to clever)
* Test it (meanwhile brief the solution to interviewer)
 * normal input
 * edge input
 * data structure
 * performance
 * trade-offs  
 ex: more memory to speedup
* iterate design & analysis to come up with candidate solution
* **implement it**

# Ref
* [演算法筆記](http://www.csie.ntnu.edu.tw/~u91029/index.html)
* [编程之法：面试和算法心得](https://www.gitbook.com/book/wizardforcel/the-art-of-programming-by-july/details)
* [資料結構與演算法/leetcode/lintcode題解](https://algorithm.yuanbin.me/zh-tw/index.html)

# Cheat Sheet
*!! keep this sheet as compact as possible !!*

[Big-O Cheat Sheet](http://bigocheatsheet.com/)

* Java
```Java
Arrays.sort(nums);
String.substring(startIdx, endIdx); String.toCharArray(); String.charAt(idx);
StringBuilder.setLength(newLength);
new Stack<Integer>();
/*Queue*/ new LinkedList<Integer>();
PriorityQueue<Integer> pq = new PriorityQueue<>(SIZE, new Comparator() {
    public int compare(int a, int b) {}
);
```

# Data Structure
* Array
 * 雙指針: Use while-loop instead of for-loop
```java
    while(i<=j) {
        // reverse, swap
        i++; j--;
        // 二分
        int mid = (i+j) >> 1;
        i = mid + 1; // or j = mid - 1;
    }
```
* LinkedList
 * DummyNode: 當算法會修改HEAD NODE 時，可以避免 if null 的判斷，簡化代碼  
 * 雙指針: 找中間(一快一慢)／找重覆
 * [Linked List的复习总结](http://www.jianshu.com/p/3d4be8cbf94b)
* [Heap](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html)
 * array implementation: index 0不使用，從1開始，這樣在算parent index時直接除以2就好(Np = N/2)
 * 每次add/removeMin時都要重新調整，add()->N/2; removeMin()->min( N\*2, N\*2 + 1)
 * HeapSort: 全部加入後，在一個一個取出來
* Priority Queue
 * [用 Heap 實作 Priority Queue](http://pages.cs.wisc.edu/~vernon/cs367/notes/11.PRIORITY-Q.html)
   * Time complexity for delete/insert：O(log n)
* [Tree](./Tree.md)
 * 進行複雜度分析時可統計對每個節點被訪問的次數，進而求得總的時間複雜度。
 * DFS
* [Graph](./Graph.md)
 * Edge List -> \(Adjacency Matrix, Adjacency Lists\)
 * traversal: BFS / DFS
 * Directed Acyclic Graph
   * Topological Sort
   * 找出所有合理的排列順序: BackTracing
   * 計算所有合理的排列順序個數: DP
 * Lowest Common Ancestor
 * Disjoint Sets / Union-find algorithm

# Algorithm
* [Sort](./Sort.md)
 * Find kth element: ex: median of two sorted arrays, find...
* [Dynamic Programming](./DP.md)
**The key to any DP problem is to come up with the state equation.**  
 * 狀態(狀態不太好找，可先從轉化方程入手分析)
 * 狀態間的轉化方程(從題目的隱含條件出發尋找遞推關係)
 * 初始化狀態的確定(由狀態和轉化方程得知)
 * 需要的結果(狀態轉移的終點)
* Greedy Method
 * 活動選擇問題: 把撞期的行程，表示成圖，稱作 Interval Graph
 * Min spanning tree problem
 * Fractional knapsack problem
* BackTracking: 暴力求解的方式，對元素有**取或不取**兩種分支，儘早判斷剪支
 * Enumerate Permutations / Combinations
 * 0/1 Knapsack Problem \(也可以用DP\)
* Permutation/Combinations [全排列和全组合实现](https://www.google.com.tw/url?sa=t&rct=j&q=&esrc=s&source=web&cd=10&cad=rja&uact=8&ved=0ahUKEwixsLTQrMnQAhXBn5QKHUP9BVUQFghZMAk&url=http%3A%2F%2Fwuchong.me%2Fblog%2F2014%2F07%2F28%2Fpermutation-and-combination-realize%2F&usg=AFQjCNHD5qvumuJXD_PIQnIxAc2BSZMcpA&sig2=QravRlHYgJHFvIyanedvxw)
 * 不重覆：
   * BackTracking
   * Heap's algorithm for Permutation
 * 重覆
* String
 * KMP

# Bitwise
* 2補數：0就只有一個表示方式，一個數字的二補數就是將該數字作位元反相運算，再將結果加1
* INT 操作要處理 overflow / underflow，偷懶就用 long 來處理
* XOR - 可以用來做 swap
```
X := X XOR Y;
Y := Y XOR X;
X := X XOR Y
```
