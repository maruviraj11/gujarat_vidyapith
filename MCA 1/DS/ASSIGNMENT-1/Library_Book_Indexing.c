#include <stdio.h>
#include <stdlib.h>

struct Book {
    int id;
    char title[50];
    char author[50];
    struct Book *left, *right;
};

// Insert Function

struct Book* insert(struct Book* root, int id, char title[], char author[]) {
    if (root == NULL) {
        struct Book* newBook = (struct Book*) malloc(sizeof(struct Book));
        newBook->id = id;

        int i;
        for (i = 0; title[i] != '\0'; i++) {
            newBook->title[i] = title[i];
        }
        newBook->title[i] = '\0';

        for (i = 0; author[i] != '\0'; i++) {
            newBook->author[i] = author[i];
        }
        newBook->author[i] = '\0';

        newBook->left = newBook->right = NULL;
        return newBook;
    }

    if (id < root->id) {
        root->left = insert(root->left, id, title, author);
    }
    else if (id > root->id) {
        root->right = insert(root->right, id, title, author);
    }
    else {
        printf("\n  Book with ID %d already exists!\n", id);
    }

    return root;
}

// Search Function

struct Book* search(struct Book* root, int id) {
    if (root == NULL || root->id == id) {
        return root;
    }

    if (id < root->id) {
        return search(root->left, id);
    } else {
        return search(root->right, id);
    }
}

// Display function to display records in ascending order using inorder traversal
void inorder(struct Book* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("ID: %d | Title: %s | Author: %s\n", root->id, root->title, root->author);
        inorder(root->right);
    }
}

struct Book* findMin(struct Book* root) {
    while (root->left != NULL) {
        root = root->left;
    }
    return root;
}

// Delete Function

struct Book* deleteBook(struct Book* root, int id) {
    if (root == NULL) {
        return root;
    }

    if (id < root->id) {
        root->left = deleteBook(root->left, id);
    }
    else if (id > root->id) {
        root->right = deleteBook(root->right, id);
    }
    else {
        if (root->left == NULL) {
            struct Book* temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL) {
            struct Book* temp = root->left;
            free(root);
            return temp;
        }
        else {
            struct Book* temp = findMin(root->right);
            root->id = temp->id;

            int i;
            for (i = 0; temp->title[i] != '\0'; i++) {
                root->title[i] = temp->title[i];
            }
            root->title[i] = '\0';

            for (i = 0; temp->author[i] != '\0'; i++) {
                root->author[i] = temp->author[i];
            }
            root->author[i] = '\0';

            root->right = deleteBook(root->right, temp->id);
        }
    }
    return root;
}

// Main Function

int main() {
    struct Book* root = NULL;
    int choice, id, i;
    char title[50], author[50];

    while (1) {
        printf("\n====== Library Book Indexing System (BST) ======\n");
        printf("1. Insert a new Book\n");
        printf("2. Search for a Book\n");
        printf("3. Display All Books (sorted by ID)\n");
        printf("4. Delete a Book\n");
        printf("5. Exit\n");
        printf("===================================================\n");

        printf("Enter your choice: ");
        if (scanf("%d", &choice) != 1) {
            printf(" Please enter a number for choice!\n");
            return 0;
        }

        switch (choice) 
		{
			case 1: 
			    printf("\nEnter Book ID: ");
			    if (scanf("%d", &id) != 1) {
			        printf("?? Please enter a valid numeric ID!\n");
			        return 0;
			    }
			
			    // Clear input buffer before reading strings
			    getchar(); // remove the leftover newline from last input
			
			    printf("Enter Book Title: ");
			    scanf("%[^\n]", title); // get input until newline
			    if (title[0] == '\0') {
			        printf("?? Book title should not be empty!\n");
			    }
			
			    getchar(); // remove the leftover newline from last input
			
			    printf("Enter Book Author: ");
			    scanf("%[^\n]", author); // get input until newline
			    if (author[0] == '\0') {
			        printf("?? Book author should not be empty!\n");
			    }
			
			    root = insert(root, id, title, author);
			    break;
			

            case 2: 
                printf("\nEnter Book ID to search: ");
                if (scanf("%d", &id) != 1) {
                    printf(" Please enter a valid numeric ID!\n");
                    return 0;
                }

                struct Book* found = search(root, id);
                if (found != NULL) {
                    printf(" Found -> ID: %d | Title: %s | Author: %s\n",
                           found->id, found->title, found->author);
                } else {
                    printf(" Book with ID %d not found!\n", id);
                }
                break;
            

            case 3: 
                printf("\n Books in Library (sorted by ID):\n");
                inorder(root);
                break;
            

            case 4: 
			    printf("\nEnter Book ID to delete: ");
			    if (scanf("%d", &id) != 1) {
			        printf("?? Please enter a valid numeric ID!\n");
			        return 0;
			    }
			
			    if (search(root, id) != NULL) {
			        root = deleteBook(root, id);
			        printf(" Book with ID %d deleted successfully.\n", id);
			    } else {
			        printf(" Book with ID %d does not exist.\n", id);
			    }
			    break;

                
            case 5: 
                printf("\n Exiting... Thank you for using the system!\n");
                exit(0);
            

            default: 
                printf("\n Invalid choice! Please choose between 1 and 5.\n");
                break;
            
        }
    }
    return 0;
}

