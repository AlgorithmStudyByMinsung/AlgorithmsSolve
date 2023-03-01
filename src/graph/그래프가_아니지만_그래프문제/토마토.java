package graph.그래프가_아니지만_그래프문제;

import java.util.*;
import java.io.*;


public class 토마토
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;

    static int[][] a;
    static int[][] dist;
    static int[][] dir = new int[][] {{1 , 0}, {-1 , 0}, {0 , 1}, {0 , -1}};

    static boolean[][] visit;

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();

        a = new int[N][M];
        dist = new int[N][M];

        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j ++) {
                a[i][j] = scan.nextInt();
            }
        }
    }

    static void multiSourceBfs() {
        Queue<Integer> queue= new LinkedList<>();
        // init
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j ++) {
                if(a[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);

                    visit[i][j] = true;
                }
            }
        }

        while(! queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for(int i = 0; i< 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];

                if(dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
                if(visit[dx][dy]) continue;


                if(a[dx][dy] == 0) {
                    visit[dx][dy] = true;
                    dist[dx][dy] = dist[x][y] + 1;

                    queue.add(dx);
                    queue.add(dy);

                }
            }
        }
    }

    static void check() {
        int ans_one = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j ++) {
                if(a[i][j] == 0) {
                    ans_one ++;
                }
            }
        }
        if(ans_one == 0) {
            System.out.println(ans_one);
            System.out.close();
        }

        int max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j ++) {
                if(a[i][j] != 0) continue;

                if(! visit[i][j]) {
                    System.out.println("-1");
                    System.out.close();
                }

                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max);
    }

    public static void main(String args[])
    {
        input();
        multiSourceBfs();
        check();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
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
