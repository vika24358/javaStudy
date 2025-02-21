package homework5;

public class Main {
    public static void main(String[] args) {
        int[] arExample1 = {3, 2, 8, 1, 0, 5, 4, 6, 7};
        insertSort(arExample1);
        printMassive(arExample1);

        System.out.println();

        int[] arExample2 = {3, 2, 8, 1, 0, 5, 4, 6, 7};
        bubbleSort(arExample2);
        printMassive(arExample2);

        System.out.println();

        int[] arExample3 = {3, 2, 8, 1, 0, 5, 4, 6, 7};

        selectSort(arExample3);
        printMassive(arExample3);

        System.out.println();
    }

    public static void insertSort(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int num = ar[i];
            int j = i - 1;
            while (j > -1 && ar[j] > num) {
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = num;
        }
    }

    public static void bubbleSort(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    int num = ar[j + 1];
                    ar[j + 1] = ar[j];
                    ar[j] = num;
                }
            }
        }
    }

    public static void selectSort(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            int k = i;
            int x = ar[i];
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j] < x) {
                    k = j;
                    x = ar[j];
                }
            }
            ar[k] = ar[i];
            ar[i] = x;
        }
    }

    public static void printMassive(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }
}

