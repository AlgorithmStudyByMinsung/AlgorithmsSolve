package twoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Four_my {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();


    static int N;
    static int[] a;
    static void input() {
        N = scan.nextInt();
        a = new int[N +1];

        for (int i = 1; i <= N ; i++) {
            a[i] = scan.nextInt();
        }
    }
    static boolean binarySearch(int x , int del) {
        int L =1; int R = N;
        int temp = a[del];
        a[del] = Integer.MAX_VALUE;

        while (L <=R) {
            int mid = (L +R)/2;

            if (a[mid] > x) {
                R -=1;
            } else if (a[mid] == x) {
                a[del] = temp;
                return true;
            } else {
                L +=1;
            }
        }
        a[del] = temp;
        return false;
    }
    static void pro() {
        int ans = 0;
        for (int i = 1; i <= N ; i++) {
            int current = a[i];
            boolean available = false;

            for (int j = 1; j <= N ; j++) {
                int target = a[i] - a[j];
                if (binarySearch(target, j)) {
                    available = true;
                    break;
                }

            }
            if (available) ans +=1;

        }
        System.out.println(ans);
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
