package kruskal;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 곡예비행 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge implements Comparable<Edge>{
        public int nodeA;
        public int nodeB;
        public int weight;

        public Edge(int nodeA, int nodeB, int weight) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int N;
    static int M;
    static ArrayList<Edge> adj;
    static int[] par;
    static long result;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        adj = new ArrayList<>();
        par = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            par[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            int nodeA = scan.nextInt();
            int nodeB = scan.nextInt();
            int weight = scan.nextInt();

            adj.add(new Edge(nodeA, nodeB, weight));
            result += weight;
        }
    }
    static void kruskal() {
        Collections.sort(adj);

        int cnt = 0;
        for (Edge edge : adj) {
            if (union(edge.nodeA , edge.nodeB)) {
                result -= edge.weight;
                cnt ++;
            }
        }

        if (cnt != N - 1) System.out.println("-1");
        else System.out.println(result);
    }
    static int find(int x) {
        if (par[x] < 0) return x;

        return par[x] = find(par[x]);
    }

    static boolean union(int a , int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return false;

        par[B] = A;
        return true;
    }

    public static void main(String[] args) {
        input();
        kruskal();
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
