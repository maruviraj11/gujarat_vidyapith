#include <stdio.h>
#include <stdlib.h>

#define MAX 5
int q[MAX];

void insert(int *f, int *r, int ele);
int delete(int *f, int *r);
void modify(int *f, int *r);
void display(int *f, int *r);

int main() {
    int *front = (int *)malloc(sizeof(int));
    int *rear = (int *)malloc(sizeof(int));
    int choice, ele, rem;

    *front = -1;
    *rear = -1;

    while (1) {
        printf("\nCircular Queue Operations:\n");
        printf("1. Insert\n2. Delete\n3. Modify\n4. Display\n5. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter element to insert: ");
                scanf("%d", &ele);
                insert(front, rear, ele);
                break;
            case 2:
                rem = delete(front, rear);
                if (rem != -1)
                    printf("Deleted element: %d\n", rem);
                break;
            case 3:
                modify(front, rear);
                break;
            case 4:
                display(front, rear);
                break;
            case 5:
                free(front);
                free(rear);
                printf("Exiting...\n");
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }
    return 0;
}

void insert(int *f, int *r, int ele) {
    if ((*f == 0 && *r == MAX - 1) || ((*r + 1) % MAX == *f)) {
        printf("Queue is full.\n");
        return;
    }
    if (*f == -1) {
        *f = *r = 0;
    } else {
        *r = (*r + 1) % MAX;
    }
    q[*r] = ele;
    printf("Inserted %d\n", ele);
}

int delete(int *f, int *r) {
    int rem;
    if (*f == -1) {
        printf("Queue is empty.\n");
        return -1;
    }
    rem = q[*f];
    if (*f == *r) {
        *f = *r = -1;
    } else {
        *f = (*f + 1) % MAX;
    }
    return rem;
}

void modify(int *f, int *r) {
    if (*f == -1) {
        printf("Queue is empty. Nothing to modify.\n");
        return;
    }
    int size, pos, new_val;
    if (*r >= *f)
        size = *r - *f + 1;
    else
        size = MAX - (*f - *r) + 1;

    printf("Enter position to modify (1 to %d): ", size);
    scanf("%d", &pos);
    if (pos < 1 || pos > size) {
        printf("Invalid position.\n");
        return;
    }

    printf("Enter new value: ");
    scanf("%d", &new_val);

    int idx = (*f + pos - 1) % MAX;
    q[idx] = new_val;
    printf("Modification successful.\n");
}

void display(int *f, int *r) {
    if (*f == -1) {
        printf("Queue is empty.\n");
        return;
    }
    printf("Queue elements: ");
    int i = *f;
    while (1) {
        printf("%d ", q[i]);
        if (i == *r) break;
        i = (i + 1) % MAX;
    }
    printf("\n");
}
