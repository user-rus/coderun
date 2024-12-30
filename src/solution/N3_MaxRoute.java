package solution;

/*В левом верхнем углу прямоугольной таблицы размером N×M находится черепашка.
В каждой клетке таблицы записано некоторое число.
Черепашка может перемещаться вправо или вниз,
при этом маршрут черепашки заканчивается в правом нижнем углу таблицы.

Подсчитаем сумму чисел, записанных в клетках, через которую проползла черепашка
(включая начальную и конечную клетку). Найдите наибольшее возможное значение этой суммы и маршрут,
на котором достигается эта сумма.

Формат ввода
В первой строке входных данных записаны два натуральных числа N и M,
не превосходящих 100 — размеры таблицы. Далее идет N строк, каждая из которых содержит M чисел,
разделенных пробелами — описание таблицы. Все числа в клетках таблицы целые
и могут принимать значения от 0 до 100.

Формат вывода
Первая строка выходных данных содержит максимальную возможную сумму,
вторая — маршрут, на котором достигается эта сумма. Маршрут выводится в виде последовательности,
которая должна содержать N-1 букву D, означающую передвижение вниз и M-1 букву R,
означающую передвижение направо. Если таких последовательностей несколько,
необходимо вывести ровно одну (любую) из них.*/

import java.io.*;

public class N3_MaxRoute {
    public static void max_route() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] stringNumbers = reader.readLine().split(" ");
        int n = Integer.parseInt(stringNumbers[0]);
        int m = Integer.parseInt(stringNumbers[1]);
        int[][] massive = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] rowNumbers = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                massive[i][j] = Integer.parseInt(rowNumbers[j]);
            }
        }
        char[][] direction = new char[n][m];

        int[][] eps = new int[n][m];
        eps[0][0] = massive[0][0];
        for (int i = 1; i < n; i++) {
            eps[i][0] = eps[i - 1][0] + massive[i][0];
            direction[i][0]='D';
        }
        for (int i = 1; i < m; i++) {
            eps[0][i] = eps[0][i - 1] + massive[0][i];
            direction[0][i]='R';
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (eps[i][j - 1] > eps[i - 1][j]) {
                    eps[i][j] = eps[i][j - 1] + massive[i][j];
                    direction[i][j] = 'R'; // Движение вправо
                } else {
                    eps[i][j] = eps[i - 1][j] + massive[i][j];
                    direction[i][j] = 'D'; // Движение вниз
                }
            }
        }

        System.out.println("Элементы массива:");
        for (int[] row : eps) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        for (char[] row : direction) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        writer.write((eps[n - 1][m - 1]) + "\n");
        StringBuilder path = new StringBuilder();
        int i = n - 1, j = m - 1;
        while (i > 0 || j > 0) {
            if (direction[i][j] == 'D') {
                path.append('D');
                i--; // Двигаемся вверх
            } else {
                path.append('R');
                j--; // Двигаемся влево
            }
        }
        writer.write(path.reverse() + "\n");
        reader.close();
        writer.close();

    }
}
