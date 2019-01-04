/**
 * @Auther: songyunfeng
 * @Date: 2019/1/4 09:41
 * @Description:
 */
public class SelectionSort {

    public int[] selectionSort(int[] A, int n) {
        // write code here
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            int j;
            // 找出最小值得元素下标
            for (j = i + 1; j < n; j++) {
                if (A[j] < A[index]) {
                    index = j;
                }
            }
            int tmp = A[index];
            A[index] = A[i];
            A[i] = tmp;
        }
        return A;
    }
}