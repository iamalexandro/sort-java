package sorts;
import java.lang.Math;
import java.util.*;
import java.io.*;
import java.util.Timer;
/**
 * @Nicola Di Candia and Andres Carrillo
 */
public class Sorts {
    
    static int [] array;
    static int [] array2; 
    
    public static void main(String[] args) {
        Sorts s = new Sorts();
//        s.createArray(5);
//        s.cloneArray(array);
        //pruebas
        //merge
        int [] prueba = {5,7,2,9,6,7,0,4};
        int n = prueba.length;
        s.quicksortM(prueba,0,n-1);
        s.print(prueba);
        
        //prueba reloj
        int minutos = 0;
        int segundos = 0;
        for (minutos=0; minutos < 60; minutos++) {
            for (segundos = 0; segundos < 60; segundos++) {
                System.out.print(minutos+":"+segundos+"  ");
                s.delaySecond();
            }
        }
        
        
        
    }
    //util
    public void createArray(int n){
        Sorts s = new Sorts();
        array = new int [n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)Math.floor(Math.random()*(0-(n+0))+n);
        }
    }
    
    public void cloneArray(int [] array){
        Sorts s = new Sorts();
        int n = array.length;
        array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array2[i]=array[i];
        }
        System.out.println("Array clonado");
        //s.print(array2);
    }
    public void print(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(" " + array[i]);
        }
    }
    public String getFirst(int [] array){
        String msg="";
        int n = array.length;
        for (int i = 0; i < 15; i++) {
            msg += i+1 + ". " + array[i]+ "\n";
        }
        return msg;
    }
    public String getLast(int [] array){
        String msg = "";
        int n = array.length;
        int count = 1;
        for (int i = n-15; i < n; i++) {
            msg += count + ". " + array[i] + "\n";
            count ++;
        }
        return msg;
    }
    //time
    public void delaySecond(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
    }
    /**
     * Sorts
     */
    //insertion
    public void insertionSort(int arr[]) {
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
        System.out.println("Array Ordenado por Insertion");
        //print(arr);
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
    //raddix sort
    public int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }
    public void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // Build the output array 
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    public void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }
    //shell sort
    int shell(int arr[]){ 
        int n = arr.length; 
  
        // Start with a big gap, then reduce the gap 
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 
            // Do a gapped insertion sort for this gap size. 
            // The first gap elements a[0..gap-1] are already 
            // in gapped order keep adding one more element 
            // until the entire array is gap sorted 
            for (int i = gap; i < n; i += 1) 
            { 
                // add a[i] to the elements that have been gap 
                // sorted save a[i] in temp and make a hole at 
                // position i 
                int temp = arr[i]; 
  
                // shift earlier gap-sorted elements up until 
                // the correct location for a[i] is found 
                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                    arr[j] = arr[j - gap]; 
  
                // put temp (the original a[i]) in its correct 
                // location 
                arr[j] = temp; 
            } 
        } 
        return 0; 
    }
    //quicksort
    public int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j] 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public void quicksort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    //quicksort plus
    public void Mediana3(int arr[], int ini, int fin) {
        int mitad = (ini + fin) / 2;
        int a, b, c;
        int mediana;
        a = arr[ini];
        b = arr[mitad];
        c = arr[fin];

        if (a < b) {
            if (b < c) {
                mediana = mitad;
            } else {
                if (a < c) {
                    mediana = fin;
                } else {
                    mediana = ini;
                }
            }
        } else {
            if (c < b) {
                mediana = mitad;
            } else {
                if (c < a) {
                    mediana = fin;
                } else {
                    mediana = ini;
                }
            }
        }
        int aux = arr[mediana];
        arr[mediana] = arr[fin];
        arr[fin] = aux;
        //return mediana;
    }
    public int partitionM(int arr[], int low, int high) {
        Mediana3(arr, low, high);
        int mitad = (low+high)/2;
        //int mitad = Mediana3(arr, low, high);
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j] 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public void quicksortM(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    
}