function normalizeLength (...nums) {
  let max = 0
  for (let n of nums) {
    if (n.length > max) max = n.length
  }
  return nums.map(n => '0'.repeat(max - n.length) + n)
}

function add (a, b) {
  let out = []
  let carry = 0
  for (let i = a.length - 1; i >= 0; i--) {
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
    next += carry
    carry = nextCarry || next > 1 ? 1 : 0
    next %= 2
    out.unshift(next ? '1' : '0')
  }
  if (carry) out.unshift('1')
  return out.join('')
}

function binadd (n, m) {
  return add(...normalizeLength(n, m))
}

// built-ins
function binadd2 (a, b) {
  return (parseInt(a, 2) + parseInt(b, 2)).toString(2)
}

// can accept arbitrary number of inputs
function binadd3 (...input) {
  return input.reduce(binadd)
}


/***** testing */
console.log(binadd3(
  '101',      // 5
  '1001',     // 9
  '1010101'   // 85
))            // 99 (1100011)

console.log(binadd(
  '110',      // 6
  '1010'      // 10
))            // 16 (10000)
