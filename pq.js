const assert = require('assert')

/**
 * pq-system:
 * composed of 3 symbols: p, q, - 
 * xp-qx- is valid, whenever x is composed of only hyphens
 * if x, y, z are particular strings containing only hyphens,
 *   and if xpypz is valid, then xpy-qz- is also valid
 * 
 * write a function isInPq (str) that returns true if
 * the given string is valid in the pq-system and false
 * otherwise
 */

function isInPq (str) {
  let parsed
  try {
    parsed = parse(str)
  } catch (e) {
    return false
  }
  return isAxiom(parsed) || isInPq(stringify(reduce(parsed)))
}

function parse (str) {
  let [past, present, future] = ['', '', '']
  let [havePast, havePresent] = [false, false, false]
  for (let c of str) {
    switch (c) {
      case '-': {
        if (!havePast) {
          past += c
          break
        }
        if (!havePresent) {
          present += c
          break
        }
        future += c
        break
      }
      case 'p': {
        havePast = true
        break
      }
      case 'q': {
        havePresent = true
        break
      }
      default:
        throw new Error('invalid input')
    }
  }
  const parsed = [past, present, future]
  if (!parsed.every(el => Boolean(el.length))) {
    throw new Error('invalid input')
  }
  return parsed
}

function isAxiom ([past, present, future]) {
  return past.length + 1 === future.length && present.length === 1
}

function reduce ([past, present, future]) {
  return [past, present.slice(0, -1), future.slice(0, -1)]
}

function stringify([past, present, future]) {
  return `${past}p${present}q${future}`
}

assert.ok(isInPq('-p-q--') === true)
assert.ok(isInPq('---p-q--') === false)
assert.ok(isInPq('---p---q--') === false)
assert.ok(isInPq('--p---q-----') === true)
assert.ok(isInPq('---p---q---') === false)
assert.ok(isInPq('----p---q----') === false)
assert.ok(isInPq('-----p---q-----') === false)
assert.ok(isInPq('---p-q----') === true)
assert.ok(isInPq('---p---q------') === true)
assert.ok(isInPq('-p---q----') === true)
