package cn.book.util;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;//可取点数
    static int C;//需取点数
    static int D;//最大的最小间距

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        C(0,num[num.length-1],num);
        System.out.println(D);
    }

    private static void C(int start, int end, int[] num) {
        int mid = start + (end - start) / 2;
        if (start <= end) {
            //可行查右半区，不可行查左半区
            if (YN(mid, num)) {
                C(mid + 1, end, num);
            } else {
                C(start, mid - 1, num);
            }
        }
    }
    private static boolean YN(int d, int[] num) {
        int i = num[0];
        int count = 1;
        for (int j = 1; j < num.length; j++) {
            if (num[j] >= i + d) {
                i = num[j];
                count++;
            }
            //可行则保存D
            if (count == C) {
                D=d;
                return true;
            }
        }
        return false;
    }
}
