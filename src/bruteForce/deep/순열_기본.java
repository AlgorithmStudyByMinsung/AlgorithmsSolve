package bruteForce.deep;

import java.io.*;
import java.util.StringTokenizer;
/**
 * 순열 !! 기본
 * */
public class 순열_기본 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N, M;
    static char[] chars;
    /**
     * selected 배열을 만들어서
     * 고른 것을 넣는다.
     * */
    static int[] selected;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        chars = new char[N +1];
        selected = new int[M +1];

        String[] tokens = scan.nextLine().split(" ");

        for (int i = 1; i <= N; i++) {
            chars[i] = tokens[i -1].charAt(0);
        }
    }

    static void rec_func(int k) {
        if (k == N +1) {
            return;
        }

        /**
         * 전에 고른거에 하나 증가된 것부터 시작
         * k 가 증가된 상태이므로 -1 을 해준다.
         * */
        for (int i = selected[k -1] +1; i <= M; i++) {
            selected[k] = i;
            rec_func(k +1);
            selected[k] = 0;
        }

    }

    public static void main(String[] args) {
        input();
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
