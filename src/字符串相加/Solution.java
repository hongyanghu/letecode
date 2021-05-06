package 字符串相加;

import java.math.BigDecimal;

public class Solution {
    public static String addStrings(String num1,String num2){
        BigDecimal bigDecimal = new BigDecimal(num1);
        BigDecimal bigDecimal1= new BigDecimal(num2);
        BigDecimal add = bigDecimal.add(bigDecimal1);
        return add.toString();
    }

    public static void main(String[] args) {
        String num1="10021";
        String num2="10052";
        String s = Solution.addStrings(num1, num2);
        System.out.println(s);

    }
}
