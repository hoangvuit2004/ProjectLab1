import java.util.Arrays;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }
    public  int[] mirror() {
        int j = 0;
        if(array.length <= 0){
            return null;
        }
        int newArray[] = new int[array.length*2];
        for (int i = 0; i <array.length ; i++) {
            newArray[j] = array[i];
            j++;
        }
        for (int i = array.length-1; i >= 0  ; i--) {
            newArray[j] = array[i];
            j++;
        }
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    public static void main(String[] args) {

        int[] inputArray  = {10, 11, 12, 1, 14, 10, 17, 19, 20};
        int k = 3;
        MyArray ar = new MyArray(inputArray);
        ar.fillMissingValues(k);

    }
    public int[] removeDuplicates() {
        int lenght = array.length;
        int count = 0;
        boolean check[] = new boolean[array.length];
        if(array.length <= 0 ){
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j] && !check[j]) {
                    count++;
                    check[j] = true;
                }
            }
        }
        int[] newArray = new int[array.length - count];
        int newIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (!check[i]) {
                newArray[newIndex] = array[i];
                newIndex++;
            }
        }


        System.out.println(Arrays.toString(newArray));
        return newArray;
    }
    public int[] getMissingValues() {

        int countValue = 0;
        if(array.length <= 0 ){
            return null;
        }
        int newArray[] = new int[array.length];
        newArray = array.clone();
        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(newArray[i] >newArray[j]){
                    int temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j]  =temp;
                }
            }
        }
        int min = newArray[0];
        int max = newArray[array.length-1];
        boolean[] check = new boolean[max - min + 1];

        // Mark the values that exist in the input array
        for (int num : array) {
            check[num - min] = true;
        }


        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] > 1) {
                countValue += array[i] - array[i - 1] - 1;
            }
        }

        int[] newArrayMissValues = new int[countValue];
        int index = 0;
        for (int i = min + 1; i < max; i++) {
            if (!check[i - min]) {
                newArrayMissValues[index] = i;
                index++;
            }
        }
        System.out.println(Arrays.toString(newArrayMissValues));
        return newArrayMissValues;

    }
    public int[] fillMissingValues(int k) {
        if (array.length <= 0 || k <= 0) {
            return null;
        }
        int[] filledArray = new int[array.length];


        return filledArray;
    }
}
