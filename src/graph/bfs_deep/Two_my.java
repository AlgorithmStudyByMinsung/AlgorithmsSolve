package graph.bfs_deep;
// https://www.acmicpc.net/problem/1697
import java.io.*;
import java.util.*;

public class Two_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int K;
    static int[] dist;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();

        dist = new int[100001];
        visit = new boolean[100001];
    }
    static List<Integer> children(int x) {
        List<Integer> arrayList = new ArrayList<>();

        if (x -1 >= 0 && x -1 <= 100000) arrayList.add(x -1);
        if (x +1 >= 0 && x +1 <= 100000) arrayList.add(x +1);
        if (2*x >= 0 && 2*x <= 100000) arrayList.add(2*x);

        return arrayList;
    }
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        visit[N] = true;

        boolean check = false;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();

            for (Integer child : children(x)) {

                if (visit[child]) continue;

                queue.add(child);
                visit[child] = true;
                dist[child] = dist[x] +1;

                if (child == K) {
                    check = true; break;
                }

//                sb.append("dist = ").append(dist[child]).append(' ').append("child = ").append(' ').append(child).append('\n');
            }
            if (check) break;
        }

    }

    public static void main(String[] args) {
        input();
        bfs();
//        System.out.println(sb);
        System.out.println(dist[K]);
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
