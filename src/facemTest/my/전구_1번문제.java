package facemTest.my;
// https://www.acmicpc.net/problem/21918

import java.io.*;
import java.util.StringTokenizer;

public class 전구_1번문제 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        a = new int[N + 1];

        for (int i = 1; i <= N ; i++) a[i] = scan.nextInt();
    }

    static void pro (int type, int l , int r) {
        if (type == 1) {
            a[l] = r;
        } else if (type == 2) {
            for (int i = l; i <=r ; i++) {
                a[i] = a[i] == 0 ? 1 : 0;
            }
        } else if (type == 3) {
            for (int i = l; i <=r ; i++) {
                a[i] = 0;
            }
        } else {
            for (int i = l; i <=r ; i++) {
                a[i] = 1;
            }
        }
    }

    public static void main(String[] args) {
        input();
        for (int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            pro(a, b, c);
        }
        for (int i = 1; i <= N; i++) {
            sb.append(a[i]).append(' ');
        }
        System.out.println(sb);
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
