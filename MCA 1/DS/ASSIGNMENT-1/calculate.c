#include <stdio.h>

#define MAX 50

 
int hashFunction(int key, int min, int range, int n) {
    return (key - min) * n / range;   
}

int main() {
    int arr[MAX], n;
    int i, j,k
	;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter elements: ");
    for(i = 0; i < n; i++)
        scanf("%d", &arr[i]);


    int min = arr[0], max = arr[0];
    for(i = 1; i < n; i++) {
        if(arr[i] < min) min = arr[i];
        if(arr[i] > max) max = arr[i];
    }

    int range = max - min + 1;

    // Creating buckets
    int bucket[n][n];   // Each bucket can store n elements
    int count[n];       // Count elements in each bucket

    for(i = 0; i < n; i++)
        count[i] = 0;

   
    for(i = 0; i < n; i++) {
        int index = hashFunction(arr[i], min, range, n);
        bucket[index][count[index]++] = arr[i];
    }

   
    for(i = 0; i < n; i++) {
        for(j = 0; j < count[i] - 1; j++) {
            for( k = 0; k < count[i] - j - 1; k++) {
                if(bucket[i][k] > bucket[i][k + 1]) {
                    int temp = bucket[i][k];
                    bucket[i][k] = bucket[i][k + 1];
                    bucket[i][k + 1] = temp;
                }
            }
        }
    }


    printf("\nSorted Array: ");
    for(i = 0; i < n; i++) {
        for(j = 0; j < count[i]; j++)
            printf("%d ", bucket[i][j]);
    }

    return 0;
}

