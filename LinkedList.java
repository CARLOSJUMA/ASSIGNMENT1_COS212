public class LinkedList {
    public CoordinateNode head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(int x, int y) {
        CoordinateNode node = new CoordinateNode(x, y);
        head = node;
    }

    private CoordinateNode recursiveAppend(CoordinateNode currNode, int x, int y) {
        if (head == null) {
            head = new CoordinateNode(x, y);
            return head;
        }
    
        if (currNode.next == null) {
            currNode.next = new CoordinateNode(x, y);
            return currNode.next;
        }
    
        currNode.next = recursiveAppend(currNode.next, x, y);
        return currNode;
    }
    
    
    public void append(int x, int y) {
        recursiveAppend(head, x, y);
    }

    private void recursiveAppendList( CoordinateNode other, CoordinateNode currNode){
        if(currNode.next == null){
            currNode.next = other;
        }

        else{
            recursiveAppendList(other, currNode.next);
        }
    }
 

    public void appendList(LinkedList other) {
        if(other.head == null){
            return;
        }
        else if(this.head == null){
            this.head = other.head;
            return;
        }
        CoordinateNode toAppend = other.head;
        recursiveAppendList(toAppend, head);
    }

    private boolean search(int x, int y, CoordinateNode currNode){
        if(currNode == null){
            return false;
        }

        if(currNode.x == x && currNode.y == y ){
            return true;
        }

        return search(x, y, currNode.next);
}

    public boolean contains(int x, int y) {
        if(search(x, y, head)){
            return true;
        }
        return false;
    }

    private String ConvertLL(CoordinateNode currNode, String returnString){
        if(currNode.next == null){
            returnString += "["+currNode.x+","+currNode.y+"]";
            return returnString;
        }
        else{
            returnString += "["+currNode.x+","+currNode.y+"]"+" -> ";
        }

        return ConvertLL(currNode.next, returnString);
    }

    @Override
    public String toString() {
        if(head==null){
            return "Empty List";
        }
        String returnString = "";
        CoordinateNode currNode = head;
        return ConvertLL(currNode, returnString);
    }

    private int counter(CoordinateNode currNode, int count){
        if(currNode == null){
            return count ;
        }
        else{
            count+=1;
        }
        return counter(currNode.next, count);
    }

    public int length() {
        return counter(head, 0);
    }

    private CoordinateNode recursiveCopyReverse(CoordinateNode current, CoordinateNode previous) {
        if (current == null) {
            return previous; 
        }
        CoordinateNode newNode = new CoordinateNode(current.x, current.y); 
        newNode.next = previous; 
        return recursiveCopyReverse(current.next, newNode);
    }

    public LinkedList reversed() {
        LinkedList reversedList = new LinkedList(); 
        reversedList.head = recursiveCopyReverse(this.head, null); 
        return reversedList;
    }
}
