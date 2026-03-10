from functools import reduce

def get_word_frequencies(tokens):
    """Use reduce to create frequency dict of tokens."""
    return reduce(
        lambda freq, word: {**freq, word: freq.get(word, 0) + 1},
        tokens,
        {}
    )
