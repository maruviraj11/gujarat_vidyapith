#include <stdio.h>
#include <stdlib.h>

// Define Node structure
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

struct Node* root = NULL;

// Create a new node
struct Node* createNode(int val) {
    struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;
    return temp;
}

// Insert node iteratively
void insert(int val) {
    struct Node* newNode = createNode(val);
    if (root == NULL) {
        root = newNode;
        return;
    }

    struct Node* current = root;
    struct Node* parent = NULL;

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

// Inorder Traversal (Iterative)
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

// Find minimum value node
struct Node* minValueNode(struct Node* node) {
    struct Node* current = node;
    while (current && current->left != NULL)
        current = current->left;
    return current;
}

// Delete a node
struct Node* deleteNode(struct Node* root, int key) {
    if (root == NULL)
        return root;

    if (key < root->data)
        root->left = deleteNode(root->left, key);
    else if (key > root->data)
        root->right = deleteNode(root->right, key);
    else {
        // Node found
        if (root->left == NULL) {
            struct Node* temp = root->right;
            free(root);
            return temp;
        } else if (root->right == NULL) {
            struct Node* temp = root->left;
            free(root);
            return temp;
        }

        struct Node* temp = minValueNode(root->right);
        root->data = temp->data;
        root->right = deleteNode(root->right, temp->data);
    }

    return root;
}

// Menu function
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

        switch (choice) {
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
                printf("Exiting program...\n");
                break;
            default:
                printf("Invalid choice. Try again.\n");
        }
    } while (choice != 4);
}

// Main function
int main() {
    menu();
    return 0;
}

