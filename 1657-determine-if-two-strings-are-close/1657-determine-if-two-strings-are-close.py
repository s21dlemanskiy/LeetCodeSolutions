class Solution(object):
    def closeStrings(self, word1, word2):
        if set(word1) != set(word2):
            return False
        a = [word1.count(i) for i in set(word1)]
        b = [word2.count(i) for i in set(word2)]
        return sorted(a) == sorted(b)
        