import java.util.Arrays;

public class Algorithm8 {

    public static int[] searchRange(int[] A, int target) {
        // write your code here

        int[] result = new int[2];
        Arrays.fill(result, -1);

        if (A == null || A.length == 0) {
            return result;
        }

        int start = 0, end = A.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                //向左找,考虑越界
                for (int i = mid; i >= 0; --i) {
                    if (i == 0 && A[i] == target) {
                        result[0] = i;
                        break;
                    }
                    if (A[i] != target) {
                        result[0] = i + 1;
                        break;
                    }
                }
                //向右找
                for (int i = mid; i < A.length; ++i) {
                    if (i == A.length - 1 && A[i] == target) {
                        result[1] = i;
                        break;
                    }
                    if (A[i] != target) {
                        result[1] = i - 1;
                        break;
                    }
                }

                return result;

            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1};
        int[] result = searchRange(A, 1);
        System.out.println(Arrays.toString(result));
    }


}
