import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm10 {

    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }

        int oxr = 0;

        for (int a : A) {
            oxr ^= a;
        }

        //2. 查看OXR 1的位置
        int indexOfOne = getIndexOfOne(oxr);

        //3. 根据indexOfOne的位置进行分组
        int ra = 0, rb = 0;

        for (int a : A) {

            if (isBit1(a, indexOfOne)) {
                ra ^= a;
            } else {
                rb ^= a;
            }

        }

        result.add(ra);
        result.add(rb);
        return result;
    }

    public int getIndexOfOne(int num) {

        int index = 0;

        while (num != 0) {
            if ((num & 1) != 0) {
                return index;
            }
            ++index;
            num >>>= 1;
        }

        return index;
    }

    public boolean isBit1(int num, int index) {
        int mark = 1 << index;
        return  (num & mark) != 0;
    }

    public static void main(String[] args) {
        Algorithm10 algorithm10 = new Algorithm10();

        int[] array = {4, 12};
        System.out.println(algorithm10.singleNumberIII(array));
    }


}
