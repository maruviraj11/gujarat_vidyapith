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
    newNode->prev = newNode->next = NULL;


    if (head == NULL) {
        newNode->next = newNode;
        newNode->prev = newNode;
        return newNode;
    }

    struct node *curr = head;

    if (val < head->data) {
        struct node *last = head->prev;

        newNode->next = head;
        newNode->prev = last;
        last->next = newNode;
        head->prev = newNode;

        head = newNode;
        return head;
    }

    while (curr->next != head && curr->next->data < val) {
        curr = curr->next;
    }

    newNode->next = curr->next;
    newNode->prev = curr;
    curr->next->prev = newNode;
    curr->next = newNode;

    return head;
}

struct node* removeNode(struct node *head, int val) {
    if (head == NULL) {
        printf("List is empty\n");
        return NULL;
    }

    struct node *curr = head;

    do {
        if (curr->data == val) break;
        curr = curr->next;
    } while (curr != head);

    if (curr->data != val) {
        printf("Element not found\n");
        return head;
    }

    if (curr->next == curr && curr->prev == curr) {
        free(curr);
        return NULL;
    }

    if (curr == head) {
        head = head->next;
    }

    curr->prev->next = curr->next;
    curr->next->prev = curr->prev;

    printf("Element %d removed\n", val);
    free(curr);
    return head;
}

void traverseForward(struct node *head) {
    if (head == NULL) {
        printf("List is Empty\n");
        return;
    }

    struct node *curr = head;
    printf("Forward: ");
    do {
        printf("%d -> ", curr->data);
        curr = curr->next;
    } while (curr != head);
    printf("\n");
}

void traverseBackward(struct node *head) {
    if (head == NULL) {
        printf("List is Empty\n");
        return;
    }

    struct node *curr = head->prev; 
    printf("Backward: ");
    do {
        printf("%d -> ", curr->data);
        curr = curr->prev;
    } while (curr != head->prev);
    printf("\n");
}


int main() {
    struct node *head = NULL;
    int choice, val;

    do {
        printf("\n---- MENU ----\n");
        printf("1. Insert (Sorted)\n");
        printf("2. Remove\n");
        printf("3. Traverse Forward\n");
        printf("4. Traverse Backward\n");
        printf("5. Exit\n");
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
                traverseForward(head);
                break;
            case 4:
                traverseBackward(head);
                break;
            case 5:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid Choice!\n");
        }
    } while(choice != 5);

    return 0;
}
