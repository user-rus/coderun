import solution.N1_MiddleElement;
import solution.N2_CheapestWay;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(
                N2_CheapestWay.cheapest(reader.readLine().split(" "))));
        reader.close();
        writer.close();
    }
}
