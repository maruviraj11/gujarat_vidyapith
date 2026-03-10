from MyPack import evaluate

if __name__ == "__main__":
    expr = input("Enter a mathematical expression: ")
    result = evaluate(expr)
    print(f"Result: {result}")
