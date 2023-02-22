package bruteForce.NMAndK;

import java.io.*;
import java.util.StringTokenizer;

public class NM과K_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static int K;
    static int[][] a;
    static boolean[][] check;
    static int ans = Integer.MIN_VALUE;
    static int[][] dir = new int[][] {{1 , 0}, {-1 , 0}, {0 , 1}, {0 , -1}};


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        a = new int[N + 1][M + 1];
        check = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                a[i][j] = scan.nextInt();
            }
        }
    }

    static void pro(int k, int px, int py, int sum) {
        if (k == K + 1) {
            ans = Math.max(sum , ans);
            return;
        }
        for (int i = px; i <= N; i++) {
            for (int j = (i == px ? py: 1); j <= M; j++) {
                if (check[i][j]) continue;

                boolean available = true;

                for (int l = 0; l < 4; l++) {
                    /**
                     * l 로 해야하는 데 i 로 햇음
                     * */
                    int nx = i + dir[l][0];
                    int ny = j + dir[l][1];

                    if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                        if (check[nx][ny]) {
                            available = false;
                            break;
                        }
                    }
                }

                if (! available) continue;

                sum += a[i][j];
                k += 1;
                check[i][j] = true;
                pro(k, i, j + 1, sum);
                k -= 1;
                sum -= a[i][j];
                check[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro(1 , 1, 1, 0);
        System.out.println(ans);
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
