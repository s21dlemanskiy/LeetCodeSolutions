class Solution:
    def romanToInt(self, s: str) -> int:
        d = {"I": 1, "V": 5, "X":10, "L": 50,"C": 100, "D": 500, "M": 1000 }
        a = "IVXLCDM"
        result = 0
        for i in range(len(s)):
            sign = s[i]
            if i < len(s) - 1 and a.index(sign) < a.index(s[i + 1]):
                result -= d[sign]
            else:
                result += d[sign]
        return result