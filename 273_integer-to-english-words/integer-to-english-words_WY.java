public class Solution {
    static HashMap<Integer, String> words = new HashMap<>();
    static {
        words.put(0, "Zero"); words.put(1, "One"); words.put(2, "Two"); words.put(3, "Three");
        words.put(4, "Four"); words.put(5, "Five"); words.put(6, "Six"); words.put(7, "Seven");
        words.put(8, "Eight"); words.put(9, "Nine"); words.put(10, "Ten"); words.put(11, "Eleven");
        words.put(12, "Twelve"); words.put(13, "Thirteen"); words.put(14, "Fourteen"); words.put(15, "Fifteen");
        words.put(16, "Sixteen"); words.put(17, "Seventeen"); words.put(18, "Eighteen"); words.put(19, "Nineteen");
        words.put(20, "Twenty"); words.put(30, "Thirty"); words.put(40, "Forty"); words.put(50, "Fifty");
        words.put(60, "Sixty"); words.put(70, "Seventy"); words.put(80, "Eighty"); words.put(90, "Ninety");
    }
    
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        
        String ret = "";
        String[] s = {"", "Thousand", "Million", "Billion"};
        int idx = 0;
        while(num > 0) {
            int d = num % 1000;
            if(d > 0) {
                ret = getWords(d) + " " + s[idx] + " " + ret;
            }
            
            idx++;
            num = num / 1000;
        }

        return ret.trim();
    }
    
    String getWords(int num) {
        if(num >= 100) {
            String ret = getWords( num / 100) + " Hundred";
            if(num % 100 != 0)
                ret += " " + getWords( num % 100);
            return  ret;
        } else if(num > 0) {
            if(words.containsKey(num)) {
                return words.get(num);
            } else {
                int m = num % 10;
                int d2 = num - m;
                return words.get(d2) + " " + words.get(m);
            }
        } else {
            return "";
        }
    }
}
