public class Main {
    public static void main(String[] args) {
        int[] array = {802, 2, 24, 45, 66, 170, 75, 90};
        System.out.println("Unsorted array:" + java.util.Arrays.toString(array));
        //SelectionSort select = new SelectionSort();
        //InsertionSort insert = new InsertionSort();
        //BubbleSort bubble = new BubbleSort();
        //MergeSort merge = new MergeSort();
        //QuickSort quick = new QuickSort();
        //CountingSort count = new CountingSort();
        //RadixSort radix = new RadixSort();
        //int[] retorno = radix.radixSort(array);  
        QuickSelect qs = new QuickSelect();
        int k = qs.quickSelect(array, 3);
        System.out.println(k);
    }
}
