function LinkedList() {
  var length = 0;
  var head = null;

  var Node = function(element){
    this.element = element;
    this.next = null;
  };

  this.size = function(){
    return length;
  };

  this.head = function(){
    return head;
  };

  this.add = function(element){
    var node = new Node(element);
    if(head === null){
      head = node;
    } else {
      var currentNode = head;

      while(currentNode.next){
        currentNode  = currentNode.next;
      }

      currentNode.next = node;
    }

    length++;
  };

  // Only change code below this line----------------------------
  this.removeAt = function(index){
    if(index<0 || index >= length){
    return null;
    }
    let currentIndex = 0;
    let currentPtr = head;

    while((currentPtr)&&(index > currentIndex)){
    previousPtr = currentPtr;
    currentPtr = currentPtr.next;
    currentIndex+=1;
    }

    if(currentPtr===null){
    return null;
    }

    // otherwise, we have found the element
    if(currentPtr===head){
    head=head.next;
    length--;
    return head.element;
    }

    // the element is not the head, so remove it
    previousPtr.next = currentPtr.next;
    length--;
    return currentPtr.element;
}
  // Only change code above this line
}
