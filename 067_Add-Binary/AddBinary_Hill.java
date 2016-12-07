public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static String addHex(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += hexToInt(b.charAt(j--));
            if (i >= 0) sum += hexToInt(a.charAt(i--));
            sb.append(Integer.toHexString(sum % 16));
            carry = sum / 16;
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    private static int hexToInt(char c) {

        if (c >= '0' && c <= '9') {
            return c - '0';
        } else {
            return c - 'a' + 10;
        }
    }

    public static int convert(int n) {
        return Integer.valueOf(String.valueOf(n), 16);
    }

    public static void main(String[] args) {
        System.out.println(convert(20));  // 32
        System.out.println(convert(54));  // 84
    }
}
