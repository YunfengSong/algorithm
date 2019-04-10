/**
 * @Auther: songyunfeng
 * @Date: 2019/3/26 00:18
 * @Description:
 */
public class BinarySearch {
    //二分查找（折半查找），版本1
    int BinarySearch1(int a[], int value, int n)
    {
        int low, high, mid;
        low = 0;
        high = n-1;
        while(low<=high)
        {
            mid = (low+high)/2;
            if(a[mid]==value)
                return mid;
            if(a[mid]>value)
                high = mid-1;
            if(a[mid]<value)
                low = mid+1;
        }
        return -1;
    }

    //二分查找，递归版本
    int BinarySearch2(int a[], int value, int low, int high)
    {
        int mid = low+(high-low)/2;
        if(a[mid]==value)
            return mid;
        if(a[mid]>value)
            return BinarySearch2(a, value, low, mid-1);
        if(a[mid]<value)
            return BinarySearch2(a, value, mid+1, high);
        return -1;
    }
}
