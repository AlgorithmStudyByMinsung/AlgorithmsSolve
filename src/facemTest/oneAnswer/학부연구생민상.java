package facemTest.oneAnswer;
// https://www.acmicpc.net/problem/21922
/**
 * 그래프_브루트포스 + 시뮬레이션과 구현 + backTracking
 *
 * - 아무리 시간 복잡도가 넉넉해보여도 꼭 계산하고 가자
 * - 풀이 전에 꼭 주의사항을 check
 * - 방향성문제 연습
 * - 주의할 게 너무 많은 문제
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
    static int[][] d = new int[][] {{1 , 0}, {-1 , 0}, {0 , 1}, {0 , -1}};
    // 0번 : 남 1번 : 북 2번: 동 3번 : 서
    // 좌표 문제는 i == x j == y 로 생각하자 (수학이랑 반대)

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();


        a = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        visit_dir = new boolean[N + 1][M + 1][4];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                a[i][j] = scan.nextInt();
            }
        }
    }

    static void dfs(int x, int y, int dir) {
        // checking
        if (!visit[x][y]) ans ++;
        if (visit_dir[x][y][dir]) return; // continue 가 아니라 return;

        visit[x][y] = true;
        visit_dir[x][y][dir] = true;

        // change dir

        int type = a[x][y];

        if (type == 1 && (dir == 2 || dir == 3)) return;
        else if (type == 2 && (dir == 0 || dir == 1)) return;

        else if (type == 3) {
            if (dir == 0) dir = 3;
            else if (dir == 1) dir = 2;
            else if (dir == 2) dir = 1;
            else if (dir == 3) dir = 0;

        } else if (type == 4) {
            if (dir == 0) dir = 2;
            else if (dir == 1) dir = 3;
            else if (dir == 2) dir = 0;
            else if (dir == 3) dir = 1;
        }
        // dx dy 정하기
        int dx = 0; int dy = 0;

        if (dir == 0) {
            dx = x + 1; dy = y;

        } else if (dir == 1) {
            dx = x - 1; dy = y;

        } else if (dir == 2) {
            dx = x; dy = y + 1;

        } else if (dir == 3) {
            dx = x; dy = y - 1;

        }

        if (dx >= 1 && dx <= N && dy >= 1 && dy <= M) {
            dfs(dx , dy , dir);
        }

    }
    /**
     * multiDfs
     * */
    public static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a[i][j] == 9) {
                    if (!visit[i][j]) ans += 1;
                    visit[i][j] = true;

                    for (int k = 0; k < 4; k++) {
                        int dx = i + d[k][0];
                        int dy = j + d[k][1];

                        if (dx >= 1 && dx <= N && dy >= 1 && dy <= M) {
                            dfs(dx , dy , k);
                        }
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
