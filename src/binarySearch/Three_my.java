package binarySearch;
// https://www.acmicpc.net/problem/1920
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Three_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;
    static int M;
    static int[] b;

    static void input() {
        N = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }

        M = scan.nextInt();
        b = new int[M];
        for (int i = 0; i < M; i++) {
            b[i] = scan.nextInt();
        }
    }

    static void binarySearch(int L, int R, int x) {
        int res = 0;

        while (L <= R) {
            int mid = (L +R)/2;
            if (a[mid] < x) {
                L = mid +1;
            } else if (a[mid] > x) {
                R = mid -1;
            } else {
                res = 1;
                break;
            }
        }
        System.out.println(res);
    }
    static void pro() {
        Arrays.sort(a);

        for (int i = 0; i < M; i++) {
            binarySearch(0, a.length -1, b[i]);
        }
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
