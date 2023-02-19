package codingTest.two;
// https://www.acmicpc.net/problem/21277
import java.io.*;
import java.util.StringTokenizer;
// 아직 답변 못들음
public class 짠돌이호석 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N1;
    static int M1;
    static int N2;
    static int M2;
    static char[][] a;
    static char[][] b;
    static char[][] tmp;

    static void input() {
        N1 = scan.nextInt();
        M1 = scan.nextInt();
        /**
         * 평행이동 문제는 범위를 크게 줘야한다. 평행이동을 할 만큼 줘야한다.
         * */
        a = new char[101][101];

        for (int i = 0; i < N1; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < M1; j++) {
                a[i][j] = str.charAt(j);
            }
        }

        N2 = scan.nextInt();
        M2 = scan.nextInt();

        b = new char[101][101];
        tmp = new char[101][101];

        for (int i = 0; i < N2; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < M2; j++) {
                b[i][j] = str.charAt(j);
            }
        }
    }

    static void rotate () {
        for (int i = 0; i < N2; i++) {
            for (int j = 0; j < M2; j++) {
                // -1 을 해줘야한다.
                tmp[j][N2 - i - 1] = b[i][j];
            }
        }
        int t = N2;
        N2 = M2;
        M2 = t;
        /**
         * tmp 의 전체를 b 에 줘야 하기에 범위를 저렇게 설정
         * */
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                b[i][j] = tmp[i][j];

            }
        }
    }

    static boolean possible(int i1 , int j1) {
        for (int i = 0; i < N1; i++) {
            for (int j = 0; j < M1; j++) {
                /**
                 * 0 일때는 무조건 되기에 다 건너뛰면 결국은 return true dlek.
                 * */
                if (a[i][j] == '0') continue;

                int bi = i + i1; int bj = j + j1;

                /**
                 * 범위안에서만 false 를 주면 된다.
                 * */
                if (bi >= 0 && bi < N1 && bj >= 0 && bj < M1) {
                    if (b[bi][bj] == '1') return false;
                }
            }
        }
        return true;
    }

    static void transfer () {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            rotate();
            for (int j = -100; j <= 100 ; j++) {
                for (int k = -100; k <= 100; k++) {
                    if (possible(j , k)) {

                        int x = Math.max(N1 , N2 + j) - Math.min(0, j);
                        int y = Math.max(M1 , M2 + k) - Math.min(0, k);
                        ans = Math.min(ans , x * y);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        transfer();
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
