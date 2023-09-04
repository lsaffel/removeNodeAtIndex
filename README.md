From a freecodecamp problem at:

https://www.freecodecamp.org/learn/coding-interview-prep/data-structures/remove-elements-from-a-linked-list-by-index

**Remove Elements from a Linked List by Index**

Before we move on to another data structure, let's get a couple of last bits of practice with linked lists.

Let's write a removeAt method that removes the element at a given index. The method should be called removeAt(index). To remove an element at a certain index, we'll need to keep a running count of each node as we move along the linked list.

A common technique used to iterate through the elements of a linked list involves a 'runner', or sentinel, that 'points' at the nodes that your code is comparing. In our case, starting at the head of our list, we start with a currentIndex variable that starts at 0. The currentIndex should increment by one for each node we pass.

Just like our remove(element) method, which we covered in a previous lesson, we need to be careful not to orphan the rest of our list when we remove the node in our removeAt(index) method. We keep our nodes contiguous by making sure that the node that has reference to the removed node has a reference to the next node.
Write a removeAt(index) method that removes and returns a node at a given index. The method should return null if the given index is either negative, or greater than or equal to the length of the linked list.

Note: Remember to keep count of the currentIndex.

---------------------------------------------------------------------

My code works on paper, I believe, but the freecodecamp page does not accept that my solution works, for most cases. I'm not sure why.

Their freecodecamp solution:

function LinkedList() {
  let head   = null;
  let length = 0;

  function Node(element) {
    this.element = element;
    this.next    = null;
  };

  this.size = function() {
    return length;
  };

  this.head = function() {
    return head;
  };

  this.add = function(element) {
    let node = new Node(element);
    if (head === null) {
      head = node;
    } else {
      let currentNode = head;
      while (currentNode.next) {
        currentNode  = currentNode.next;
      }
      currentNode.next = node;
    }
    length++;
  };

  // Only change code below this line ------------------------------------------------
  
  this.removeAt = function(index) {
    // Exit early on bad input
    if (index < 0 || index >= length) {
      return null;
    }

    // Find deleted node and remove
    let deletedNode = head;
    if (index == 0) {
      head = null;
    } else {
      let currentNode  = head;
      let currentIndex = 0;
      while (currentIndex < index - 1) {
        currentNode = currentNode.next;
        currentIndex++;
      }
      deletedNode      = currentNode.next;
      currentNode.next = deletedNode.next;
    }

    // Update and return
    length--;
    return deletedNode.element;
  }
  // Only change code above this line ------------------------------------------------
}
