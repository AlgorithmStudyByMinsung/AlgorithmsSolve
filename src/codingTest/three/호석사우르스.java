package codingTest.three;
// https://www.acmicpc.net/problem/22255
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 다익스트라는 모든 곳에서의 최단거리가 구해진다.
 * */
// 아직 답변 못들음
public class 호석사우르스 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Info {
        public int x;
        public int y;
        public int dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int N;
    static int M;
    static int sx;
    static int sy;
    static int ex;
    static int ey;
    static int a[][];
    static int weight[][];
    static int[][] d;

    static int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        sx = scan.nextInt();
        sy = scan.nextInt();
        ex = scan.nextInt();
        ey = scan.nextInt();

        a = new int[N + 1][M + 1];
        d = new int[N + 1][M + 1];
        weight = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                a[i][j] = scan.nextInt();
                weight[i][j] = Integer.MAX_VALUE;
                d[i][j] = -1;
            }
        }
    }

    static void dijkstra() {
        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        queue.add(new Info(sx,sy, 0));
        weight[sx][sy] = 0;
        d[sx][sy] = 1;

        while (! queue.isEmpty()) {
            Info x = queue.poll();

            if (x.dist != weight[x.x][x.y]) continue;

            for (int i = 0; i < 4; i++) {
                if (((d[x.x][x.y]) % 3) == 1) {
                    if (i == 2 || i == 3) continue;
                } else if (((d[x.x][x.y]) % 3) == 2) {
                    if (i == 0 || i == 1) continue;
                }
                int nx = x.x + dir[i][0];
                int ny = x.y + dir[i][1];

                if (nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if (a[nx][ny] == -1) continue;

                if (weight[x.x][x.y] + a[nx][ny] >= weight[nx][ny]) continue;

                    weight[nx][ny] = weight[x.x][x.y] + a[nx][ny];
                    d[nx][ny] = d[x.x][x.y] + 1;
                    queue.add(new Info(nx , ny, weight[nx][ny]));
            }
        }

        if (weight[ex][ey] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(weight[ex][ey]);
    }



    public static void main(String[] args) {
        input();
        dijkstra();
        for (int[] ints : weight) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(' ');
            }
            System.out.println();
        }

        System.out.println();

        for (int[] ints : d) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(' ');
            }
            System.out.println();
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
