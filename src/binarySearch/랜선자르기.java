package binarySearch;
// https://www.acmicpc.net/problem/1654
import java.util.*;
import java.io.*;
/**
 * 2의 31 - 1 이 Integer.MAX_VALUE 이다.
 * 따라서 1이라도 넘어서면 안된다
 * long 으로 설정을 해줘야한다.
 * */

public class 랜선자르기
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N; // 이미 가지고 있는 렌선
    static int k; // 필요한 렌선의 수
    static int[] a;

    static void input() {
        N = scan.nextInt();
        k = scan.nextInt();

        a = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }

    static boolean greedy(long x) {
        int cnt = 0;
        for(int i = 1; i <= N; i ++) {
            int length = a[i];

            while(length > 0) {
                length -= x;

                if(length >= 0) {
                    cnt += 1;
                }
            }
        }

        if(cnt >= k) return true;
        return false;
    }

    static long binarySearch() {
        long L = 1; long R = Integer.MAX_VALUE;
        long res = 0;

        while(L <= R) {
            long mid = (L + R) /2;

            if(greedy(mid)) {
                L = mid + 1;
                res = mid;
            } else {
                R = mid - 1;
            }
        }

        return res;
    }

    static void pro() {
        System.out.println(binarySearch());
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

        public String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public String nextLine() {
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
