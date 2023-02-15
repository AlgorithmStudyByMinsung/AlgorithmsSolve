package codingTest.three;
// https://www.acmicpc.net/problem/22253
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 트리 + dp
 * */
public class 트리디자이너호석 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    /**
     * d[i][j] i 루트로 시작해서 마지막이 j 인 경우의 수
     * */
    static int[][] d;
    static int ans;
    static int MOD = 1000000007;

    static void input() {
        N = scan.nextInt();
        a = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) a[i] = scan.nextInt();
        for (int i = 1; i <= N ; i++) adj[i] = new ArrayList<>();
        visit = new boolean[N + 1];
        d = new int[N + 1][10];


        for (int i = 0; i < N - 1; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            adj[from].add(to);
            adj[to].add(from);
        }


    }
    static void dfs(int x) {
        d[x][a[x]] = 1;
        visit[x] = true;

        for (Integer y : adj[x]) {
            if (visit[y]) continue;

            dfs(y);
            /**
             * 항상 선택을 하고 안하고의 dp 는 2개를 만들어 줘야한다.
             * */
            for (int i = a[x]; i <= 9 ; i++) {
                d[x][a[x]] += d[y][i];
                d[x][a[x]] %= MOD;
            }

            for (int i = 0; i <= 9; i++) {
                d[x][i] += d[y][i];
                d[x][i] %= MOD;
            }
        }
    }
    static void pro() {
        dfs(1);
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += d[1][i];
            ans %= MOD;
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
