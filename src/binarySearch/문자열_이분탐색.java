package binarySearch;
// https://www.acmicpc.net/problem/1764
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * String 이나 Char 도 사전 순으로 정렬이 된다.
 *
 * 비교시에는 compareTo 를 사용하면 된다.
 **/
public class 문자열_이분탐색 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int M;
    static String[] a;
    static String[] b;
    static ArrayList<String> ans = new ArrayList<>();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        a = new String[N];
        b = new String[M];

        for (int i = 0; i < N; i++) a[i] = scan.nextLine();
        for (int i = 0; i < M; i++) b[i] = scan.nextLine();
    }

    static boolean binarySearch(int L, int R, String x) {
        boolean res = false;

        while (L <= R) {
            int mid = (L + R)/ 2;
            if (b[mid].compareTo(x) < 0) {
                L = mid + 1;
            } else if (b[mid].compareTo(x) > 0) {
                R = mid - 1;
            } else {
                res = true;
                break;
            }
        }

        return res;
    }

    static void pro() {
        Arrays.sort(b);
        Arrays.sort(a);

        for (int i = 0; i < N; i++) {
            boolean available = binarySearch(0, M - 1, a[i]);

            if (available) ans.add(a[i]);
        }

        sb.append(ans.size()).append('\n');

        for (String an : ans) sb.append(an).append('\n');

        System.out.println(sb);
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
