// Program - 3 : Write program to convert infix expression to prefix expression using stack
#include <stdio.h>
#include <string.h>
#define max 100

char st[max];
int top = -1;

void push(char c, int *t) {
    st[++(*t)] = c;
}

char pop(int *t) {
    return st[(*t)--];
}

char peek(int *t) {
    if (*t == -1) return '\0';
    return st[*t];
}

int prec(char c) {
    if (c == '+' || c == '-') return 1;
    if (c == '*' || c == '/') return 2;
    return 0;
}

int isOp(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
}

void revStr(char *s) {
    int i = 0, j = strlen(s) - 1;
    while (i < j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
        i++; j--;
    }
}

int main() {
    char inf[max], pre[max], c;
    int i, j = 0,len;
    int *t = &top;

    while (1) {
        printf("Enter infix expression ending with '#' : ");
        scanf("%s", inf);

        len = strlen(inf);
        if (inf[len - 1] == '#') {
            break;  
        } else {
            printf("Error: Expression must end with '#'. Please try again.\n\n");
        }
    }

    if (inf[len - 1] == '#') {
        inf[len - 1] = '\0';
    }

    
    revStr(inf);

    
    for (i = 0; inf[i] != '\0'; i++) {
        if (inf[i] == '(')
            inf[i] = ')';
        else if (inf[i] == ')')
            inf[i] = '(';
    }

    
    for (i = 0; inf[i]; i++) {
        c = inf[i];

        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            pre[j++] = c;
        }
        else if (c == '(') {
            push(c, t);
        }
        else if (c == ')') {
            while (*t != -1 && peek(t) != '(') {
                pre[j++] = pop(t);
            }
            if (*t != -1) pop(t); 
        }
        else if (isOp(c)) {
            
            while (*t != -1 && isOp(peek(t)) && prec(peek(t)) > prec(c)) {
                pre[j++] = pop(t);
            }
            push(c, t);
        }
    }

    while (*t != -1) {
        pre[j++] = pop(t);
    }

    pre[j] = '\0';

    
    revStr(pre);

    printf("Prefix expression: %s\n", pre);

    return 0;
}

