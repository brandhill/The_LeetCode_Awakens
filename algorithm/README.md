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

* bitwise
 * INT 操作要處理 overflow / underflow，偷懶就用 long 來處理
 * XOR - 可以用來做 swap，X := X XOR Y; Y := Y XOR X; X := X XOR Y
* LinkedList
 * DummyNode 可以避免 if null 的判斷，簡化代碼  
 * 雙指針／快慢指針  
 * [Linked List的复习总结](http://www.jianshu.com/p/3d4be8cbf94b)
* [Sort](./Sort.md)
 * Arrays.sort(nums);
* [Tree](./Tree.md)
 * DFS
* [Dynamic Programming](./DP.md)
**The key to any DP problem is to come up with the state equation.**  
