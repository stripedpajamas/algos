// a facebook interview question that i completely failed
// write an iterator that returns the elements of a binary tree inorder
// (left, root, right)

// since it's an iterator we can't really do the recursive method
// but should do that to warm up

function inorderTraverseRec (root, visit = () => {}) {
  if (!root) return
  inorderTraverse(root.left, visit)
  visit(root)
  inorderTraverse(root.right, visit)
}

function* inorder (root) {
  const stack = []
  let current = root

  while (stack.length || current) {
    // as long as i can go left, go left
    while (current) {
      stack.push(current)
      current = current.left
    }
    current = stack.pop()
    yield current
    current = current.right
  }
}

/***** testing *****/
const root = generateTree()

for (let node of inorder(root)) {
  console.log(node.val)
}

/***** testing helpers ****/
/*
a classic testing tree is:

     1
    / \
   2   3
  / \
 4  5

an inorder traversal would result in [4,2,5,1,3]
*/
function generateTree () {
  const root = newNode(1)
  root.left = newNode(2)
  root.right = newNode(3)
  root.left.left = newNode(4)
  root.left.right = newNode(5)
  return root
}
function newNode (val) {
  return { val, left: null, right: null }
}




