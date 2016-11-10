All the following methods only take space complexity with O(1)
Method 1: Binary search 
    time complexity O(ln(n)), where n <= 2^M, M is the numbers of bit of int.
    So you can say the complexity is O(1) in this sense.
    Slowest method

    
Method 2: Greedy Algorithm to get result bit by bit
    time complexity O(ln(n)), where n <= 2^M,
    M is the numbers of bit of int. So you can say the complexity is O(1) in this sense.
    
    The time cost is relative to the bit number of input, not the value of input
    This method has best average time complexity if the input distribution is not left skew too much
    (In my compute, it is worse than binary sqrt if n <= 2^12, but not much.It may be worse between 2^12 ~ 2^22
    depending on the bit number of input, better between 2^22 ~ 2^31-1).

Method 3: Newton's method
    time complexity: depends on the initial value x0
    If we have x0 approximates sqrt(x) to k significant bits, then
    time complexity O(ln(ln(n))), where n <= 2^M, M is the numbers of bit of int.

    However, if we don't know how to find a good x0, its' performance is only better than binary search by some coeficient.

    Standard method to this problem in numeric analysis

Method 4: Enhanced x0 for Newtoan's method
    Use binary search to get first sig. bit, then applied Newton's method
    time complexity O(ln(ln(n)))
