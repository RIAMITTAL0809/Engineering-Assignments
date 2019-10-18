package heapsort;

import java.util.*;

public class heapsort 
{

    public void sort(int arr[]) 
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)

            heapify(arr,n,i);
            for(int j=n-1;j>=0;j--)
            {
                int temp=arr[0];
                arr[0]=arr[j];
                arr[j]=temp;

                heapify(arr,j,0);

            }
        }

    void heapify(int arr[],int n,int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l<n && arr[l] > arr[largest])
            largest = l;
        if(r<n && arr[r] >arr[largest])
            largest =r;
        if(largest !=i)
        {
            int swap =arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;

            heapify(arr,n,largest);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for(int i=0;i<n;++i)
            System.out.print(arr[i]+" ");
        System.out.println();

        System.out.println("the minimum marks  : "+ arr[0]);
        System.out.println("the maximum marks : "+ arr[n-1]);

    }


    public static void main(String[] args) throws Exception
    {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter no. of Student: ");
        int num=scan.nextInt();
        int arr[] = new int[num];
        System.out.println("Enter marks: ");
        for (int i = 0; i < num; i++) {
            arr[i] = scan.nextInt();
        }
        heapsort H  = new heapsort();
        H.sort(arr);
        printArray(arr);
    }
}



/*
Enter no. of Student: 10
Enter marks: 
12
6
33
100
45
67
78
100
86
34
6 12 33 34 45 67 78 86 100 100 
the minimum marks  : 6
the maximum marks : 100
*/