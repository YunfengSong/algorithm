/**
 * @Auther: songyunfeng
 * @Date: 2019/1/4 09:43
 * @Description:
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] A = { 1, 4, 3, 2, 5 };
        mergeSort(A, 5);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);

        }
    }

    public static int[] mergeSort(int[] A, int n) {
        // write code here
        sort(A, 0, n - 1);
        return A;
    }

    public static void sort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(A, left, mid);
            sort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    public static void merge(int[] A, int left, int mid, int right) {
        // 临时数组

        int n = right - left + 1;
        int[] tmpArr = new int[n];
        int l = left;
        int r = mid + 1;
        int t = 0;// 临时数组下标元素

        // 比较两子序列元素的大小
        while (l <= mid && r <= right) {
            if (A[l] < A[r]) {
                tmpArr[t++] = A[l++];
            } else {
                tmpArr[t++] = A[r++];
            }
        }

        // 剩余的加入临时数组
        while (l <= mid) {
            tmpArr[t++] = A[l++];
        }
        // 剩余的加入临时数组
        while (r <= right) {
            tmpArr[t++] = A[r++];
        }

        // 把临时数组元素放回原数组
        for (int i = 0; i < t; i++) {
            A[left + i] = tmpArr[i];
        }

    }
    /*public  void mergeSort(int[] a, int left, int right) {
           int t = 1;// 每组元素个数
           int size = right - left + 1;
           while (t < size) {
               int s = t;// 本次循环每组元素个数
               t = 2 * s;
               int i = left;
               while (i + (t - 1) < size) {
                   merge(a, i, i + (s - 1), i + (t - 1));
                   i += t;
               }
               if (i + (s - 1) < right)
                   merge(a, i, i + (s - 1), right);
           }
        }

        private static void merge(int[] data, int p, int q, int r) {
           int[] B = new int[data.length];
           int s = p;
           int t = q + 1;
           int k = p;
           while (s <= q && t <= r) {
               if (data[s] <= data[t]) {
                   B[k] = data[s];
                   s++;
               } else {
                   B[k] = data[t];
                   t++;
               }
               k++;
           }
           if (s == q + 1)
               B[k++] = data[t++];
           else
               B[k++] = data[s++];
           for (int i = p; i <= r; i++)
               data[i] = B[i];
        }*/
}