package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static Integer N2_CheapestWay(String[] stringNumbers) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stringNumbers[0]);
        int m = Integer.parseInt(stringNumbers[1]);

        int[][] massive = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] rowNumbers = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                massive[i][j] = Integer.parseInt(rowNumbers[j]);
            }
        }

        int[][] eps = new int[n][m];
        eps[0][0] = massive[0][0];
        for (int i = 1; i < n; i++) {
            eps[i][0] = eps[i - 1][0] + massive[i][0];
        }
        for (int i = 1; i < m; i++) {
            eps[0][i] = eps[0][i - 1] + massive[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                eps[i][j] = Math.min(eps[i][j - 1], eps[i - 1][j]) + massive[i][j];
            }
        }


        System.out.println("Элементы массива:");
        for (int[] row : massive) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }


        return eps[n - 1][m - 1];
    }




}
