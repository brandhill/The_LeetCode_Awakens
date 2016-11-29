

 * M[i][j] represents that if first i character from s and first j character from p could match
 * base case: M[0][0] = true;
 * Induction rule:
  * case 1: p[j - 1] == '?' then M[i][j] = M[i - 1][j - 1]
  * case 2: P[j - 1] == S[i - 1] then M[i][j] = M[i - 1][j - 1]
  * case 3: P[j - 1] = '*' then M[i][j] = M[i][j - 1](this means '*' serve as empty) || M[i - 1][j]
  * other case: false, so we just ignore them
 
