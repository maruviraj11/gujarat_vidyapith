#include <stdio.h>
#include <string.h>
#define max 100

char stack[max];
int top = -1;

void push(char c, int *t) {
    stack[++(*t)] = c;
}

char pop(int *t) {
    return stack[(*t)--];
}

char peek(int *t) {
    if (*t == -1) return '\0';
    return stack[*t];
}

int precedence(char c) {
    if (c == '+' || c == '-') return 1;
    if (c == '*' || c == '/') return 2;
    return 0;
}

int isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
}

int main() {
    char infix[max], postfix[max];
    int i, j, len;
    char c;
    int *t = &top;  

    while (1) {
        printf("Enter infix expression ending with '#' : ");
        scanf("%s", infix);

        len = strlen(infix);
        if (infix[len - 1] == '#') {
            break;  
        } else {
            printf("Error: Expression must end with '#'. Please try again.\n\n");
        }
    }

    j = 0;
    *t = -1;

    for (i = 0; infix[i] != '#'; i++) {
        c = infix[i];

        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
            postfix[j++] = c;
        }
        else if (c == '(') {
            push(c, t);
        }
        else if (c == ')') {
            while (peek(t) != '(') {
                if (*t == -1) {
                    printf("Error: Mismatched parentheses\n");
                    return 1;
                }
                postfix[j++] = pop(t);
            }
            pop(t); // Remove '('
        }
        else if (isOperator(c)) {
            while (*t != -1 && isOperator(peek(t)) && precedence(peek(t)) >= precedence(c)) {
                postfix[j++] = pop(t);
            }
            push(c, t);
        }
        else {
            printf("Error: Invalid character '%c' in expression\n", c);
            return 1;
        }
    }

    while (*t != -1) {
        if (peek(t) == '(' || peek(t) == ')') {
            printf("Error: Mismatched parentheses\n");
            return 1;
        }
        postfix[j++] = pop(t);
    }

    postfix[j] = '\0';

    printf("Postfix expression: %s\n", postfix);

    return 0;
}

