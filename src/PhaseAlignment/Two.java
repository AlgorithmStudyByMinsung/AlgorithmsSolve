package PhaseAlignment;

import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/1005
/**
 * 1. 순서 규칙이 있다! --> 위상정렬
 * 2. 위상정렬의 특징
 *      - 순서대로 큐에 담긴다.
 *      - 순서대로 진행이 된다.
 *      - 순서와 그 외로 로직을 짜면 된다.
 * */
public class Two
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int K;
    static int[] a;
    static int W;

    static ArrayList<Integer>[] adj;
    static int[] indegree;
    /**
     * 한번에 하지말고 이렇게 각각에 대한 최소시간을 구한다라고 보자
     * 그래서 마지막 ans[마지막] 이 정답
     * */
    static int[] ans;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();

        a = new int[N + 1];
        ans = new int[N + 1];
        adj = new ArrayList[N + 1];
        indegree = new int[N + 1];

        for(int i = 1; i<= N ;i ++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }

        for(int i = 0; i< K; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            adj[u].add(v);
            indegree[v] ++;
        }
        W = scan.nextInt();
    }

    static void pro() {

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<= N; i ++) {
            if(indegree[i] == 0) {
                queue.add(i);
                ans[i] = a[i];
            }
        }

        while(! queue.isEmpty()) {
            int x = queue.poll();

            int res = Integer.MIN_VALUE;
            for(int y : adj[x]) {
                indegree[y] --;

                if(indegree[y] == 0) queue.add(y);

                /**
                 * 순서와 별한
                 * */
                ans[y] = Math.max(ans[y], a[y] + ans[x]);
            }
        }
    }

    public static void main(String args[])
    {
        int T = scan.nextInt();

        for(int i = 0; i< T; i++) {
            input();
            pro();
            System.out.println(ans[W]);
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || ! st.hasMoreElements()) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }
}
