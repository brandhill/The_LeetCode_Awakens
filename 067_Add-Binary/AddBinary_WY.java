public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i>=0 || j >=0) {
            int va = (i >= 0) ? (a.charAt(i) - '0') : 0;
            int vb = (j >= 0) ? (b.charAt(j) - '0') : 0;
            int sum = va + vb + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;
        }
        
        if(carry > 0){
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
