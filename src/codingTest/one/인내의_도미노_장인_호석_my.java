package codingTest.one;
// 틀림
// 시간 : 1시간 10분
/**
 * 시뮬레이션과 구현문제
 * 나는 잘 하지는 못 함
 * */
import java.io.*;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/20165
public class 인내의_도미노_장인_호석_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static int R;
    static int[][] a;
    static boolean[][] check;
    static int sum = 0;


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();

        a = new int[N + 1][M + 1];
        check = new boolean[N + 1][M + 1];


        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                a[i][j] = scan.nextInt();
            }
        }
    }

    static void attack_E (int x, int y, boolean c) {
        if (!c) return;

        int b = a[x][y];

        int range = 0;
        if (y + b -1 <= M) {
            range = y + b;
        } else {
            range = M + 1;
        }

        boolean go = true;
        if (check[x][range -1]) go = false;

        for (int i = y; i < range ; i++) {
            if (check[x][i]) continue;

            check[x][i] = true;
            sum += 1;
        }
        if (!(range == M + 1)) attack_E(x, range -1, go);
    }

    static void attack_W (int x, int y, boolean c) {
        if (!c) return;

        int b = a[x][y];

        int range = 0;
        if (y - b + 1 > 0) {
            range = y - b + 1;
        } else {
            range = 0;
        }

        boolean go = true;
        if (check[x][range]) go = false;

        for (int i = y; i >= range ; i--) {
            if (check[x][i]) continue;

            check[x][i] = true;
            sum += 1;
        }
        if (!(range == 0)) attack_W(x, range, go);
    }

    static void attack_S (int x, int y, boolean c) {
        if (!c) return;

        int b = a[x][y];

        int range = 0;
        if (x + b - 1 < N) {
            range = x + b - 1;
        } else {
            range = N;
        }

        boolean go = true;
        if (check[range][y]) go = false;

        for (int i = 0; i <= range ; i++) {
            if (check[i][y]) continue;

            check[i][y] = true;
            sum += 1;
        }
        if (!(range == N)) attack_S(range, y, go);
    }

    static void attack_N (int x, int y, boolean c) {
        if (!c) return;

        int b = a[x][y];

        int range = 0;
        if (x - b + 1 > 0) {
            range = x - b + 1;
        } else {
            range = 0;
        }

        boolean go = true;
        if (check[range][y]) go = false;

        for (int i = x; i >= range ; i--) {
            if (check[i][y]) continue;

            check[i][y] = true;
            sum += 1;
        }
        if (!(range == 0)) attack_N(range, y, go);
    }


    static void attack (int x, int y, Character c) {
        if (c == 'E') {
            attack_E(x, y, true);
        } else if (c == 'W') {
            attack_W(x, y, true);
        } else if (c == 'S') {
            attack_S(x, y, true);

        } else if (c == 'N') {

            attack_N(x, y, true);
        }
    }

    static void defense (int x, int y) {
        check[x][y] = true;
    }

    public static void main(String[] args) {
        input();

        for (int i = 0; i < R; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            String z = scan.next();
            char loc = z.charAt(0);

            attack(x, y, loc);

            int x1 = scan.nextInt();
            int y1 = scan.nextInt();

            defense(x1, y1);
        }

        System.out.println(sum);

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M; j++) {
                if (check[i][j]) sb.append('F').append(' ');
                else sb.append('S').append(' ');
            }
            sb.append('\n');
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
