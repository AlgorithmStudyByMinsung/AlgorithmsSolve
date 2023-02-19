package facemTest.my;
// https://www.acmicpc.net/problem/21923
import java.io.*;
import java.util.*;
/**
 * 다익스트라는 음수간선이 없고 최단거리일 때만 적용하자
 * */
public class 곡예비행_wrong {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Info {
        public int x;
        public int y;
        public int score;

        public Info(int x, int y, int score) {
            this.x = x;
            this.y = y;
            this.score = score;
        }
    }

    static int N;
    static int M;
    static int[][] a;
    static int[][] ds;
    static int[][] de;
    static int MOD = 1000;
    static int[][] dir_s = new int[][] {{-1 , 0}, {0 , 1}};
    static int[][] dir_e = new int[][] {{-1 , 0}, {0 , -1}};


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        a = new int[MOD + 1][MOD + 1];
        ds = new int[MOD + 1][MOD + 1];
        de = new int[MOD + 1][MOD + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                a[i][j] = scan.nextInt();
                ds[i][j] = Integer.MIN_VALUE;
                de[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    static void dijkstra_start() {
        PriorityQueue<Info> queue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o2.score - o1.score;
            }
        });

        int sx = N; int sy = 1;

        queue.add(new Info(sx , sy, a[sx][sy]));
        ds[sx][sy] = a[sx][sy];

        while (! queue.isEmpty()) {
            Info info = queue.poll();

            if (info.score != ds[info.x][info.y]) continue;

            for (int i = 0; i < 2; i++) {
                int dx = info.x + dir_s[i][0];
                int dy = info.y + dir_s[i][1];

                if (dx >= 1 && dx <= N && dy >= 1 && dy <= M) {
                    if (ds[dx][dy] >= ds[info.x][info.y] + a[dx][dy]) continue;

                    ds[dx][dy] = ds[info.x][info.y] + a[dx][dy];
                    queue.add(new Info(dx, dy , ds[dx][dy]));
                }
            }
        }
    }

    static void dijkstra_end() {
        PriorityQueue<Info> queue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o2.score - o1.score;
            }
        });

        int sx = N; int sy = M;

        queue.add(new Info(sx , sy, a[sx][sy]));
        de[sx][sy] = a[sx][sy];

        while (! queue.isEmpty()) {
            Info info = queue.poll();

            if (info.score != de[info.x][info.y]) continue;

            for (int i = 0; i < 2; i++) {
                int dx = info.x + dir_e[i][0];
                int dy = info.y + dir_e[i][1];

                if (dx >= 1 && dx <= N && dy >= 1 && dy <= M) {
                    if (de[dx][dy] >= de[info.x][info.y] + a[dx][dy]) continue;

                    de[dx][dy] = de[info.x][info.y] + a[dx][dy];
                    queue.add(new Info(dx, dy , de[dx][dy]));
                }
            }
        }
    }
    static void pro() {
        dijkstra_start();
        dijkstra_end();

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                max = Math.max(de[i][j] + ds[i][j], max);
            }
        }

        System.out.println(max);
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

