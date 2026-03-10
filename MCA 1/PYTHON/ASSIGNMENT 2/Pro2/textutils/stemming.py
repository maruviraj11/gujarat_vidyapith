def simple_stemmer(word):
    """Very simple stemmer that removes common suffixes."""
    suffixes = ['ing', 'ly', 'ed', 's', 'es']
    for suffix in suffixes:
        if word.endswith(suffix) and len(word) > len(suffix) + 2:
            return word[:-len(suffix)]
    return word

def stem_tokens(tokens):
    """Stem a list of tokens using map."""
    return list(map(simple_stemmer, tokens))
