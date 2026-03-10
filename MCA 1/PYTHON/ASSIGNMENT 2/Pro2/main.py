from textutils.tokenization import tokenize, remove_stopwords, filter_by_length
from textutils.stemming import stem_tokens
from textutils.frequency import get_word_frequencies

text = "I was reading books and reading stories happily."

stopwords = ['i', 'was', 'and', 'the']


tokens = tokenize(text)
print("Tokens:", tokens)


filtered = remove_stopwords(tokens, stopwords)
print("After stopword removal:", filtered)


long_words = filter_by_length(filtered, 4)
print("Words longer than 4:", long_words)


stemmed = stem_tokens(long_words)
print("Stemmed tokens:", stemmed)


freq = get_word_frequencies(stemmed)
print("Frequencies:", freq)
