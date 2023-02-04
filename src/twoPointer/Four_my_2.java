package twoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Four_my_2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        a = new int[N];

        for (int i = 0; i < N; i++) a[i] = scan.nextInt();
    }

    static void twoPointer() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int L = 0;
            int R = N -1;

            while (L < R) {
                /**
                 * 여기가 잘 못됨
                 * 모두 if/ else 로 묶어줘야 함
                 * */
                if (L == i) L +=1;
                if (R == i) R -=1;

                int sum = a[L] + a[R];

                if (sum < a[i]) {
                    L += 1;
                } else if (sum > a[i]) {
                    R -= 1;
                } else {
                    System.out.println(i);
                    ans += 1;
                    break;
                }
            }

        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(a);
        twoPointer();
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
