
## Comparison-based O(nlogn)
* QuickSort
 * pivot 在每一輪partition後，都會到正確位置
* MergeSort  
 * use extra array to merge
 * space complexity: **Array: O(N)** / **LinkedList: O(1)**
 * [in-place](http://penguin.ewu.edu/cscd300/Topic/AdvSorting/MergeSorts/InPlace.html): move data around in the given array

## Non-comparison, O(n+k)
trade space with performance
* countingSort
* BucketSort
* RadixSort
