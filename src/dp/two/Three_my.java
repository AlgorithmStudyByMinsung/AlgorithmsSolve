package dp.two;
// http://boj.kr/2579
import java.io.*;
import java.util.StringTokenizer;

public class Three_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;
    static int[][] d;
    static void input() {
        N = scan.nextInt();
        a = new int[N +1];
        d = new int[N +1][N +1];

        for (int i = 1; i <= N; i++) a[i] = scan.nextInt();
    }

    static void pro() {
        /**
         * 예외 처리를 안하면 인덱스 out 예외 가 터진다.
         * */
        if (N <3)  {
            if (N == 1) System.out.println(a[1]);
            if (N == 2) System.out.println(a[2] + a[1]);
            return;
        }

        d[1][1] = a[1];
        d[1][2] = -1;

        d[2][1] = a[2];
        d[2][2] = a[2] + a[1];

        for (int i = 3; i <= N ; i++) {
            d[i][1] = Math.max(d[i -2][1], d[i -2][2]) + a[i];

            d[i][2] = d[i -1][1] + a[i];
        }
        int ans = Math.max(d[N][1], d[N][2]);
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
