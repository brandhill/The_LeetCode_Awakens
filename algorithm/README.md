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

# Cheat Sheet
*!! keep this sheet as compact as possible !!*

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
* [Tree](./Tree.md)
 * 進行複雜度分析時可統計對每個節點被訪問的次數，進而求得總的時間複雜度。
 * DFS
* Priority Queue
 * [用 Heap 實作 Priority Queue](http://pages.cs.wisc.edu/~vernon/cs367/notes/11.PRIORITY-Q.html)
   * Time complexity for delete/insert：O(log n)
* Graph
# Algorithm
* bitwise
 * INT 操作要處理 overflow / underflow，偷懶就用 long 來處理
 * XOR - 可以用來做 swap，X := X XOR Y; Y := Y XOR X; X := X XOR Y
* [Sort](./Sort.md)
 * Find kth element: ex: median of two sorted arrays, find...
* [Dynamic Programming](./DP.md)
**The key to any DP problem is to come up with the state equation.**  
 * 狀態(狀態不太好找，可先從轉化方程入手分析)
 * 狀態間的轉化方程(從題目的隱含條件出發尋找遞推關係)
 * 初始化狀態的確定(由狀態和轉化方程得知)
 * 需要的結果(狀態轉移的終點)
