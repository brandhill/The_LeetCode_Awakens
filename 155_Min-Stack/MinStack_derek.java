/**
 * Author: Derek Lai
 * Question1: when mData is null, what's value should be return if execute top(), pop(), getMin() ?
 * Question2: throw exception ?
 * Time: O(n)
 * Space:O(n)
 */
public class MinStack {
  List<Integer> mData;
  private int mMin = Integer.MIN_VALUE;
  /** initialize your data structure here. */
  public MinStack() {
	mData = new ArrayList<Integer>();
  }

  public void push(int x) {
	if (Integer.MIN_VALUE == mMin
		|| x < mMin) {
	  mMin = x;
	}
	mData.add(Integer.valueOf(x));
  }

  private void findMinElement() {
	final int size = mData.size();
	if (size > 0) {
	  mMin = mData.get(size-1);
	  for (int element: mData) {
		if (Integer.MIN_VALUE == mMin
			|| element < mMin) {
		  mMin = element;
		}
	  }
	} else {
	  mMin = Integer.MIN_VALUE;
	}
  }

  public void pop() {
	final int size = mData.size();
	if (size > 0) {
	  int element = mData.remove(size-1);
	  if (element == mMin) {
		//Find min value, since that is old one is pop out
		findMinElement();
	  }
	}
	// throw new IllegalException("Failed to pop(), since there is no element in stack!");
  }

  public int top() {
	final int size = mData.size();
	if (size > 0) {
	  return mData.get(size-1);
	}
	// throw new IllegalException("Failed to top(), since there is no element in stack!");
	return -1;
  }

  public int getMin() {
	final int size = mData.size();
	if (size > 0) {
	  return mMin;
	}
	return -1;
	// throw new IllegalException("Failed to getMin(), since there is no element in stack!");
  }
}
