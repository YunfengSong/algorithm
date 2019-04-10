import java.util.Scanner;

class solution {
    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();    //获取开始时间
        int count = 0;
        for (int i = 0; i < 1000000; i++) {
            if(is2018(i)) count++;
        }

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println(count);
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }



    static boolean is2018(int x) {
        int[] d = new int[]{8, 1, 0, 2};
        int index = 0;
        while (x > 0) {
            if (x % 10 == d[index]) index++;
            x /= 10;
            if (index == 4) return true;
        }
        return false;
    }

//    static boolean is2018(int s) {
//        if (String.valueOf(s).matches
//                ("[1，3，4，5，6，7，8，9]{0,}[0,1,3,4,5,6,7,8,9]{0,}[2]{1,}[1,2,3,4,5,6,7,8,9]{0,}[0]{1,}[0,2,3,4,5,6,7,8,9]{0,}[1]{1,}[0,1,2,3,4,5,6,7,9]{0,}[8]{1,}"))
//            return true;
//        else return false;
//    }
}