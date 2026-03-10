#include <stdio.h>
#include <stdlib.h>

#define MAX 20

struct node {
    int vertex;
    struct node *next;
};

struct node* adj[MAX];   
int visited[MAX];        
int n = 0;               
int graphCreated = 0;    

void createGraph() {
    int i, e, src, dest;
    struct node *temp, *newnode;

    printf("\nEnter number of vertices (max %d): ", MAX);
    scanf("%d", &n);

    if (n <= 0 || n > MAX) {
        printf("Invalid number of vertices. Must be between 1 and %d.\n", MAX);
        n = 0;
        graphCreated = 0;
        return;
    }

    // Initialize adjacency list
    for (i = 0; i < n; i++)
        adj[i] = NULL;

    printf("Enter number of edges: ");
    scanf("%d", &e);

    for (i = 0; i < e; i++) {
        printf("\nEnter edge (src dest): ");
        scanf("%d %d", &src, &dest);

        // validate vertices
        if (src < 0 || src >= n || dest < 0 || dest >= n) {
            printf("Invalid vertices! Vertices must be between 0 and %d.\n", n - 1);
            i--;    // repeat this edge input
            continue;
        }

        // Add src -> dest
        newnode = (struct node*)malloc(sizeof(struct node));
        if (newnode == NULL) {
            printf("Memory allocation failed.\n");
            exit(1);
        }
        newnode->vertex = dest;
        newnode->next = NULL;

        if (adj[src] == NULL)
            adj[src] = newnode;
        else {
            temp = adj[src];
            while (temp->next != NULL)
                temp = temp->next;
            temp->next = newnode;
        }

        // Add dest -> src (undirected)
        newnode = (struct node*)malloc(sizeof(struct node));
        if (newnode == NULL) {
            printf("Memory allocation failed.\n");
            exit(1);
        }
        newnode->vertex = src;
        newnode->next = NULL;

        if (adj[dest] == NULL)
            adj[dest] = newnode;
        else {
            temp = adj[dest];
            while (temp->next != NULL)
                temp = temp->next;
            temp->next = newnode;
        }
    }

    graphCreated = 1;
    printf("\nGraph created successfully.\n");
}

void BFS(int start) {
    int queue[MAX], front = 0, rear = -1;
    int v;
    struct node *temp;
    int i;

    if (!graphCreated) {
        printf("Graph not created yet. Create graph first.\n");
        return;
    }

    if (start < 0 || start >= n) {
        printf("Invalid start vertex. Must be between 0 and %d.\n", n - 1);
        return;
    }

    // Initialize visited
    for (i = 0; i < n; i++)
        visited[i] = 0;

    // BFS
    queue[++rear] = start;
    visited[start] = 1;

    printf("\nBFS Traversal: ");

    while (front <= rear) {
        v = queue[front++];
        printf("%d ", v);

        temp = adj[v];
        while (temp != NULL) {
            if (!visited[temp->vertex]) {
                queue[++rear] = temp->vertex;
                visited[temp->vertex] = 1;
            }
            temp = temp->next;
        }
    }
    printf("\n");
}

void DFS_Rec(int v) {
    struct node *temp;
    visited[v] = 1;
    printf("%d ", v);

    temp = adj[v];
    while (temp != NULL) {
        if (!visited[temp->vertex])
            DFS_Rec(temp->vertex);
        temp = temp->next;
    }
}

void DFS(int start) {
    int i;

    if (!graphCreated) {
        printf("Graph not created yet. Create graph first.\n");
        return;
    }

    if (start < 0 || start >= n) {
        printf("Invalid start vertex. Must be between 0 and %d.\n", n - 1);
        return;
    }

    // Initialize visited
    for (i = 0; i < n; i++)
        visited[i] = 0;

    printf("\nDFS Traversal: ");
    DFS_Rec(start);
    printf("\n");
}

int main() {
    int ch, start;

    while (1) {
        printf("\n\n----- GRAPH MENU -----\n");
        printf("1. Create Graph\n");
        printf("2. BFS Traversal\n");
        printf("3. DFS Traversal\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &ch);

        switch (ch) {
            case 1:
                createGraph();
                break;

            case 2:
                printf("Enter start vertex: ");
                scanf("%d", &start);
                BFS(start);
                break;

            case 3:
                printf("Enter start vertex: ");
                scanf("%d", &start);
                DFS(start);
                break;

            case 4:
                exit(0);

            default:
                printf("Invalid choice!\n");
        }
    }

    return 0;
}

