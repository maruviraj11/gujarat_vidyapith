import os
import datetime

def list_files_recursive(path):
    """
    Recursively list all files and folders in a directory
    """
    items = []
    for root, dirs, files in os.walk(path):
        for name in dirs + files:
            items.append(os.path.join(root, name))
    return items


def filter_by_extension(files, ext):
    """Filter files by extension (.py, .txt etc.)"""
    return list(filter(lambda f: f.endswith(ext), files))


def filter_by_size(files, min_size=0, max_size=float("inf")):
    """Filter files by size range in bytes"""
    return list(filter(lambda f: min_size <= os.path.getsize(f) <= max_size, files))


def filter_by_date(files, days=1):
    """Filter files modified in the last `days`"""
    now = datetime.datetime.now().timestamp()
    return list(filter(lambda f: now - os.path.getmtime(f) <= days * 86400, files))


def file_names(files):
    """Map function: extract only filenames from full paths"""
    return list(map(lambda f: os.path.basename(f), files))
