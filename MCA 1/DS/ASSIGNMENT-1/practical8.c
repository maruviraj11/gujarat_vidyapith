#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node* insertSorted(struct node *head, int val) {
    struct node *newNode = (struct node*)malloc(sizeof(struct node));
    newNode->data = val;
    newNode->prev = NULL;
    newNode->next = NULL;

    
    if (head == NULL || val < head->data) {
        newNode->next = head;
        if (head != NULL) {
            head->prev = newNode;
        }
        head = newNode;
        return head;
    }

    
    struct node *curr = head;
    while (curr->next != NULL && curr->next->data < val) {
        curr = curr->next;
    }

    newNode->next = curr->next;
    if (curr->next != NULL) {
        curr->next->prev = newNode;
    }
    curr->next = newNode;
    newNode->prev = curr;

    return head;
}


struct node* removeNode(struct node *head, int val) {
    struct node *curr = head;

    
    while (curr != NULL && curr->data != val) {
        curr = curr->next;
    }

    if (curr == NULL) {
        printf("Element not found\n");
        return head;
    }

    
    if (curr->prev != NULL) {
        curr->prev->next = curr->next;
    } else {
        head = curr->next;  // removing head
    }

    if (curr->next != NULL) {
        curr->next->prev = curr->prev;
    }

    printf("Element %d removed\n", val);
    free(curr);

    return head;
}




int main() {
    struct node *head = NULL;
    int choice, val;

    do {
        printf("\n---- MENU ----\n");
        printf("1. Insert (Sorted)\n");
        printf("2. Remove\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &val);
                head = insertSorted(head, val);
                
                break;
            case 2:
                printf("Enter value to remove: ");
                scanf("%d", &val);
                head = removeNode(head, val);
                break;
            
            case 3:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid Choice!\n");
        }
    } while(choice != 3);

    return 0;
}
