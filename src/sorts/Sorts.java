package sorts;
/**
 * @Nicola Di Candia and Andres Carrillo
 */
public class Sorts {
    
    public static void main(String[] args) {
        int [] array = {1,2,15,0,3,8,4,6,7};
        // output insertion 0,1,2,3,4,6,7,8,15 
        
        Sorts s = new Sorts();
        //s.insertion(array);
        
        s.sort(array);
    }
 
    public void insertion(int [] array){
        int n = array.length;
        Sorts s = new Sorts();
        for (int i = 0; i < n; i++) {
            if(i<n-1){
                if(array[i]>array[i+1]){
                    s.swap(array, i, i+1);
                        System.out.println("valor de i" + i);
                    if(i!=0){
                        for (int j = i; j == 0; j--) {
                            if(j==i){
                                System.out.println("valor: "+ j);
                            System.out.println("valor: "+ (j-1));
                            if(array[j]<array[j-1])
                                s.swap(array, j, j-1);
                            }
                            
                        }
                    }
                }
            }
        }
        s.print(array);
    }
    
    public void sort(int arr[]) {
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
    
    public void swap (int [] array, int a, int b){
        int aux, aux1;
        aux = array[a];
        aux1 = array[b];
        array[a] = aux1;
        array[b] = aux;
    }
    
    public void print(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

/**
 * pendiente capturar un N y ese n llenar array con n
 * valores aleatorios y aplicarle el sort luego imprimir
 * primeros 15 en gui mostrar el tiempo de costo
 */