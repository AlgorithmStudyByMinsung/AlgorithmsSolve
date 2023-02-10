package dp.유형2_배열_2개.마지막_상태를_기록;
// https://www.acmicpc.net/problem/2156
import java.io.*;
import java.util.StringTokenizer;

public class 포도주시식 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;
    static int[][] d;

    static void input() {
        N = scan.nextInt();

        a = new int[N +1];
        d = new int[N +1][3];

        for (int i = 1; i <= N ; i++) a[i] = scan.nextInt();
    }

    static void pro() {
        d[1][0] = 0;
        d[1][1] = a[1];

        for (int i = 2; i <= N ; i++) {
            d[i][2] = d[i -1][1] + a[i];
            d[i][1] = d[i -1][0] + a[i];

            int max = 0;
            for (int j = 0; j < 3; j++) {
                max = Math.max(max, d[i -1][j]);
            }

            d[i][0] = max;
        }
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans = Math.max(ans, d[N][i]);
        }

        System.out.println(ans);
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
