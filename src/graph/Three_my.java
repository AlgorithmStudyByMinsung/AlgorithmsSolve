package graph;
// https://www.acmicpc.net/problem/2251
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 어찌 보면 브루트 포스와 유사
 * 하지만 브루트 포스는 모든 것을 다 간다면
 * 이건 자식들만 간다.
 * 자식 == 갈 수 있는 경우의 수
 * 
 * */
public class Three_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int limit[] = new int[4];
    static boolean visit[][][] = new boolean[201][201][201];
    static List<Integer> ans = new ArrayList<>();

    static void input() {
        for (int i = 1; i <=3 ; i++) {
            limit[i] = scan.nextInt();
        }
    }

    static class State {
        int[] x;

        public State(int[] x) {
            this.x = x;
        }

        State move(int from, int to) {
            int state[] = new int[]{0 ,x[1], x[2], x[3]};

            if (x[from] + x[to] > limit[to]) {
                state[to] = limit[to];
                state[from] = x[from] - limit[to] + x[to];
            } else {
                state[to] = x[to] + state[from];
                state[from] = 0;
            }
            return new State(state);
        }
    }

    static void dfs(State state) {
        visit[state.x[1]][state.x[2]][state.x[3]] = true;

        if (state.x[1] == 0) ans.add(state.x[3]);

        for (int i = 1; i <=3 ; i++) {
            for (int j = 1; j <=3 ; j++) {
                if (i == j) continue;
                State move = state.move(i, j);

                if (visit[move.x[1]][move.x[2]][move.x[3]]) continue;

//                sb.append(move.x[1]).append(' ').append(move.x[2]).append(' ').append(move.x[3]).append('\n');
                dfs(move);
            }
        }


    }
    public static void main(String[] args) {
        input();
        dfs(new State(new int[]{0, 0, 0, limit[3]}));
//        System.out.println(sb);
        Collections.sort(ans);
        for (Integer an : ans) {
            sb.append(an).append(' ');
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
