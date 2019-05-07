package sorts;
import java.lang.Math;
/**
 * @Nicola Di Candia and Andres Carrillo∫
 */
public class Sorts {
    
    public static void main(String[] args) {
        int [] array = {1,2,15,0,3,8,4,6,7};
        // output insertion 0,1,2,3,4,6,7,8,15 
        
        Sorts s = new Sorts();
        //s.insertion(array);
        
        s.InsertionSort(array);
    }
    public void createArray(int n){
        int max=10000000;
        int min=0;
        int range = max - min +1;
        int [] array = new int [n];
        for (int i = 0; i < n; i++) {
            array[i] = ((int)Math.random()*range)+min;
        }
    }
    
    public void print(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    public void InsertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are 
            greater than key, to one position ahead 
            of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        print(arr);
    }
    
    //merge sort
    public void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;

        // Initial index of merged subarry array 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point 
            int m = (l + r) / 2;

            // Sort first and second halves 
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves 
            merge(arr, l, m, r);
        }
    }
    //merge sort
    
    
}

/**
 * pendiente capturar un N y ese n llenar array con n
 * valores aleatorios y aplicarle el sort luego imprimir
 * primeros 15 en gui mostrar el tiempo de costo
 */