package main

import (
	"fmt"
)

func main() {

	/** sample input
		10
		1 97
		2
		1 20
		2
		1 26
		1 20
		2
		3
		1 91
		3
	 */

	/** sample output
		26
		91
	 */

	var stack []int
	var stack_len int
	var tryCnt, in1, in2 int

	fmt.Scan(&tryCnt)
	for i := 0; i < tryCnt; i++ {
		n, _ := fmt.Scanln(&in1, &in2)

		switch n {
		case 1:
			if in1 == 2 {
				if stack_len > 0 {
					stack_len-- // Top element
					stack = stack[:stack_len] // pop
				}
			} else {
				var max, maxPos int
				for j := 0; j < stack_len; j++ {
					if max < stack[j] {
						max = stack[j]
						maxPos = j
					}
				}
				fmt.Println(stack[maxPos]) // peak
			}
		case 2:
			stack = append(stack, in2) // push
			stack_len++
		}
	}
}