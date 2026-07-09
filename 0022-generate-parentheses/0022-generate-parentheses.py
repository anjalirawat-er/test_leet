class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []

        def backtrack(curr, openCount, closeCount):
            if len(curr) == 2 * n:
                result.append(curr)
                return

            if openCount < n:
                backtrack(curr + "(", openCount + 1, closeCount)

            if closeCount < openCount:
                backtrack(curr + ")", openCount, closeCount + 1)

        backtrack("", 0, 0)
        return result