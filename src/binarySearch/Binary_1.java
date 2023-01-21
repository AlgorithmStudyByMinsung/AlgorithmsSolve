package binarySearch;
// https://www.acmicpc.net/problem/7795
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Binary_1 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int t;
    static int n;
    static int m;
    static int[] a;
    static int[] b;

    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();

        a = new int[n +1];
        b = new int[m +1];

        for (int i = 1; i <=n ; i++) a[i] = scan.nextInt();
        for (int i = 1; i <=m ; i++) b[i] = scan.nextInt();
    }

    static int binarySearch(int[]b, int L, int R, int X) {
        int res = L -1;
        while (L <= R) {
            int mid = (L + R)/2;

            if (b[mid] < X) {
                res = mid;
                L = mid +1;
            }else {
                R = mid -1;
            }
        }
        return res;
    }

    static void pro(){
        Arrays.sort(b, 1, m+1);

        int ans = 0;

        for (int i = 1; i <= n; i++) ans += binarySearch(b, 1, m, a[i]);
        System.out.println(ans);
    }



    public static void main(String[] args) {
        t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            input();
            pro();
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
