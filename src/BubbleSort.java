import java.util.Arrays;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/2 17:45
 * @Description:  Bubble
 */
public class BubbleSort {

        public static void main(String[] args) {
            int [] a = {1,100,234,44,3,2,4,5};
            bubbleSort(a);
            System.out.println(Arrays.toString(a));
        }

        public static int[] bubbleSort(int[] A) {

            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[i] > A[j]) {
                        int tmp = A[i];
                        A[i] = A[j];
                        A[j] = tmp;
                    }
                }
            }

            return A;
        }

}
