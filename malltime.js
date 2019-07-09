/**
 * Given a list of { timestamp, people count, left/arrived }
 * return the timestamp with the most people inside
 */

function findBusiestTime (log = []) {
  return log.reduce((acc, [timestamp, count, arrived]) => {
    // squash same-time entries
    let [prevTime, prevCount = 0] = acc[acc.length - 1] || []
    let nextTime = prevCount + ((arrived || arrived - 1) * count)
    return prevTime === timestamp
      ? [...acc.slice(0, -1), [timestamp, nextTime]]
      : [...acc, [timestamp, nextTime]]
  }, []).reduce(([busiestTime, busiestCount], [currentTime, currentCount]) => {
    // get max count
    return currentCount > busiestCount
      ? [currentTime, currentCount]
      : [busiestTime, busiestCount]
  }).shift() // return only the timestamp
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
