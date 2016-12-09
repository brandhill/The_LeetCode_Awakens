public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
            
        String sum = "0";
        for(int i=num2.length()-1; i>=0; i--) {
            int count = num2.charAt(i) - '0';
            while(count > 0) {
                sum = addStrings(sum, num1);
                count--;
            }
            num1 = num1 + "0";
        }
        
        return sum;
    }
    
    public String addStrings(String num1, String num2) {
        int i = num1.length() -1;
        int j = num2.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >=0 || j >= 0) {
            int v1 = (i >=0 ) ? num1.charAt(i--) - '0' : 0;
            int v2 = (j >=0 ) ? num2.charAt(j--) - '0' : 0;
            int sum = carry + v1 + v2;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
