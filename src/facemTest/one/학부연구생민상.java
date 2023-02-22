package facemTest.one;
// https://www.acmicpc.net/problem/21922
/**
 * 그래프_브루트포스 + 시뮬레이션과 구현 + backTracking
 *
 * - 아무리 시간 복잡도가 넉넉해보여도 꼭 계산하고 가자
 * - 풀이 전에 꼭 주의사항을 check
 * - 방향성문제 연습
 * - 주의할 게 너무 많은 문제
 * */

/**
 * 격자를 본다면 그래프 이론을 떠올리자
 * 시뮬레이션과 구현은 중복 check 를 꼭 하자
 * */
import java.io.*;
import java.util.StringTokenizer;

public class 학부연구생민상 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static int[][] a;
    static int ans;
    static boolean[][] visit;
    static boolean[][][] visit_dir;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();


        a = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        visit_dir = new boolean[N + 1][M + 1][100];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                a[i][j] = scan.nextInt();
            }
        }
    }

    static void dfs(int x, int y, char dir) {
        /**
         * 주의 : 방문을 헸다면 check 하면 안됨
         * backTracking => 또한 같은 방향에 같은 위치라면 할 필요가 없음
         * */
        if (visit_dir[x][y][dir - 'A']) return;

        if (!visit[x][y]) ans += 1;
        visit[x][y] = true;
        visit_dir[x][y][dir - 'A'] = true;

        if (a[x][y] == 1 && (dir == 'E' || dir == 'W')) return;
        else if (a[x][y] == 2 && (dir == 'S' || dir == 'N')) return;

        else if (a[x][y] == 3) {
            if (dir == 'E') {
                dir = 'S';
            } else if (dir == 'W') {
                dir = 'N';

            } else if (dir == 'S') {
                dir = 'E';

            } else if (dir == 'N') {
                dir = 'W';
            }

        } else if (a[x][y] == 4) {
            if (dir == 'E') {
                dir = 'N';
            } else if (dir == 'W') {
                dir = 'S';

            } else if (dir == 'S') {
                dir = 'W';

            } else if (dir == 'N') {
                dir = 'E';

            }
        }


        int dx = 0; int dy = 0;

        if (dir == 'E') {
            dx = x; dy = y + 1;

        } else if (dir == 'W') {
            dx = x; dy = y - 1;

        } else if (dir == 'S') {
            dx = x - 1; dy = y;

        } else if (dir == 'N') {
            dx = x + 1; dy = y;

        }

        if (dx >= 1 && dx <= N && dy >= 1 && dy <= M) {
            dfs(dx , dy, dir);
        }
    }

    public static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a[i][j] == 9) {
                    /**
                     * 여기도 방문을 했을 수 있음
                     * */
                    if (!visit[i][j]) ans += 1;
                    visit[i][j] = true;

                    if (i >= 1 && i <= N && j + 1 >= 1 && j + 1 <= M) {
                        dfs(i, j + 1, 'E');

                    }
                    if (i >= 1 && i <= N && j - 1 >= 1 && j - 1 <= M) {
                        dfs(i, j - 1, 'W');


                    }
                    if (i - 1 >= 1 && i - 1 <= N && j >= 1 && j <= M) {
                        dfs(i - 1, j, 'S');


                    }
                    if (i + 1 >= 1 && i + 1 <= N && j >= 1 && j <= M) {
                        dfs(i + 1, j, 'N');


                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
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
