package dp.one;

import java.io.*;
import java.util.StringTokenizer;

public class One_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int T;
    static int[] d;

    static void input() {
        N = scan.nextInt();
        d = new int[N +1];

        d[1] = 1; d[2] = 2; d[3] = 4;
    }
    static void pro() {
        for (int i = 4; i <= N ; i++) {
            d[i] = (d[i -1] + d[i -2] + d[i -3]);
        }
        sb.append(d[N]).append('\n');
    }

    public static void main(String[] args) {
        T = scan.nextInt();

        for (int i = 0; i < T; i++) {
            input();
            pro();
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
