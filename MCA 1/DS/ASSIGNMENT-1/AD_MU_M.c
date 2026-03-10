#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

#define MAX 10

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
            printf("Enter element [%d][%d]: ", i, j);
            scanf("%d", &newNode->data);
            newNode->right = NULL;
            newNode->down = NULL;

            if (prev == NULL)
                rowHeads[i] = newNode;
            else
                prev->right = newNode;

            if (i > 0 && prevRow[j] != NULL)
                prevRow[j]->down = newNode;

            prev = newNode;
            prevRow[j] = newNode;
        }
    }
    return rowHeads[0];
}

void displayMatrix(struct Node* head, int rows, int cols) {
    int i, j;
    struct Node* rowPtr;
    struct Node* colPtr;

    if (head == NULL) {
        printf("Matrix is empty.\n");
        return;
    }

    rowPtr = head;
    for (i = 0; i < rows; i++) {
        colPtr = rowPtr;
        for (j = 0; j < cols; j++) {
            if (colPtr != NULL)
                printf("%d ", colPtr->data);
            else
                printf("0 ");
            colPtr = colPtr->right;
        }
        printf("\n");
        rowPtr = rowPtr->down;
    }
}

struct Node* getNodeAt(struct Node* head, int r, int c) {
    int i;
    struct Node* rowPtr = head;
    struct Node* colPtr;

    for (i = 0; i < r && rowPtr != NULL; i++)
        rowPtr = rowPtr->down;

    colPtr = rowPtr;
    for (i = 0; i < c && colPtr != NULL; i++)
        colPtr = colPtr->right;

    return colPtr;
}

struct Node* addMatrices(struct Node* A, struct Node* B, int rows, int cols) {
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
            struct Node* nodeA;
            struct Node* nodeB;
            int valA, valB;

            nodeA = getNodeAt(A, i, j);
            nodeB = getNodeAt(B, i, j);

            newNode = (struct Node*) malloc(sizeof(struct Node));

            valA = (nodeA != NULL) ? nodeA->data : 0;
            valB = (nodeB != NULL) ? nodeB->data : 0;

            newNode->data = valA + valB;
            newNode->right = NULL;
            newNode->down = NULL;

            if (prev == NULL)
                rowHeads[i] = newNode;
            else
                prev->right = newNode;

            if (i > 0 && prevRow[j] != NULL)
                prevRow[j]->down = newNode;

            prev = newNode;
            prevRow[j] = newNode;
        }
    }
    return rowHeads[0];
}

struct Node* multiplyMatrices(struct Node* A, struct Node* B, int r1, int c1, int c2) {
    int i, j, k;
    struct Node *rowHeads[MAX], *prevRow[MAX];
    struct Node *newNode, *prev;
    int sum, valA, valB;
    struct Node *nodeA, *nodeB;

    for (i = 0; i < MAX; i++) {
        rowHeads[i] = NULL;
        prevRow[i] = NULL;
    }

    for (i = 0; i < r1; i++) {
        prev = NULL;
        for (j = 0; j < c2; j++) {
            sum = 0;
            for (k = 0; k < c1; k++) {
                nodeA = getNodeAt(A, i, k);
                nodeB = getNodeAt(B, k, j);

                valA = (nodeA != NULL) ? nodeA->data : 0;
                valB = (nodeB != NULL) ? nodeB->data : 0;
                sum += valA * valB;
            }

            newNode = (struct Node*) malloc(sizeof(struct Node));
            newNode->data = sum;
            newNode->right = NULL;
            newNode->down = NULL;

            if (prev == NULL)
                rowHeads[i] = newNode;
            else
                prev->right = newNode;

            if (i > 0 && prevRow[j] != NULL)
                prevRow[j]->down = newNode;

            prev = newNode;
            prevRow[j] = newNode;
        }
    }
    return rowHeads[0];
}

void menu() {
    int choice;
    int r1=0, c1=0, r2=0, c2=0;
    struct Node *A = NULL, *B = NULL, *result = NULL;

    do {
        printf("\n--- Multi-Linked Matrix Operations ---\n");
        printf("1. Create Matrix A\n");
        printf("2. Create Matrix B\n");
        printf("3. Display Matrix A\n");
        printf("4. Display Matrix B\n");
        printf("5. Add Matrices (A + B)\n");
        printf("6. Multiply Matrices (A x B)\n");
        printf("7. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1:
                printf("Enter rows and columns for Matrix A (max %d): ", MAX);
                scanf("%d %d", &r1, &c1);
                if (r1 <= 0 || c1 <= 0 || r1 > MAX || c1 > MAX) {
                    printf("Invalid size.\n");
                    A = NULL;
                } else {
                    printf("Enter elements for Matrix A:\n");
                    A = createMatrix(r1, c1);
                }
                break;

            case 2:
                printf("Enter rows and columns for Matrix B (max %d): ", MAX);
                scanf("%d %d", &r2, &c2);
                if (r2 <= 0 || c2 <= 0 || r2 > MAX || c2 > MAX) {
                    printf("Invalid size.\n");
                    B = NULL;
                } else {
                    printf("Enter elements for Matrix B:\n");
                    B = createMatrix(r2, c2);
                }
                break;

            case 3:
                if (A == NULL)
                    printf("Matrix A not created.\n");
                else
                    displayMatrix(A, r1, c1);
                break;

            case 4:
                if (B == NULL)
                    printf("Matrix B not created.\n");
                else
                    displayMatrix(B, r2, c2);
                break;

            case 5:
                if (A == NULL || B == NULL)
                    printf("Create both matrices first.\n");
                else if (r1 != r2 || c1 != c2)
                    printf("Matrices must have same dimensions for addition.\n");
                else {
                    result = addMatrices(A, B, r1, c1);
                    printf("Result of A + B:\n");
                    displayMatrix(result, r1, c1);
                }
                break;

            case 6:
                if (A == NULL || B == NULL)
                    printf("Create both matrices first.\n");
                else if (c1 != r2)
                    printf("Matrix multiplication not possible (columns of A must equal rows of B).\n");
                else {
                    result = multiplyMatrices(A, B, r1, c1, c2);
                    printf("Result of A x B:\n");
                    displayMatrix(result, r1, c2);
                }
                break;

            case 7:
                printf("Exiting...\n");
                break;

            default:
                printf("Invalid choice. Try again.\n");
        }
    } while(choice != 7);
}

int main() {
    clrscr();
    menu();
    getch();
    return 0;
}
