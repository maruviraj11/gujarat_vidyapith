# exprparser/parser.py

# Define operator functions using lambdas
operators = {
    '+': lambda a, b: a + b,
    '-': lambda a, b: a - b,
    '*': lambda a, b: a * b,
    '/': lambda a, b: a / b if b != 0 else float('inf')
}


def evaluate(expression):
    """
    Recursively evaluate a mathematical expression.
    Supports +, -, *, / and parentheses.
    """
    expression = expression.replace(" ", "")  # Remove spaces

    # Base case: if expression is just a number
    if expression.isdigit() or (expression.startswith('-') and expression[1:].isdigit()):
        return float(expression)

    # Handle parentheses first (recursive evaluation)
    while '(' in expression:
        start = expression.rfind('(')
        end = expression.find(')', start)
        inner_value = evaluate(expression[start + 1:end])
        expression = expression[:start] + str(inner_value) + expression[end + 1:]

    # Now handle +, -, *, /
    for op in ('+', '-', '*', '/'):
        index = find_operator_outside_parentheses(expression, op)
        if index != -1:
            left = expression[:index]
            right = expression[index + 1:]
            return operators[op](evaluate(left), evaluate(right))

    # If nothing left, it’s likely a number
    return float(expression)


def find_operator_outside_parentheses(expr, op):
    """Find operator not inside parentheses"""
    depth = 0
    for i, char in enumerate(expr):
        if char == '(':
            depth += 1
        elif char == ')':
            depth -= 1
        elif char == op and depth == 0:
            return i
    return -1
