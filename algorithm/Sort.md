
## Comparison-based O(nlogn)
* QuickSort
 * pivot 在每一輪partition後，都會到正確位置
 * 而partition过程有以下两种实现：+
   * 一头一尾两个指针往中间扫描，如果头指针遇到的数比主元大且尾指针遇到的数比主元小，则交换头尾指针所分别指向的数字；
   * 一前一后两个指针同时从左往右扫，如果前指针遇到的数比主元小，则后指针右移一位，然后交换各自所指向的数字。
* MergeSort  
 * use extra array to merge
 * space complexity: **Array: O(N)** / **LinkedList: O(1)**
 * [in-place](http://penguin.ewu.edu/cscd300/Topic/AdvSorting/MergeSorts/InPlace.html): move data around in the given array

## Non-comparison, O(n+k)
trade space with performance
* countingSort
* BucketSort
* RadixSort
