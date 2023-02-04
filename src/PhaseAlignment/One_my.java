package PhaseAlignment;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 위상 정렬
 * - 트리의 정렬 --> 트리에서 정렬한다면 위상 정렬을 생각해봐야한다.
 *            --> 트리에서의 순서
 * - inDegree 가 핵심
 *
 **/
public class One_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static ArrayList<Integer>[] adj;
    /**
     * 위상 정렬은 visit 이 안필요하다.
     * bfs : 자식 중에 방문안한 걸 queue 에 집어넣는다.
     * 위상정렬 : 자식 중에 inDegree 가 0인 애를 집어넣는다. --> 이렇게 해도 순회가 가능
     **/
    static boolean[] visit;
    static int[] inDegree;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        /**
         * N +1 일 시에 0이 없어서 null 이 뜰 수도 있다.
         **/
        adj = new ArrayList[N +1];
        visit = new boolean[N +1];
        inDegree = new int[N +1];

        for (int i = 1; i <= N ; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            inDegree[y] ++;

            adj[x].add(y); adj[y].add(x);
        }

    }
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // init
        /**
         * iter 은 코테에서는 안좋음
         **/
        for (int i = 1; i <= N ; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // bfs
        while (! queue.isEmpty()) {
            Integer x = queue.poll();
            sb.append(x).append(' ');

            for (Integer integer : adj[x]) {
                inDegree[integer] --;

                if (inDegree[integer] == 0) queue.add(integer);
            }

        }



    }
    public static void main(String[] args) {
        input();
        bfs();

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
