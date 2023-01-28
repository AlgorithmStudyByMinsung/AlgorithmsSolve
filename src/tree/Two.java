package tree;
// https://www.acmicpc.net/problem/1068
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Two {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int root; // 루트 노드
    static int erased; // 지우는 노드
    /**
     * 자식 노드만 저장
     *
     * 이유: 자식부터 보면 된다.
     * 특징 : 시작점을 루트 노드로 안한다면   **부모를 탐색 할 수 없음**
     **/
    static ArrayList<Integer>[] child;// 인접 리스트 처럼 부모까지 저장을 하지 않는다.
    // 내 생각엔 어차피 트리는 루트노드가 존재하며 루트노드로 부터 내려가기 때문인거 같다.

    static void input() {
        N = scan.nextInt();
        child = new ArrayList[N];

        // 항상 초기화
        for (int i = 0; i < N; i++) child[i] = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            int par = scan.nextInt();

            if (par == -1) {
                root = i;
                continue;
            }
            // 자식에만 넣어준다.
            child[par].add(i);
        }
        erased = scan.nextInt();
    }

    static int dfs(int x) {
        if (child[x].size() == 0) return 1;

        int leaf_sum = 0;

        // 자식 노드의  리프 노드의 합 = 현재 노드의 리프 노드의 합
        for (Integer integer : child[x]) {
            leaf_sum += dfs(integer);
        }
        return leaf_sum;
    }

    static void pro() {
        // 지워야 할 노드의 자식 까지 다 지울 필요없다.
        // 해당 노드만 지운다면 더 이상 탐색을 못한다.
        for (int i = 0; i < N; i++) child[i].removeIf(integer -> integer == erased);

        /**
         * 이런 예외 처리를 꼭 해줘야 한다.
         **/
        if (root != erased) System.out.println(dfs(root));
        else System.out.println(0);
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
