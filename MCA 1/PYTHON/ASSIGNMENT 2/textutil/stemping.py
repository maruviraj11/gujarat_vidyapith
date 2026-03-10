def stem(word):
    suffixes = ["ing", "ed", "ly", "s"]
    for s in suffixes:
        if word.endswith(s):
            return word[:-len(s)]
    return word
