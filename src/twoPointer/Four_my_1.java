package twoPointer;

import java.util.*;
import java.io.*;


public class Four_my_1
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] a;

    static void input() {
        N = scan.nextInt();
        a = new int[N + 1];

        for(int i = 1;i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static boolean twoPointer(int x) {
        int L = 1; int R = N;

        while(L < R) {
            if(L == x) L += 1;
            else if(R == x) R -= 1;

            if(L == R) continue;

            long sum = (a[L] + a[R]);

            if(sum < a[x]) {
                L += 1;
            } else if(sum > a[x]) {
                R -= 1;
            } else {
                return true;
            }
        }

        return false;
    }

    static void pro() {
        Arrays.sort(a, 1, N + 1);

        int ans = 0;

        for(int i = 1; i<= N; i++) {
            if(twoPointer(i)) {
                ans ++;
            }
        }

        System.out.println(ans);
    }


    public static void main(String args[])
    {
        input();
        pro();
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
                } catch (IOException e) {
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
            } catch(IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}