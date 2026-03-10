#include <stdio.h>
#include <stdlib.h>

#define MAX 10
int DQ[MAX];

void DQ_Insert(int *, int *, int);
int DQ_Delete(int *, int *);
void DQ_Modify(int *, int *);
void DQ_Display(int *, int *);

int main() {
    int choice, ele, removed;
    int *front = (int *)malloc(sizeof(int));
    int *rear = (int *)malloc(sizeof(int));

    *front = -1;
    *rear = -1;

    while (1) {
        printf("\n=== Double Ended Queue Menu ===");
        printf("\n1. Insert");
        printf("\n2. Delete");
        printf("\n3. Modify");
        printf("\n4. Display");
        printf("\n5. Exit");
        printf("\nEnter Your Choice: ");
        scanf("%d", &choice);

        switch (choice) {   
            case 1:
                printf("Enter element to insert: ");
                scanf("%d", &ele);
                DQ_Insert(front, rear, ele);
                break;
            case 2:
                removed = DQ_Delete(front, rear);
                if (removed != -1)
                    printf("Removed value: %d\n", removed);
                break;
            case 3:
                DQ_Modify(front, rear);
                break;
            case 4:
                DQ_Display(front, rear);
                break;
            case 5:
                printf("Exiting program.\n");
                free(front);
                free(rear);
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }
    return 0;
}

void DQ_Insert(int *front, int *rear, int ele) {
    if (*rear >= MAX - 1) {
        printf("Queue is full.\n");
        return;
    }

    if (*front == -1 && *rear == -1) {
        *front = *rear = 0;
    } else {
        (*rear)++;
    }

    DQ[*rear] = ele;
    printf("Inserted: %d\n", ele);
}

int DQ_Delete(int *front, int *rear) {
    int choice;
    if (*front == -1 || *front > *rear) {
        printf("Queue is empty.\n");
        return -1;
    }

    printf("Enter 1 to delete from Front, 2 to delete from Rear: ");
    scanf("%d", &choice);

    int removed;
    if (choice == 1) {
        removed = DQ[*front];
        (*front)++;
    } else if (choice == 2) {
        removed = DQ[*rear];
        (*rear)--;
    } else {
        printf("Invalid delete choice.\n");
        return -1;
    }

    if (*front > *rear)
        *front = *rear = -1;

    return removed;
}

void DQ_Modify(int *front, int *rear) {
    if (*front == -1 || *front > *rear) {
        printf("Queue is empty. Nothing to modify.\n");
        return;
    }

    int pos, new_val;
    int size = *rear - *front + 1;

    printf("Enter position to modify (1 to %d): ", size);
    scanf("%d", &pos);

    if (pos < 1 || pos > size) {
        printf("Invalid position.\n");
        return;
    }

    printf("Enter new value: ");
    scanf("%d", &new_val);

    DQ[*front + pos - 1] = new_val;
    printf("Modification successful.\n");
}

void DQ_Display(int *front, int *rear) {
	int i;
    if (*front == -1 || *front > *rear) {
        printf("Queue is empty.\n");
        return;
    }

    int choice;
    printf("Enter 1 to display from Front, 2 to display from Rear: ");
    scanf("%d", &choice);

    printf("Queue contents:\n");
    if (choice == 1) {
        for ( i = *front; i <= *rear; i++) {
            printf("%d ", DQ[i]);
        }
    } else if (choice == 2) {
        for ( i = *rear; i >= *front; i--) {
            printf("%d ", DQ[i]);
        }
    } else {
        printf("Invalid display choice.\n");
    }
    printf("\n");
}
