function validParentheses (n) {
  const out = []
  function generateParens (current, open, close) {
    if (close === n) {
      out.push(current)
      return out
    }
    if (close < open) {
      generateParens(current + ')', open, close + 1)
    }
    if (open < n) {
      generateParens(current + '(', open + 1, close)
    }

    return out
  }
  return generateParens('', 0, 0)
}

