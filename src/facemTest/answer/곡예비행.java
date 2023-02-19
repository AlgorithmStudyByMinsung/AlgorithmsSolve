package facemTest.answer;
// https://www.acmicpc.net/problem/21923
import java.io.*;
import java.util.*;
/**
 * 초기화가 중요한 dp 문제
 *
 * 초기화만 잘 시켜놓는다면 시작점이 있어도 괜찮다.
 * */

/**
 * dp 유형
 *
 * dp[i][j] = a[i][j] + Math(방향 1번의 dp , 방향 2번의 dp);
 * */
public class 곡예비행 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;
    static int[][] a;
    static long[][] ds;
    static long[][] de;
    static int[][] dir_s = new int[][] {{1 , 0}, {0 , -1}};
    static int[][] dir_e = new int[][] {{1 , 0}, {0 , 1}};


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        a = new int[N + 1][M + 1];
        ds = new long[N + 1][M + 1];
        de = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                a[i][j] = scan.nextInt();
            }
        }
    }

    static void dp_s() {
        // init
        ds[N][1] = a[N][1];

        for (int i = N; i >= 2; i--) {
            ds[i - 1][1] = ds[i][1] + a[i - 1][1];
        }
        for (int i = 0; i < M; i++) {
            ds[N][i + 1] = ds[N][i] + a[N][i + 1];
        }

        // dp start
        for (int i = N - 1; i >=1 ; i--) {
            for (int j = 2; j <= M; j++) {
                long res = Long.MIN_VALUE;

                for (int k = 0; k < 2; k++) {
                    int dx = i + dir_s[k][0];
                    int dy = j + dir_s[k][1];

                    if (dx >= 1 && dx <= N && dy >= 1 && dy <= M) {
                        res = Math.max(res , ds[dx][dy]);
                    }
                }

                ds[i][j] = res + a[i][j];
            }
        }
    }

    static void dp_e() {
        // init
        de[N][M] = a[N][M];

        for (int i = N; i >= 2; i--) {
            de[i - 1][M] = de[i][M] + a[i - 1][M];
        }
        for (int i = M; i >= 2; i--) {
            de[N][i - 1] = de[N][i] + a[N][i - 1];
        }

        // dp start
        for (int i = N - 1; i >=1 ; i--) {
            for (int j = M - 1; j >= 1; j--) {
                long res = Long.MIN_VALUE;

                for (int k = 0; k < 2; k++) {
                    int dx = i + dir_e[k][0];
                    int dy = j + dir_e[k][1];

                    if (dx >= 1 && dx <= N && dy >= 1 && dy <= M) {
                        res = Math.max(res , de[dx][dy]);
                    }
                }

                de[i][j] = res + a[i][j];
            }
        }
    }
    static void pro() {
        dp_s();
        dp_e();

        long max = Long.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                max = Math.max(max , ds[i][j] + de[i][j]);
            }
        }

        System.out.println(max);
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
