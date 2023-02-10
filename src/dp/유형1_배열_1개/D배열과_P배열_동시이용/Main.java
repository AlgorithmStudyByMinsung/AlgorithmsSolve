package dp.유형1_배열_1개.D배열과_P배열_동시이용;

import java.io.*;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/11052
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] p;
    static int[] d;

    static void input() {
        N = scan.nextInt();
        p = new int[N +1];
        d = new int[N +1];

        for (int i = 1; i <= N ; i++) p[i] = scan.nextInt();
    }

    static void pro() {
        for (int i = 1; i <= N ; i++) {
            for (int j = 0; j < i; j++) {
                d[i] = Math.max(d[i] , d[j] + p[i -j]);
            }
        }
        System.out.println(d[N]);
    }

    public static void main(String[] args) {
        input();
        pro();
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
