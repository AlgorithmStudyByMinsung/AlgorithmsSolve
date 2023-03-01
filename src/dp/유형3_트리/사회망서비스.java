package dp.유형3_트리;

import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/2533

public class 사회망서비스
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[][] d;


    static void input() {
        N = scan.nextInt();

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        d = new int[N + 1][3];

        for(int i = 1; i <=N ;i ++) adj[i] = new ArrayList<>();

        for(int i = 1; i< N ;i ++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }
    }

    static void dfs(int x) {
        visit[x] = true;

        d[x][0] = 0;
        d[x][1] = 1;

        for(int y : adj[x]) {
            if(visit[y]) continue;

            dfs(y);

            int min = Math.min(d[y][0] , d[y][1]);
            d[x][1] += min;
            d[x][0] += d[y][1];
        }
    }

    static void pro() {
        dfs(1);

        int ans = Math.min(d[1][0] , d[1][1]);

        System.out.println(ans);
    }

    public static void main(String args[])
    {
        input();
        pro();

    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
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

        String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch(IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }
}
