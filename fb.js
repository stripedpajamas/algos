// a facebook interview question that i completely failed
// write an iterator that returns the elements of a binary tree inorder
// (left, root, right)

// since it's an iterator we can't really do the recursive method
// but should do that to warm up

function inorderTraverse (root, visit = () => {}) {
  if (!root) return
  inorderTraverse(root.left, visit)
  visit(root)
  inorderTraverse(root.right, visit)
}

/***** testing *****/
const root = generateTree()
inorderTraverse(root, (n) => console.log(n.val)) // should print 4,2,5,1,3

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




