/**
 * Given a list of { timestamp, people count, left/arrived }
 * return the timestamp with the most people inside
 */

function findBusiestTime (log = []) {
  return maxBy(
    mapSquash(
      objectify(log, ['time', 'count', 'arrived']),
      (prev = {}, el) => prev.time === el.time,
      ({ count: prevCount } = { count: 0 }, { time, count, arrived }) => ({
        time, count: prevCount + ((arrived || arrived - 1) * count)
      })
    ),
    (max, curr) => curr.count > max.count
  ).time
}

function objectify (arr, labels) {
  if (!arr.length) return
  return arr.map(entry => entry.reduce((acc, val, idx) => {
    const label = labels[idx] || idx
    acc[label] = val
    return acc
  }, {}))
}


/*
* If the predicate (prev, el) returns true, overwrite the latest
* entry in the output array with the result of map function; otherwise, add
* a new entry to the output array with the result of the map function
*/
function mapSquash (arr = [], predicate = () => {}, map = () => {}) {
  if (arr.length < 1) return []
  let out = [map(undefined, arr[0])]
  let outIdx = 0

  for (let i = 1; i < arr.length; i++) {
    let el = arr[i]
    let prev = out[outIdx]
    let next = map(prev, el)
    if (predicate(prev, el)) {
      out[outIdx] = next
    } else {
      out.push(next)
      outIdx++
    }
  }

  return out
}

/*
* f(max, curr) is a function that returns true if curr > max
*/
function maxBy (arr = [], f = () => {}) {
  if (!arr.length) return []
  let max = arr[0]
  for (let i = 1; i < arr.length; i++) {
    if (f(max, arr[i])) max = arr[i]
  }
  return max
}


/*** tests */
const log1 = [
  [1487799425, 21, 0],
  [1487799427, 22, 1],
  [1487901318, 7, 0]
]

const log2 = [
  [1487799425, 14, 1],
  [1487799425, 4, 0],
  [1487799425, 2, 0],
  [1487800378, 10, 1],
  [1487801478, 18, 0],
  [1487801478, 18, 1],
  [1487901013, 1, 0],
  [1487901211, 7, 1],
  [1487901211, 7, 0]
]

const log3 = [
  [1487799425, 14, 1],
  [1487799425, 4, 1],
  [1487799425, 2, 1],
  [1487800378, 10, 1],
  [1487801478, 18, 1],
  [1487901013, 1, 1],
  [1487901211, 7, 1],
  [1487901211, 7, 1]
]

console.log(findBusiestTime(log1), 'should equal 1487799427')
console.log(findBusiestTime(log2), 'should equal 1487800378')
console.log(findBusiestTime(log3), 'should equal 1487901211')
