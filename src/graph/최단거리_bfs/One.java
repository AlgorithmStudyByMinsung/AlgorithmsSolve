package graph.최단거리_bfs;
// https://www.acmicpc.net/problem/2178
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 가중치가 1인 최단거리
 *
 * - bfs 와 dist
 **/
public class One {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static String[] a;
    static boolean visited[][];
    static int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int dist[][];

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        dist = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            a[i] = scan.next();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }


    }
    static void bfs() {
        Queue<Integer> queue = new LinkedList();

        queue.add(0);
        queue.add(0);
        visited[0][0] = true;
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();
//            sb.append(x).append(' ').append(y).append('\n');

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (a[nx].charAt(ny) == '0') continue;

                queue.add(nx); queue.add(ny);

                dist[nx][ny] = dist[x][y] +1;
                visited[nx][ny] = true;
            }
        }

    }
    public static void main(String[] args) {
        input();
        bfs();
//        System.out.println(sb);
        System.out.println(dist[N -1][M -1]);
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
