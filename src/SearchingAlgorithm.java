import java.util.Scanner;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/2 17:13
 * @Description: //binary searching
 */
public class SearchingAlgorithm {

        public static void main(String[] args) {

            int[] array = {1,2,3,6,9,10,13,16,45,56};
            Scanner scn = new Scanner(System.in);
            while (scn.hasNext()) {
                int number = scn.nextInt();

                // 顺序查找
                System.out.println("lineSearch index:"+lineSearch(array, number));

                // 二分查找
                System.out.println("lineSearch index:"+binarySearch(array, number));
            }
        }

        // 顺序查找法, 逐个查找, 时间复杂度n
        public static int lineSearch(int[] array, int number) {
            int index = -1;
            for (int i=0;i<array.length;i++) {
                if (array[i] == number) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        // 二分查找法, 也称折半查找, 限定为有序数列, 时间复杂度O（log2n）
        public static int binarySearch(int[] array, int number) {
            int start = 0;
            int end = array.length-1;
            int mid = end / 2;
            int index = -1;

            while (start <= end) {
                if (array[mid] == number) {
                    index = mid;
                    break;
                } else if (array[mid] > number) {
                    end = mid -1;
                    mid = (start + end)/2;
                } else {
                    start = mid +1;
                    mid = (start + end)/2;
                }
            }
            return index;
        }

}
