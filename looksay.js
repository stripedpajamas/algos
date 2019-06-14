/*

the look and say sequence (describe the previous number):

1
11
21
1211
111221
312211
13112221
1113213211

given n return the nth look-and-say number
*/

function generate (current, n) {
  if (n === 1) return current
  const next = []
  let count = 1
  let type = current[0]
  for (let i = 1; i < current.length; i++) {
    if (current[i] == type) {
      count++
    } else {
      next.push(count, type)
      type = current[i]
      count = 1
    }
  }
  next.push(count, type)
  return generate(next.join(''), n - 1)
}

function looksay (n) {
  if (!n) return ''
  return generate('1', n)
}

console.log(looksay(4)) // should print 1211
