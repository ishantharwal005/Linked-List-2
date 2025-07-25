// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
// For example, the following two linked lists begin to intersect at node c1:
// The test cases are generated such that there are no cycles anywhere in the entire linked structure. Note that the linked lists must retain their original structure after the function returns.

// Custom Judge:
// The inputs to the judge are given as follows (your program is not given these inputs):
// intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
// listA - The first linked list.
// listB - The second linked list.
// skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
// skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
// The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

// Example 1:

// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
// Output: Intersected at '8'
// Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
// From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
// - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references.
// In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// TC: O(m + n) | SC: O(1)
public class InterectionOfTwoLLs {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either list is empty, there is no intersection
        if (headA == null || headB == null){
            return null;
        }

        // Calculating length of List A
        ListNode currA = headA;
        int lenA = 0;
        while (currA != null){
            currA = currA.next;
            lenA++;
        }

        // Calculating length of List B
        ListNode currB = headB;
        int lenB = 0;
        while (currB != null){
            currB = currB.next;
            lenB++;
        }

        // Resetting the pointers to the heads
        currA = headA;
        currB = headB;

        // Advancing the pointers of the longer list by the length difference
        while (lenA > lenB){
            currA = currA.next;
            lenA--;
        }

        while (lenB > lenA){
            currB = currB.next;
            lenB--;
        }

        // Traversing both the lists together until a common node is found
        while (currA != currB){
            currA = currA.next;
            currB = currB.next;
        }

        // Either both are null (no intersection) or both are at the intersection node
        return currA;
    }
}