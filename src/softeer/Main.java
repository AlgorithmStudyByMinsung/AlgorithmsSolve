package softeer;

import java.util.*;
import java.io.*;


public class Main
{
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int h;
    static int k;
    static int r;
    static int cnt;
    static int child_cnt;

    static int[][] d;

    static void input() {
        h = scan.nextInt();
        k = scan.nextInt();
        r = scan.nextInt();

        for(int i = 0; i <= h; i ++) {
            int n = 1;
            for(int j = 0; j < i; j ++) {
                n *= 2;
            }
            cnt += n;
        }

        d = new int[cnt + 1][k + 1];

        child_cnt = 1;

        for(int i = 0; i < h; i ++) {
            child_cnt *= 2;
        }


        for(int i = 1; i <= child_cnt; i ++) {
            for(int j = 1; j <= k; j ++) {
                d[cnt - child_cnt + i][j] = scan.nextInt();
            }
        }
    }


    static void pro() {
        for(int i = 2; i<= r; i ++) {
            for(int j = 1; j <= cnt - child_cnt; j ++) {
                if(i % 2 == 1) {
                    d[j][i] = d[2 * j][i - 1];
                } else {
                    d[j][i] = d[2 * j + 1][i - 1];
                }
            }
        }
    }

    public static void main(String args[])
    {
        input();
        pro();
        int sum = 0;

        for(int i = 2; i<= r;i ++) {
            sum += d[1][i];
        }

        System.out.println(sum);

    }


}