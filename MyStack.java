import java.util.LinkedList;

public class MyStack < T extends Comparable<T> > {
    private LinkedList<T> stackNode;

    public MyStack()  {
        stackNode = new LinkedList<T>();
    }

    public int size() {
        return stackNode.size();
    }

    public boolean empty() {
        return (this.size() == 0) ? true : false;
    }

    public T push(T newItem){
        stackNode.add(newItem);
        return newItem;
    }

    public T pop() {
        return stackNode.remove(size() - 1);
    }

    public T peek() {
        return stackNode.get(size() - 1);
    }
}
