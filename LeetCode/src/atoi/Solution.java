package atoi;

import java.util.regex.Pattern;

public class Solution {
    public int myAtoi(String str) {


        if (str == null || str.equals("[0-9+\\-].*")) {
            return 0;
        }

        Pattern pattern = Pattern.compile("afa");

        //1. 取消空格
        String rStr = str.trim();

        //2. 首位判定
        if (!rStr.matches("[0-9+\\-].*")) {
            return 0;
        }

        long result = 0;

        boolean isFirst = true;
        boolean isN = false;

        for (char c : rStr.toCharArray()) {

            if (isFirst && (c == '-' || c == '+')) {
                isFirst = false;
                if (c == '-') {
                    isN = true;
                }
                continue;
            } else if (c >= '0' && c <= '9') {
                result = result * 10 + (int) (c - '0');
            } else {
                break;
            }

        }

        result = isN ? -result : result;

        if (result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;


    }
}