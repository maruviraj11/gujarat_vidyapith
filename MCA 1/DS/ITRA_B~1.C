#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

struct Node* root = NULL;

struct Node* createNode(int val) {
    struct Node* temp = (struct Node*) malloc(sizeof(struct Node));
    if (temp == NULL) {
        printf("Memory allocation failed\n");
        exit(1);
    }
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;
    return temp;
}

void insert(int val) {
    struct Node* newNode = createNode(val);
    struct Node* current;
    struct Node* parent;

    if (root == NULL) {
        root = newNode;
        return;
    }

    current = root;
    parent = NULL;

    while (current != NULL) {
        parent = current;
        if (val < current->data)
            current = current->left;
        else
            current = current->right;
    }

    if (val < parent->data)
        parent->left = newNode;
    else
        parent->right = newNode;
}

void inorderIterative() {
    struct Node* stack[100];
    int top = -1;
    struct Node* current = root;

    if (root == NULL) {
        printf("Tree is empty.\n");
        return;
    }

    while (1) {
        while (current != NULL) {
            stack[++top] = current;
            current = current->left;
        }

        if (top == -1)
            break;

        current = stack[top--];
        printf("%d ", current->data);
        current = current->right;
    }
    printf("\n");
}

struct Node* minValueNode(struct Node* node) {
    struct Node* current = node;
    while (current != NULL && current->left != NULL)
        current = current->left;
    return current;
}

struct Node* deleteNode(struct Node* node, int key) {
    struct Node* temp;

    if (node == NULL)
        return node;

    if (key < node->data) {
        node->left = deleteNode(node->left, key);
    } else if (key > node->data) {
        node->right = deleteNode(node->right, key);
    } else {
        // Node found
        if (node->left == NULL) {
            temp = node->right;
            free(node);
            return temp;
        } else if (node->right == NULL) {
            temp = node->left;
            free(node);
            return temp;
        }

        temp = minValueNode(node->right);
        node->data = temp->data;
        node->right = deleteNode(node->right, temp->data);
    }
    return node;
}

void menu() {
    int choice, val;
    do {
        printf("\n--- Binary Search Tree Menu ---\n");
        printf("1. Insert (Iterative)\n");
        printf("2. Display Inorder (Iterative)\n");
        printf("3. Delete Node\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &val);
                insert(val);
                printf("%d inserted.\n", val);
                break;

            case 2:
                printf("Inorder traversal: ");
                inorderIterative();
                break;

            case 3:
                printf("Enter value to delete: ");
                scanf("%d", &val);
                root = deleteNode(root, val);
                printf("%d deleted (if present).\n", val);
                break;

            case 4:
                printf("Exiting...\n");
                break;

            default:
                printf("Invalid choice. Try again.\n");
        }
    } while (choice != 4);
}

int main() {
    menu();
    return 0;
}

