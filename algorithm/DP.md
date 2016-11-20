動態規劃(Dynamic Programming)是指將一個較大的問題定義為較小的子問題組合，先處理較小的問題並將結果儲存起來(通常使用表格)，再進一步以較小問題的解逐步建構出較大問題的解。

> 與其他演算法設計哲學比較
> * Divide-and-Conquer：Divide-and-Conquer 和 Dynamic Programming都是將問題切割再採用遞迴方式處理子問題，但是Divide-and-Conquer子問題的解通常不會重覆，重複時，通常會對相同子問題進行重覆計算，而不會像Dynamic Programming的子問題有大量的重複(overlap)，可以以table儲存不用再次計算，用空間換取時間。
> * Greedy Approach：Greedy Approach具有Selection Procedure，自某起始點開始在每一個階段逐一檢查每一個輸入是否適合加入答案中。如果所要處理的最佳化問題無法找到一個選擇程序來逐一檢查，而需要以一次考慮所有的可能情況的方式來處理，那就是屬於Dynamic Programming。因此若遇最佳化問題，先思考可否用Greedy Approach解，若不行再考慮Dynamic Programming。

Links
* [Algorithm - Ch2 動態規劃 Dynamic Programming](http://mropengate.blogspot.tw/2015/01/algorithm-ch2-dynamic-programming.html)

[(1) 实战动态规划（直播coding）（33:45）](https://www.julyedu.com/video/play/27/19)
[动态规划：从新手到专家](http://www.hawstein.com/posts/dp-novice-to-advanced.html)
[什麼是動態規劃？動態規劃的意義是什麼？ - 知乎](https://www.zhihu.com/question/23995189)
