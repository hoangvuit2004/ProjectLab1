import java.util.Arrays;

public class ArraysFill {
    private int[] array;

    public ArraysFill(int[] array) {

        this.array = array;
    }
    public int[] fillMissingValues(int k) {
        int newArray[] = new int[array.length];
        newArray = array.clone();
        for (int i = 1; i < newArray.length ; i++) {
            if(newArray[i] < newArray[i-1]){

                newArray[i] = checkValueK(checkArray(newArray,i,k),k);
            }
        }
        System.out.print(Arrays.toString(newArray));
        return newArray;
    }
    public int  checkValueK(int newArrays[], int k){
        int max = 0;
        for (int i = 0; i < k-1; i++) {
            int count = 0;
            int sum = 0;
            for (int j = i; j < k + i  ; j++) {
                if(count<=k){
                    sum+=newArrays[j];
                    count++;
                }
            }
            if(max < (sum/k)){
                max = sum/k;
            }


        }
        return max;
    }
    public int[] checkArray(int array[], int index, int k ){
        int newArray[] = new int[array.length];
        if(index - k + 1 >= 0 && index +k -1 <= array.length-1  ){
            for (int i = index-k+1,j = 0; i < index + k ; i++) {
                if(i!= index){
                    newArray[j] = array[i];
                    j++;
                }
            }
        }else if((index + k) >= array.length ){
            for (int i = index-k+1, j = 0; i <  array.length; i++) {
                if(i!= index){
                    newArray[j] = array[i];
                    j++;
                }
            }
        }else{
            for (int i = 0,j = 0; i < index+k ; i++) {
                if(i!= index){
                    newArray[j] = array[i];
                    j++;
                }
            }
        }
        return newArray;
    }


    public static void main(String[] args) {
        int []array = {10,11,12,-1,14,10,17,19,20};
        int k = 3;
        ArraysFill s = new ArraysFill(array);
        s.fillMissingValues(k);
    }
}
