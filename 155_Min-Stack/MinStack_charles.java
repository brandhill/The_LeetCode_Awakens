public class MinStack {
    private List<Integer> mStack = null;
    private Integer mCurrentMin = null;

    /** initialize your data structure here. */
    public MinStack() {
        mStack = new ArrayList<Integer>();
    }

    public void push(int x) {
        mStack.add(x);
        updateMin(false);
    }

    public void pop() {
        mStack.remove(mStack.size() - 1);
        updateMin(true);
    }

    public int top() {
        return mStack.get(mStack.size() - 1);
    }

    public int getMin() {
        if (mCurrentMin == null) throw new IllegalStateException("no elements has been pushed!");
        return mCurrentMin;
    }

    private void updateMin(boolean wipeMin) {
        if (mStack.size() == 0) {
            mCurrentMin = null;
            return;
        }

        if (wipeMin) mCurrentMin = null;

        for (int i : mStack) {
            if (mCurrentMin == null || i < mCurrentMin.intValue()) {
                mCurrentMin = new Integer(i);
            }
        }
    }
}
