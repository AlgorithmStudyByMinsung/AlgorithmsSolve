package binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class Binary_2_my_2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;
    static int[] selected =new int[2];

    static void input() {
        N = scan.nextInt();
        a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static int[] ans = new int[2];
    static void pro(int index, int cnt){
        if (cnt==2) {
            if (Math.abs(selected[0] + selected[1]) < Math.abs(ans[0] +ans[1])) {
                ans[0] = selected[0];
                ans[1] = selected[1];
            }
            return;
        }
        if (index == N) return;



        selected[cnt] = a[index];
        pro(index +1, cnt +1);
        selected[cnt] = 0;

        pro(index+1, cnt);
    }

    public static void main(String[] args) {
        input();

        ans[0] = 0;
        ans[1] = Integer.MAX_VALUE;

        pro(0, 0);

        for (Integer an : ans) {
            sb.append(an).append(' ');
        }

        System.out.println(sb);
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
