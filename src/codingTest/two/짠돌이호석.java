package codingTest.two;
// https://www.acmicpc.net/problem/21277
import java.io.*;
import java.util.StringTokenizer;
/**
 * 시뮬레이션과 구현
 * - 평행이동과 회전
 * */
public class 짠돌이호석 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N1;
    static int M1;
    static char[][] a;
    static int N2;
    static int M2;
    static char[][] b;
    static char[][] tmp;

    static void input() {
        a = new char[100][100];
        b = new char[100][100];
        tmp = new char[100][100];

        N1 = scan.nextInt();
        M1 = scan.nextInt();
        /***/
        for (int i = 0; i < N1; i++) {
            String t = scan.next();
            for (int j = 0; j < M1; j++) {
                a[i][j] = t.charAt(j);
            }
        }

        N2 = scan.nextInt();
        M2 = scan.nextInt();

        for (int i = 0; i < N2; i++) {
            String t = scan.next();
            for (int j = 0; j < M2; j++) {
                b[i][j] = t.charAt(j);
            }
        }
    }

    static void rotate() {
        for (int i = 0; i < N2; i++) {
            for (int j = 0; j < M2; j++) {
                tmp[j][N2 - i - 1] = b[i][j];
            }
        }

        int t = N2;
        N2 = M2;
        M2 = t;

        for (int i = 0; i < N2; i++) {
            for (int j = 0; j < M2; j++) {
                b[i][j] = tmp[i][j];
            }
        }
    }

    static boolean possible(int x, int y) {
        for (int i = 0; i < N1; i++) {
            for (int j = 0; j < M1; j++) {
                if (a[i][j] == '0') continue;

                int bx = i + x; int by = i + y;

                if (bx >= 0 && bx < N2 && by >= 0 && by < M2) {
                    if (b[bx][by] == '1') return false;
                }
            }
        }
        return true;
    }

    static void pro() {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            rotate();
            for (int j = -51; j <= 51 ; j++) {
                for (int k = -51; k <= 51; k++) {
                    if (! possible(j, k)) continue;
                        int row = Math.max(N1 -1  , N2 + j -1) - Math.min(0 , j) + 1;
                        int col = Math.max(M1 - 1, M2 + k -1) - Math.min(0, k) + 1;

                        ans = Math.min(ans, row * col);
                }
            }
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
