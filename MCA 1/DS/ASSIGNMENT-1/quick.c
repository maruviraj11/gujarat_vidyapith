#include <stdio.h>


void swap(int *a, int *b) 
{
    int temp = *a;
    *a = *b;
    *b = temp;
}


int partition(int a[], int low, int high) 
{
    int key = a[low];  // First element as pivot
    int i = low + 1;
    int j = high;

    while (1) {
        while (i <= high && a[i] < key) 
        {
            i++;
        }
        while (j >= low && a[j] > key) 
        {
            j--;
        }
        if (i >= j)
            break;
        swap(&a[i], &a[j]);
        i++;
        j--;
    }
    swap(&a[low], &a[j]);
    return j;  
}
void quickSort(int a[], int low, int high) 
{
    if (low < high) 
    {
        int p = partition(a, low, high);
        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);
    }
}
void printArray(int a[], int n)
 {
    for (int i = 0; i < n; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");
}
int main() {
    int a[] = {32, -1, 4, 89, 16, 93, 66, 54, 12, 29};
    int n = sizeof(a) / sizeof(a[0]);

    printf("Original array:\n");
    printArray(a, n);

    quickSort(a, 0, n - 1);

    printf("Sorted array:\n");
    printArray(a, n);

    return 0;
}
