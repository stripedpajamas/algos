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
  return false
}

assert.ok(isInPq('-p-q--') === true)
assert.ok(isInPq('--p---q-----') === true)
assert.ok(isInPq('---p-q----') === true)
assert.ok(isInPq('---p---q------') === true)
assert.ok(isInPq('-p---q----') === true)
