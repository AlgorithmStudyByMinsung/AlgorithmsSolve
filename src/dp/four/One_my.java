package dp.four;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 트리는 dfs!
 *
 *
 * */
public class One_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int R;
    static int Q;
    static ArrayList<Integer>[] adj;
    static int[] d;
    static int[] ans;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();
        adj = new ArrayList[N +1];
        d = new int[N +1];
        visit = new boolean[N +1];
        ans = new int[Q];

        for (int i = 1; i <= N ; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N -1; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            adj[x].add(y); adj[y].add(x);
        }
        for (int i = 0; i < Q; i++) {
            int x= scan.nextInt();
            ans[i] = x;
        }
    }

    static int dfs(int x) {
        visit[x] = true;
        /**
         * 이건 말단 노드라고 볼 수 없다! 왜냐면 자식이 한개있지만 말단 노드가 아닐 수 도 있다.
         * */
        if (adj[x].size() == 1) {
            d[x] = 1;
            return d[x];
        }


        for (Integer integer : adj[x]) {
            if (visit[integer]) continue;

//            System.out.println("x = " + x +"," + "integer= "+ integer);
            d[x] += dfs(integer);
        }
        d[x] += 1;
        return d[x];
    }

    public static void main(String[] args) {
        input();
        dfs(R);
        for (int an : ans) {
            System.out.println(d[an]);
        }
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
