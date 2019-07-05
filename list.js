const Node = (val) => (next = null) => ({ next, val })
const List = (head = null) => ({ head })

const head = (list) => {
  if (!list || !list.head) return null
  return list.head.val
}

const tail = (list) => {
  if (!list || !list.head) return null
  return List(list.head.next)
}

const prepend = (list) => (x) => {
  if (!list) throw new Error('cannot add to null list')
  return List(Node(x)(list.head))
}

/**** testing ****/

let list = List()
for (let i = 1; i < 5; i++) {
  list = prepend(list)(i)
}
console.log(list)
console.log(head(list)) // 4
console.log(tail(list)) // List without 4
