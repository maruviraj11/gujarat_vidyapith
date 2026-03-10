//Write menu driven program to implement operation of singly circluar linked list of interger 1.insert 2.delete 3.modify 4.display
#include <stdio.h>
#include<conio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* head = NULL;   // start of list

// Insert at end
void insert(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;

    if (head == NULL) {
	head = newNode;
	newNode->next = head;   // circular link
    } else {
	struct Node* temp = head;
	while (temp->next != head) {   // go till last node
	    temp = temp->next;
	}
	temp->next = newNode;
	newNode->next = head;
    }
    printf("Inserted %d\n", value);
}

// Delete node by value

void deleteNode(int value) {
	struct Node *curr = head, *prev = NULL;
    if (head == NULL) {
	printf("List is empty\n");
	return;
    }

    //struct Node *curr = head, *prev = NULL;

    // If head is to be deleted
    if (head->data == value) {
	 struct Node* temp = head;
	if (head->next == head) { // only one node
	    free(head);
	    head = NULL;
	} else {
	    struct Node* last = head;
	    while (last->next != head)
		last = last->next;
	    last->next = head->next;
	   // struct Node* temp = head;
	    head = head->next;
	    free(temp);
	}
	printf("Deleted %d\n", value);
	return;
    }

    // Search in rest of list
    prev = head;
    curr = head->next;
    while (curr != head && curr->data != value) {
        prev = curr;
        curr = curr->next;
    }

    if (curr == head) {
        printf("Value %d not found\n", value);
    } else {
        prev->next = curr->next;
        free(curr);
        printf("Deleted %d\n", value);
    }
}

// Modify a value
void modify(int oldValue, int newValue) {
	struct Node* temp = head;
    if (head == NULL) {
        printf("List is empty\n");
	return;
    }

   // struct Node* temp = head;
    do {
        if (temp->data == oldValue) {
            temp->data = newValue;
            printf("Modified %d to %d\n", oldValue, newValue);
            return;
        }
        temp = temp->next;
    } while (temp != head);

    printf("Value %d not found\n", oldValue);
}

// Display list
void display() {
	 struct Node* temp = head;
    if (head == NULL) {
	printf("List is empty\n");
        return;
    }

    //struct Node* temp = head;
    printf("List: ");
    do {
        printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("(back to head)\n");
}

int main() {
    int choice, val, oldVal, newVal;

    do {
        printf("\n--- Circular Linked List Menu ---\n");
        printf("1. Insert\n2. Delete\n3. Modify\n4. Display\n5. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value: ");
                scanf("%d", &val);
                insert(val);
                break;
            case 2:
                printf("Enter value to delete: ");
                scanf("%d", &val);
                deleteNode(val);
                break;
            case 3:
                printf("Enter old value: ");
                scanf("%d", &oldVal);
                printf("Enter new value: ");
                scanf("%d", &newVal);
                modify(oldVal, newVal);
                break;
            case 4:
                display();
                break;
            case 5:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice\n");
        }
    } while (choice != 5);

    return 0;
}
