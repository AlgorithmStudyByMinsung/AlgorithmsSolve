package codingTest.two;
// https://www.acmicpc.net/problem/21276
// 시간 : 52분 점수 : 17/19
import java.io.*;
import java.util.*;
/**
 * 그래프 + 순서
 * 위상정렬
 * */
public class 계보복원가호석 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Ans implements Comparable<Ans>{
        public String jo;
        public int cnt;
        public List<String> child = new ArrayList<>();

        @Override
        public int compareTo(Ans o) {
            Collections.sort(child);

            return this.jo.compareTo(o.jo);
        }
    }

    static int N;
    static int M;
    static Map<String , Integer> people = new HashMap<>();
    static Map<Integer , String> people_idx = new HashMap<>();
    static ArrayList<String>[] adj;
    static int[] inDegree;
    /**
     * 객체 배열도 초기화를 다 해주어야 한다.
     * */
    static Ans[] ans;
    static int ansCnt;
    static List<String> ansJo = new ArrayList<>();

    static void input() {
        N = scan.nextInt();

        inDegree = new int[N + 1];
        ans = new Ans[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= N ; i++) ans[i] = new Ans();



        for (int i = 1; i <= N ; i++) {
            String name = scan.next();
            people.put(name, i);
            people_idx.put(i, name);
        }

        M = scan.nextInt();

        for (int i = 0; i < M; i++) {
            String child = scan.next();
            String jo = scan.next();

            adj[people.get(jo)].add(child);
            inDegree[people.get(child)] ++;
        }
    }

    static void pro() {
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 위상정렬은 시작점이 여려개일 수가 있다.
         * 즉 트리가 여러개 나올 수가 있다.
         * */
        for (int i = 1; i <= N ; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                ansCnt ++;
                ansJo.add(people_idx.get(i));
            }
        }

        while (! queue.isEmpty()) {
            Integer x = queue.poll();
            ans[x].jo = people_idx.get(x);

            for (String child : adj[x]) {
                inDegree[people.get(child)] --;

                if (inDegree[people.get(child)] == 0) {
                    queue.add(people.get(child));

                    ans[x].child.add(child);
                    ans[x].cnt ++;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();

        System.out.println(ansCnt);
        Collections.sort(ansJo);
        for (String s : ansJo) {
            sb.append(s).append(' ');
        }
        sb.append('\n');

        Arrays.sort(ans, 1, N + 1);

        for (int i = 1; i <= N ; i++) {
            sb.append(ans[i].jo).append(' ');
            sb.append(ans[i].cnt).append(' ');

            for (String s : ans[i].child) {
                sb.append(s).append(' ');
            }
            sb.append('\n');
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
