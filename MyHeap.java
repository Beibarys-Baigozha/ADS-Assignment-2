import java.util.ArrayList;

public class MyHeap < T extends Comparable <T> > {
    private ArrayList<T> list;

    public MyHeap() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    private int branchFirst(int k) {
        return ((k*2) + 1);
    }

    private int branchSecond(int k) {
        return (k*2) + 2;
    }

    private void heapMin(int index) {
        int min = index, branch1 = branchFirst(index), branch2 = branchSecond(index);

        if (branch1 < size() && list.get(index).compareTo(list.get(branch1)) > 0) min = branch1;

        if(branch2 < size() && list.get(min).compareTo(list.get(branch2))>0) min = branch2;

        if (min != index) {
            T temp = list.get(index);
            list.set(index, list.get(min));
            list.set(min, temp);
            System.out.println(index + " " + branch1);
            heapMin(branch1);
        }
    }

    public void insert(T item){
        list.add(item);
        if(size()==0) return;
        for (int i =(size() / 2); i >=0; i--) {
            heapMin(i);
        }
    }

    public boolean delete(T item) {
        if(list.contains(item)) {
            list.remove(item);
            for (int i = (size() / 2); i >= 0; i--) {
                heapMin(i);
            }
            return true;
        }
        return false;
    }

    public T deleteRoot() {
        T removed = list.get(0);
        list.set(0, list.get(list.size() - 1) );
        list.set(list.size() - 1, removed);
        list.remove(list.size() - 1);
        for (int i = (size() / 2); i >= 0; i--) {
            heapMin(i);
        }
        return removed;
    }

    public void printOut() {
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }
}