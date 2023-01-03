class Solution:
    def romanToInt(self, s: str) -> int:
        d = {0: 1, 1: 5, 2:10, 3: 50, 4: 100, 5: 500, 6: 1000 }
        a = ["I", "V", "X", "L", "C", "D", "M"]
        data = list(map(lambda x: a.index(x), list(s)))
        result = 0
        for i in range(len(data)):
            if any(map(lambda x: x > data[i], data[i:])):
                result -= d[data[i]]
            else:
                result += d[data[i]]
        return result