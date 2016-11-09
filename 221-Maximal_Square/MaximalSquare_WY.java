/**
Let me make sure that I understand the question correctly.

for a 2x2 matrix with all the zeros, the function should return 0, is that correct?
0 0
0 0 == 0

0 0
0 1 == 1

1 1
1 1 == 4

0 0
1 1
1 1 == 4

will there be an empty matrix?

what kind of data structure is used to represet the matrix?
Array
Row-major or column major

iterator through all the elements in the matrix.
if we encounter an element which value is 1, then we use that element as a anchor point and perform the check

we increase the length of the squre and check if all elements are 1
we only need to check the elements in new row and column.


Time : O(N^2)
Space: O(1)
 */
public class Solution {
  public int maximalSquare(char[][] matrix) {
    int rowLength = matrix.length;
    if(rowLength == 0)
        return 0;
    int columnLength = matrix[0].length;
    int maxArea = 0;
    for(int r=0; r<rowLength; r++) {
      for(int c=0; c<columnLength; c++) {
        int area = findSquare(matrix, r, c);
        if(area > maxArea) maxArea = area;
      }
    }
    
    return maxArea;
  }
  
  public int findSquare(char[][] matrix, int rowIdx, int colIdx) {
    int columnLength = matrix[0].length;
    int rowLength = matrix.length;
    
    boolean done = false;
    int length = 1;
    while(!done) {
        if(rowIdx + length > rowLength || colIdx + length > columnLength) {
            length--;
            done = true;
            break;
        }
        for(int i=0;i<length;i++) {
            if(matrix[rowIdx+length-1][colIdx+i] != '1' || 
               matrix[rowIdx+i][colIdx+length-1] != '1') {
                   length--;
                   done = true;
                   break;
            }
        }
        if(!done)
            length++;
    }
    
    return length * length;
  }
}
