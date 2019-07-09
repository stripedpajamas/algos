/**
 * Given a list of { timestamp, people count, left/arrived }
 * return the timestamp with the most people inside
 */

function findBusiestTime (log = []) {
  let busiestTime
  let highestCount = -Infinity

  let currentTime
  let currentCount
  for (let entry of log) {
    let [timestamp, count, arrived] = entry

    arrived = arrived || arrived - 1

    // first entry
    if (typeof currentTime === 'undefined') {
      currentTime = timestamp
      currentCount = (arrived * count)
      continue
    }

    if (timestamp !== currentTime) {
      // we have just moved to a different timestamp
      if (currentCount > highestCount) {
        highestCount = currentCount
        busiestTime = currentTime
      }
      currentTime = timestamp
      currentCount += (arrived * count)
    }
  }

  // check last entry
  if (currentCount > highestCount) {
    highestCount = currentCount
    busiestTime = currentTime
  }

  return busiestTime
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
