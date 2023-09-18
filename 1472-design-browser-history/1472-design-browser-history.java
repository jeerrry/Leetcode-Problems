class Node {
    public String url;
    public int step;
    public Node next = null;
    public Node prev = null;
    
    public Node(String url, int step) {
        this.url = url;
        this.step = step;
    }
}

class BrowserHistory {
    private Node head;
    private Node tail;
    private Node currentUrlNode;
    private int length;

    public BrowserHistory(String homepage) {
        Node temp = new Node(homepage, 1);
        head = temp;
        tail = temp;
        currentUrlNode = temp;
        length = 1;
    }
    
    public void visit(String url) {
        Node temp = new Node(url, currentUrlNode.step + 1);
        currentUrlNode.next = temp;
        temp.prev = currentUrlNode;
        tail = temp;
        currentUrlNode = temp;
        length = temp.step;
    }
    
    public String back(int steps) {
        if(steps >= currentUrlNode.step) {
            currentUrlNode = head;
            return currentUrlNode.url;
        }
        
        for(int i=0; i<steps; i++) {
            currentUrlNode = currentUrlNode.prev;
        }
        
        return currentUrlNode.url;
    }
    
    public String forward(int steps) {
        if(steps + currentUrlNode.step >= length)  {
            currentUrlNode = tail;
            return currentUrlNode.url;
        }
        
        for(int i=0; i<steps; i++) {
            currentUrlNode = currentUrlNode.next;
        }
        
        return currentUrlNode.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */