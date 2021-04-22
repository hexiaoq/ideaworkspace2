import org.junit.Test;

class Solution {
    @Test
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3) {
            return false;
        }
        int lenOfFirst = 1;
        int lenOfSecond = 1;
        while (lenOfFirst <= len / 2) {
            String strFirst = num.substring(0, lenOfFirst);
            if (lenOfFirst > 1 && strFirst.startsWith("0")) {
                break;
            }
            long firstNum = Long.valueOf(strFirst);
            while (lenOfSecond <= len / 2) {
                String strSecond = num.substring(lenOfFirst, lenOfFirst + lenOfSecond);
                if (lenOfSecond > 1 && strSecond.startsWith("0")) {
                    break;
                }
                long secondNum = Long.valueOf(strSecond);
                long oriFirstNum = firstNum;
                long sum = firstNum + secondNum;
                int lenOfSum = String.valueOf(sum).length();
                int index = lenOfFirst + lenOfSecond;
                while (index + lenOfSum <= len) {
                    long strSum = Long.valueOf(num.substring(index, index + lenOfSum));
                    if (strSum != sum) {
                        break;
                    }
                    if (index + lenOfSum == len) {
                        return true;
                    }
                    firstNum = secondNum;
                    secondNum = sum;
                    index += lenOfSum;
                    sum = firstNum + secondNum;
                    lenOfSum = String.valueOf(sum).length();
                }
                firstNum = oriFirstNum;
                lenOfSecond++;
            }
            lenOfSecond = 1;
            lenOfFirst++;
        }
        return false;
    }
}
