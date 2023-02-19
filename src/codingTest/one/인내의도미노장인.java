package codingTest.one;

import java.io.*;
import java.util.StringTokenizer;

public class 인내의도미노장인 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static int R;
    /**
     * 넘어졌다는 것을 boolean 으로 check 하는 것이 아니라 0으로 check 하고
     * backUp 배열을 둔다.
     * */
    static int[][] a;
    static int[][] backUp;
    static int ans;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();

        a = new int[N + 1][M + 1];
        backUp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                a[i][j] = scan.nextInt();
                backUp[i][j] = a[i][j];
            }
        }
    }
    static void attack(int x, int y, Character dir) {
        int dx = 0;
        int dy = 0;
        /**
         * 변화량을 채크해서 더해준다
         * */
        if (dir == 'E') {
            dy = 1;
        } else if (dir == 'W') {
            dy = -1;
        }  else if (dir == 'S') {
            dx = 1;
        }  else {
            dx = -1;
        }

        int cnt = a[x][y];

        while (x >= 1 && x <= N && y >= 1 && y <= M && cnt >= 1) {
            if (a[x][y] != 0) {
                ans ++;
            }

            cnt -= 1;
            cnt = Math.max(cnt , a[x][y] - 1);

            a[x][y] = 0;

            x += dx; y += dy;
        }
    }

    static void defense(int x, int y) {
        a[x][y] = backUp[x][y];
    }

    static void pro() {
        for (int i = 0; i < R; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            Character dir = scan.next().charAt(0);

            attack(x, y, dir);

            int x1 = scan.nextInt();
            int y1 = scan.nextInt();

            defense(x1, y1);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(ans);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a[i][j] == 0) {
                    sb.append('F').append(' ');
                } else {
                    sb.append('S').append(' ');
                }
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
