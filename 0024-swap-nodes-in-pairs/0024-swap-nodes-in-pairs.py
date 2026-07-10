class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Create a dummy node to point to the head of the list
        dummy = ListNode(0)
        dummy.next = head
        
        # 'prev' tracks the node right before the pair we are swapping
        prev = dummy
        
        while prev.next and prev.next.next:
            # Identify the two nodes to be swapped
            first = prev.next
            second = prev.next.next
            
            # Perform the swap by adjusting the pointers
            first.next = second.next
            second.next = first
            prev.next = second
            
            # Move 'prev' two nodes ahead for the next pair
            prev = first
            
        return dummy.next