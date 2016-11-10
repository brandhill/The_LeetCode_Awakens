/**
 * Author: Derek Lai
 * Questions:
 * 1. x > 0 ?
 * 2. 
 */
public class Solution {
  public int mySqrt(int x) {
	if (x < 0) return 0;
	if (1 == x) return 1;
	long start = 1, end = x;
	long mid;
	while (start+1 < end) {
	  mid = start + (end - start) / 2;
	  if (mid * mid <= x) {
		start = mid;
	  } else {
		end = mid;
	  }
	}

	if (end * end <= x) {
	  return (int) end;
	} else {
	  return (int) start;
	}

  }
}
