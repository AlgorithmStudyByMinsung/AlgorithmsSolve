package codingTest.three;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 정답 탐색 + greedy + 우선순위 큐
 *
 * - 정답 탐색 : 최대 값중 최솟 값을 찾는 전형적인 정답 탐색의 case
 * - 실수 : 정답의 최대치를 10의 9승으로 설정
 *          하지만 10만이면 된다.!! 문제의 주어진 것이 아니라 파악해서 설정을 해야한다.
 * */
public class 공정컨설턴트호석 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Node {
        public int idx;
        public long weight;

        public Node(int idx, long weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N;
    static int X;
    static int[] a;
    static int MOD = 100000;
    static PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o.weight));

    static void input() {
        N = scan.nextInt();
        X = scan.nextInt();

        a = new int[N + 1];

        for (int i = 1; i <= N; i++) a[i] = scan.nextInt();
    }

    static boolean greedy(int k) {
        /**
         * 시간 복잡도 : N 번을 우선순위 큐에 삽입 삭제 이므로 N logN
         * */
        queue.clear();

        for (int i = 1; i <= k; i++) {
            queue.add(new Node(i , 0));
        }
        for (int i = 1; i <= N; i++) {
            Node node = queue.poll();
            if (node.weight + a[i] > X) return false;

            queue.add(new Node(node.idx ,node.weight + a[i]));
        }
        return true;
    }

    static void binarySearch() {
        int L = 1; int R = MOD;
        int res = -1;
        while (L <= R) {
            int mid = (L + R) / 2;

            if (greedy(mid)) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(res);
    }


    public static void main(String[] args) {
        input();
        binarySearch();
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
