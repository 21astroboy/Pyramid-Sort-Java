import java.util.Scanner;
class Heap{
    private int n;
    private int[] array;
    private int Heapsize;

    public int getHeapsize() {
        return Heapsize;
    }

    public void setHeapsize(int heapsize) {
        Heapsize = heapsize;
    }
    public Heap (int[] array,int n){
        this.array = array;
        setHeapsize(n);
        this.n = n;
    }
    /*
    1. От середины массива идет сравнение  элемента с листьями(больший лист встает на место корня).
    Далее новый лист(здесь как корень) сравнивается с его листьями и также меняется
     */
    protected void Heapify(int i){
        int parent = (i-1)/2;
        int l  = 2*i+1;
        int r = 2*i+2;
        int biggest = i;
        if (l<getHeapsize() && (array[l]-array[i])>0)
            biggest = l;
        if (r<getHeapsize() && (array[r]-array[biggest])>0)
            biggest = r;
        if (biggest != i)
        {
            int temp = array[i];
            array[i] = array[biggest];
            array[biggest] = temp;

            Heapify(biggest);
        }
    }
    // создается куча
    protected void CreateMaxHeapHeap(){
        int i = ((n-1)/2);
        while(i>=0){
            Heapify(i);
            i--;
        }
    }
    /*
    Cортировка
    2. Меняется местами первый и i-ый элемент с конца.
    Первый элемент сравнивается с листьями и меняется местами с листом, если тот больше корня.
    Теперь уже новый лист, выступая как корень,
    сравнивается со своими листьями, меняясь,
    если  лист больше корня.

     */
    public void FinalSort(){
        CreateMaxHeapHeap();
        for(int i = getHeapsize()-1;i>0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            setHeapsize(getHeapsize()-1);
            Heapify(0);
        }
    }
}

class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] str = in.nextLine().split(" ");
        int [] array = new int[n];
        for(int i = 0; i < n;i++){
            array[i] = Integer.parseInt(str[i]);
        }
        Heap Heap1 = new Heap(array,n);
        Heap1.FinalSort();
        for(int i = 0; i < n;i++){
            System.out.print(array[i]+" ");
        }



    }
}
