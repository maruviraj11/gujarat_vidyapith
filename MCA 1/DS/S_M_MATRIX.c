#include <stdio.h>
#include <stdlib.h>

#define MAX 20

struct Node {
    int data;
    struct Node* right;
    struct Node* down;
};

struct Node* createMatrix(int rows, int cols) {
    int i, j;
    struct Node *rowHeads[MAX], *prevRow[MAX];
    struct Node *newNode, *prev;

    for (i = 0; i < MAX; i++) {
        rowHeads[i] = NULL;
        prevRow[i] = NULL;
    }

    for (i = 0; i < rows; i++) {
        prev = NULL;
        for (j = 0; j < cols; j++) {
            newNode = (struct Node*) malloc(sizeof(struct Node));
            if (newNode == NULL) {
                printf("Memory allocation failed.\n");
                exit(1);
            }

            printf("Enter element [%d][%d]: ", i, j);
            scanf("%d", &newNode->data);
            newNode->right = NULL;
            newNode->down = NULL;

            if (prev == NULL)
                rowHeads[i] = newNode;    // first node in the row
            else
                prev->right = newNode;    // link to previous in row

            if (i > 0 && prevRow[j] != NULL)
                prevRow[j]->down = newNode; // link to node above

            prev = newNode;
            prevRow[j] = newNode;
        }
    }

    return rowHeads[0]; // return head (0,0)
}

void displayMatrix(struct Node* head, int rows, int cols) {
    struct Node* rowPtr = head;
    struct Node* colPtr;
    int i, j;

    if (head == NULL) {
        printf("Matrix is empty.\n");
        return;
    }

    printf("\nMatrix:\n");
    for (i = 0; i < rows; i++) {
        colPtr = rowPtr;
        for (j = 0; j < cols; j++) {
            if (colPtr != NULL) {
                printf("%d ", colPtr->data);
                colPtr = colPtr->right;
            } else {
                printf("0 ");
            }
        }
        printf("\n");
        if (rowPtr != NULL)
            rowPtr = rowPtr->down;
    }
}

void menu() {
    int choice;
    int rows = 0, cols = 0;
    struct Node* matrix = NULL;

    do {
        printf("\n--- Multi-Linked Matrix Menu ---\n");
        printf("1. Create Matrix\n");
        printf("2. Display Matrix\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1:
                printf("Enter number of rows (max %d): ", MAX);
                scanf("%d", &rows);
                printf("Enter number of columns (max %d): ", MAX);
                scanf("%d", &cols);

                if (rows > MAX || cols > MAX || rows <= 0 || cols <= 0) {
                    printf("Invalid size. Please enter rows and columns between 1 and %d.\n", MAX);
                    matrix = NULL;
                } else {
                    matrix = createMatrix(rows, cols);
                }
                break;

            case 2:
                if (matrix == NULL)
                    printf("Matrix not created yet.\n");
                else
                    displayMatrix(matrix, rows, cols);
                break;

            case 3:
                printf("Exiting...\n");
                break;

            default:
                printf("Invalid choice. Try again.\n");
        }
    } while(choice != 3);
}

int main() {
    menu();
    return 0;
}

