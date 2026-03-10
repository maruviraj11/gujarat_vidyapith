from MyPack import *

if __name__ == "__main__":
    path = r"D:\MCA 1\PYTHON\ASSIGNMENT 2\P3\P3\CheckFolder"  

   
    all_items = list_files_recursive(path)
    print("\n--- All Items ---")
    print(all_items)

    py_files = filter_by_extension(all_items, ".py")
    print("\n--- Python Files ---")
    print(py_files)

    txt_files = filter_by_extension(all_items, ".txt")
    print("\n--- Text Files ---")
    print(txt_files)

    small_files = filter_by_size(all_items, max_size=2048)
    print("\n--- Small Files (<2KB) ---")
    print(small_files)

    
    recent_files = filter_by_date(all_items, days=1)
    print("\n--- Recently Modified (1 day) ---")
    print(recent_files)


    small_py_files = filter_by_size(py_files, max_size=2048)
    print("\n--- Small Python Files (<2KB) ---")
    print(small_py_files)

    names = file_names(py_files)
    print("\n--- File Names Only ---")
    print(names)
