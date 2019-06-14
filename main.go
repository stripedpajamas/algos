package main

import (
	"fmt"
	"math"
	"math/rand"
	"time"
)

type LinkedNode struct {
	next *LinkedNode
	val  int
}

func main() {
	fmt.Println(reverseString("peter"))
	printNumber(12345)

	rand.Seed(time.Now().UnixNano())
	head := createListOfRandoms()
	newHead := removePrimes(head)
	printLinkedList(newHead)
}

// needs to be recursive
func reverseString(s string) string {
	var reverse func(string, string) string
	reverse = func(output string, input string) string {
		if len(input) == 0 {
			return output
		}
		last := input[len(input)-1:]
		next := input[:len(input)-1]
		return reverse(output+last, next)
	}

	return reverse("", s)
}

// print one digit per line without stringifying n
func printNumber(n int) {
	var isolateDigits func(int, []int) []int
	isolateDigits = func(m int, out []int) []int {
		if m == 0 {
			return out
		}
		return isolateDigits(m/10, append(out, m%10))
	}

	out := isolateDigits(n, make([]int, 0))
	for i := len(out) - 1; i >= 0; i-- {
		fmt.Println(out[i])
	}
}

// given a linked list of numbers, remove the primes
func removePrimes(head *LinkedNode) *LinkedNode {
	isPrime := func(n int) bool {
		if n < 4 && n > 1 {
			return true
		}
		if n%2 == 0 {
			return false
		}
		sqrt := int(math.Ceil(math.Sqrt(float64(n))))
		for i := 3; i <= sqrt; i += 2 {
			if n%i == 0 {
				return false
			}
		}
		return true
	}
	newHead := head
	var prev *LinkedNode
	current := head
	for current != nil {
		if isPrime(current.val) {
			if prev == nil {
				// head is prime
				newHead = current.next
			} else {
				prev.next = current.next
			}
			current = current.next
			continue
		}
		prev = current
		current = current.next
	}

	return newHead
}

// utils for testing
func createListOfRandoms() *LinkedNode {
	length := rand.Intn(100)
	head := new(LinkedNode)
	current := head
	for i := 0; i < length; i++ {
		current.val = int(rand.Int31())
		current.next = new(LinkedNode)
		current = current.next
	}
	// end of loop, current has no val
	current.val = rand.Int()

	return head
}

func printLinkedList(head *LinkedNode) {
	allValues := make([]int, 0)
	current := head
	for current != nil {
		allValues = append(allValues, current.val)
		current = current.next
	}

	// might as well check primality while here
	isPrime := func(n int) bool {
		if n < 4 && n > 1 {
			return true
		}
		if n%2 == 0 {
			return false
		}
		sqrt := int(math.Ceil(math.Sqrt(float64(n))))
		for i := 3; i <= sqrt; i += 2 {
			if n%i == 0 {
				return false
			}
		}
		return true
	}
	valid := true
	for _, n := range allValues {
		if isPrime(n) {
			fmt.Println("Prime still in list:", n)
			valid = false
		}
	}
	fmt.Println(allValues)
	if valid {
		fmt.Println("All values composite")
	}
}
