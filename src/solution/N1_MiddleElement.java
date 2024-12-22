package solution;


public class N1_MiddleElement {
    public static Integer middleElement(String[] stringNumbers) {
        int[] ints = new int[stringNumbers.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(stringNumbers[i]);
        }
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (i == j) continue;
                if (ints[i] < ints[j]) {
                    max = ints[j];
                    ints[j] = ints[i];
                    ints[i] = max;
                }
            }
        }
        return ints[1];
    }
}
