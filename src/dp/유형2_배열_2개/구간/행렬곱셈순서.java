package dp.유형2_배열_2개.구간;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11049

public class 행렬곱셈순서
{
    static class Elem {
        public int s;
        public int e;

        public Elem(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Elem[] a;
    static int[][] d;

    static void input() {
        N = scan.nextInt();
        a = new Elem[N + 1];
        d = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            a[i] = new Elem(x , y);
        }
    }

    static void pro() {

        for(int len =2; len<=N; len++) {
            for(int i = 1; i<= N -len + 1; i++) {
                int j = i + len -1;

                d[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k ++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k + 1][j] + a[i].s * a[k].e * a[j].e);
                }
            }
        }
        System.out.println(d[1][N]);
    }


    public static void main(String args[])
    {
        input();
        pro();

    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || ! st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch(IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}
