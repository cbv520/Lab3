/**
** Software Technology 152
** Class to hold various static sort methods.
*/
import java.io.*;

class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
        int minIdx;
        for(int i = 0; i < A.length - 1; i++)
        {
            minIdx = i;
            for(int j = i + 1; j < A.length; j++)
            {
                if(A[j] < A[minIdx])
                {
                    minIdx = j;
                }
            }

            int temp = A[minIdx];
            A[minIdx] = A[i];
            A[i] = temp;
        }
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
        int i;
        for(int n = 1; n < A.length; n++)
        {
            i = n;
            int temp = A[i];
            while((i > 0) && (A[i - 1] > temp))
            {
                A[i] = A[i - 1];
                i--;
            }
            A[i] = temp;
        }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A) throws Exception
    {
        mergeSortRecurse(A, 0, A.length - 1);
    }//mergeSort()
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx) throws Exception
    {
        if(leftIdx < rightIdx)
        {

            int midIdx = (leftIdx + rightIdx)/2;
            PrintWriter pw;
            FileOutputStream fileStrm;
            fileStrm = new FileOutputStream("Idx.txt", true);
            pw = new PrintWriter(fileStrm);
            pw.printf("%3d    %3d    %3d\n", leftIdx, midIdx, rightIdx);
            pw.close();
            mergeSortRecurse(A, leftIdx, midIdx);
            mergeSortRecurse(A, midIdx + 1, rightIdx);
            fileStrm = new FileOutputStream("Idx.txt", true);
            pw = new PrintWriter(fileStrm);
            pw.printf("MERGING: %3d    %3d    %3d\n", leftIdx, midIdx, rightIdx);
            pw.close();
            merge(A, leftIdx, midIdx, rightIdx);

        }
    }//mergeSortRecurse()
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx) throws Exception
    {
        int[] temp = new int[rightIdx - leftIdx + 1];
        int i = leftIdx;
        int j = midIdx + 1;
        int k = 0;

        while((i <= midIdx) && j <= rightIdx)
        {
            if(A[i] <= A[j])
            {   PrintWriter pw;
                FileOutputStream fileStrm;
                fileStrm = new FileOutputStream("Idx.txt", true);
                pw = new PrintWriter(fileStrm);
                pw.printf("==MERGING: temp[%d]  =  A[%d]  =  %3d\n", k, i, A[i]);
                pw.close();
                temp[k] = A[i];
                i++;
            }
            else
            {
                PrintWriter pw;
                    FileOutputStream fileStrm;
                    fileStrm = new FileOutputStream("Idx.txt", true);
                    pw = new PrintWriter(fileStrm);
                    pw.printf("==MERGING: temp[%d]  =  A[%d]  =  %3d\n", k, j, A[j]);
                    pw.close();
                temp[k] = A[j];
                j++;
            }
            k++;
        }

        for(i = i; i <= midIdx; i++)
        {
            PrintWriter pw;
                FileOutputStream fileStrm;
                fileStrm = new FileOutputStream("Idx.txt", true);
                pw = new PrintWriter(fileStrm);
                pw.printf("===MERGING: temp[%d]  =  A[%d]  =  %3d\n", k, i, A[i]);
                pw.close();
            temp[k] = A[i];
            k++;
        }
        for(j = j; j <= rightIdx; j++)
        {
            PrintWriter pw;
                FileOutputStream fileStrm;
                fileStrm = new FileOutputStream("Idx.txt", true);
                pw = new PrintWriter(fileStrm);
                pw.printf("===MERGING: temp[%d]  =  A[%d]  =  %3d\n", k, j, A[j]);
                pw.close();
            temp[k] = A[j];
            k++;
        }
        for(int n = leftIdx; n <= rightIdx; n++)
        {
            PrintWriter pw;
                FileOutputStream fileStrm;
                fileStrm = new FileOutputStream("Idx.txt", true);
                pw = new PrintWriter(fileStrm);
                pw.printf("====MERGING: A[%d]  =  temp[%d]  =  %3d\n", n, n - leftIdx, temp[n - leftIdx]);
                pw.close();
            A[n] = temp[n - leftIdx];
        }

    }//merge()


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
		return 0;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


}//end Sorts calss
