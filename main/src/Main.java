import java.util.Scanner;

public class Main {
    static int[] d = new int[]{8, 1, 0, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 2018; i <= n; i++) {
                if (is2018(i)) sum++;
            }
            System.out.println(sum);
        }
    }

    static boolean is2018(int x) {
        int index = 0;
        while (x > 0) {
            if (x % 10 == d[index]) index++;
            x /= 10;
            if (index == 4) return true;
        }
        return false;
    }

}