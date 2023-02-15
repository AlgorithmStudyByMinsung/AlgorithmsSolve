package codingTest.three;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리디자이너호석_wrong {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] d;
    static int ans;

    static void input() {
        N = scan.nextInt();
        a = new int[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) a[i] = scan.nextInt();
        for (int i = 1; i <= N ; i++) adj[i] = new ArrayList<>();
        visit = new boolean[N + 1];
        d = new int[N + 1];

        for (int i = 1; i <= N ; i++) {
            d[i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            adj[from].add(to);
            adj[to].add(from);
        }
    }
    static void dfs(int x) {
        visit[x] = true;
        if (adj[x].size() == 1 && x != 1) {
            ans += d[x];
        }

        for (Integer y : adj[x]) {
            if (visit[y]) continue;

            if (a[y] >= a[x]) {
                d[y] += 2 * d[x];
            } else {
                d[y] += d[x];
            }

            dfs(y);
        }
    }


    public static void main(String[] args) {
        input();
        dfs(1);
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
