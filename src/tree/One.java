package tree;
// https://www.acmicpc.net/problem/11725
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 트리 = 사이클이 존재하지 않음
 * 특성 : 사이클 X == 하나의 정점에 inDegree 가 하나다
 *              == 따라서 자식들만 저장해도 모두 탐색을 할 수 있다.
 *              == 왜냐면 inDegree 가 여러개(사이클이 존재 할 수 있다.)
 *              == 여러개면 visit check 를 해줘야 한다.
 *              == 부모만 잘 설정해준다면 visit 을 안해도 된다.
 *
 * 결론: 트리는 visit 배열 필요가 없고 자식노드만 저장하면 된다.
 * */
/**
 * 트리의 조상 찾는 문제이다.
 * */
/**
 * tree 는 dfs
 * */
public class One {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parents;
    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N +1];
        parents = new int[N +1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }

    }
    static void dfs(int x, int par) {
        parents[x] = par;

        for (Integer integer : adj[x]) {
            if (integer == par) continue;

            dfs(integer, x);
        }
    }

    public static void main(String[] args) {
        input();
        dfs(1, -1);

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
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
