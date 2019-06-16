function binadd (n, m) {
  // normalize length
  let a
  let b
  if (n.length === m.length) {
    a = n
    b = m
  } else {
    // a = longer, b = shorter
    a = n.length > m.length ? n : m
    b = m.length > n.length ? n : m
    while (a.length !== b.length) {
      b = '0' + b
    }
  }

  let out = []
  let carry = 0
  let i = a.length - 1
  while (i >= 0) {
    let next
    let nextCarry
    if (a[i] === '1' && b[i] === '1') {
      nextCarry = 1
      next = 0
    } else if (a[i] === '0' && b[i] === '0') {
      next = 0
    } else if (a[i] === '1' || b[i] === '1') {
      next = 1
    }
    if (carry) {
      next = next + carry
    }
    carry = nextCarry || next > 1 ? 1 : 0
    next %= 2
    out.unshift(next ? '1' : '0')
    console.log(a[i], b[i], { carry, out })
    i--
  }
  if (carry) out.unshift('1')
  return out.join('')
}

console.log(binadd(
  '110', // 6
  '1010' // 10
)) // 10000 (16)
