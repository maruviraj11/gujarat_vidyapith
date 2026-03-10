#include <stdio.h>
#include <stdlib.h>

struct binarytree {
    int data;
    struct binarytree *left,*right;
    
};


struct binarytree* createnode(int value) {
    struct binarytree* newnode = (struct binarytree*)malloc(sizeof(struct binarytree));
    newnode->data = value;
    newnode->left = NULL;
    newnode->right = NULL;
    return newnode;
}


struct binarytree* insert(struct binarytree* root, int value) {
    if (root == NULL) {
        return createnode(value);
    }

    if (root->left == NULL) {
        root->left = createnode(value);
    }
    else if (root->right == NULL) {
        root->right = createnode(value);
    }
    else {
        // Always try to insert in left subtree first
        root->left = insert(root->left, value);
    }
    return root;
}


void inorder(struct binarytree* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}

void preorder(struct binarytree* root) {
    if (root != NULL) {
        printf("%d ", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

int main() {
    struct binarytree* root = NULL;
    int choice, value;

    while (1) {
        printf("\n------ BINARY TREE MENU ------\n");
        printf("1. Insert\n");
        printf("2. Inorder Traversal\n");
        printf("3. Preorder Traversal\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                root = insert(root, value);
                printf("%d inserted in Binary Tree.\n", value);
                break;
            case 2:
                printf("Inorder Traversal: ");
                inorder(root);
                printf("\n");
                break;
            case 3:
                printf("Preorder Traversal: ");
                preorder(root);
                printf("\n");
                break;
            case 4:
                printf("Exiting...\n");
                exit(0);
            default:
                printf("Invalid choice! Try again.\n");
        }
    }
    return 0;
}
