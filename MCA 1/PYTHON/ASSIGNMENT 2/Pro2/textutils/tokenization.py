import re

def tokenize(text):
    """Split text into tokens (words), all lowercase."""
    return re.findall(r'\b\w+\b', text.lower())

def remove_stopwords(tokens, stopwords):
    """Remove stopwords using filter and lambda."""
    return list(filter(lambda w: w not in stopwords, tokens))

def filter_by_length(tokens, min_length):
    """Filter tokens with length > min_length using filter and lambda."""
    return list(filter(lambda w: len(w) > min_length, tokens))
