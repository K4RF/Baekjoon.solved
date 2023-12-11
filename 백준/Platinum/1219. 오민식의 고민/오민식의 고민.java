
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, sCity, eCity;
    static long distance[], cityMoney[];
    static Edges Edgess[];

    public static void main(String[] args)throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Edgess = new Edges[M];
        distance = new long[N];
        cityMoney = new long[N];
        Arrays.fill(distance, Long.MIN_VALUE);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            Edgess[i] = new Edges(start, end, price);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cityMoney[i] = Long.parseLong(st.nextToken());
        }

        distance[sCity] = cityMoney[sCity];

        for(int i = 0; i <= N + 100; i++){
            for(int j = 0; j < M; j++){
                int start = Edgess[j].start;
                int end = Edgess[j].end;
                int price = Edgess[j].price;

                if(distance[start] == Long.MIN_VALUE) continue;
                else if(distance[start] == Long.MAX_VALUE) distance[end] = Long.MAX_VALUE;
                else if(distance[end] < distance[start] + cityMoney[end] - price){
                    distance[end] = distance[start] + cityMoney[end] - price;
                    if(i >= N - 1) distance[end] = Long.MAX_VALUE;
                }
            }
        }
        if(distance[eCity] == Long.MIN_VALUE) System.out.println("gg");
        else if(distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[eCity]);
    }
}

class Edges{
    int start, end, price;
    public Edges(int start, int end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
}