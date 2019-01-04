import java.util.Arrays;

/**
 * @Auther: songyunfeng
 * @Date: 2019/1/4 09:36
 * @Description:
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] a = { 54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28 };
       sort(a);
        System.out.println(Arrays.toString(a));
    }

   private static void sort(int[] a) {
        // 设置步长，默认为数组长度的一半
        int step = a.length / 2;

        while (step >= 1) {
            for (int i = step; i < a.length; i += step) {
                int tmp = a[i];
                int j;
                for (j = i; j > 0 && a[j - step] > tmp; j -= step) {
                    a[j] = a[j - step];//元素后移
                }
                a[j] = tmp;//插入的位置，注意此时j在for循环中已经进行了一次--
            }
            step /= 2;
        }
    }

}
