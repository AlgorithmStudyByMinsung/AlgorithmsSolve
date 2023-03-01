package twoPointer;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// v.get(a.charAt(R)) == null || v.get(a.charAt(R)) == 0
/**
 * 해쉬 맵으로 풀 때 0이거나 null 이거나 이렇게 해줘야 갯수 check 가 된다.
 * */

public class Five_my_3
{
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String a;
    static HashMap<Character, Integer> v = new HashMap<>();

    static void input() {
        N = scan.nextInt();
        a = scan.next();
    }

    static void twoPointer() {
        int R = 0;
        int ans = Integer.MIN_VALUE;
        int cnt = 0;

        for(int L = 0; L < a.length(); L ++) {

            while(R < a.length() && cnt <= N) {
                if(v.get(a.charAt(R)) == null || v.get(a.charAt(R)) == 0) {
                    if(cnt == N){
                        break;
                    }
                    v.put(a.charAt(R), 1);
                    cnt ++;
                } else {
                    v.put(a.charAt(R), v.get(a.charAt(R)) + 1);
                }
                R ++;
            }
            ans = Math.max(ans, R - L);

            int num = v.get(a.charAt(L)) - 1;
            v.put(a.charAt(L) , num);

            if(num == 0) cnt --;

        }

        System.out.println(ans);
    }

    public static void main(String args[])
    {
        input();
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
