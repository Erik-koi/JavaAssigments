import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<T> {
    private final List<T> elements = new ArrayList<>();

    public synchronized void add(T element) {
        elements.add(element);
    }

    public synchronized int size() {
        return elements.size();
    }

    public synchronized boolean remove(T element) {
        return elements.remove(element);
    }
}
