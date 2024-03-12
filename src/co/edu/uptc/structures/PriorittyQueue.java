package co.edu.uptc.structures;

public class PriorittyQueue<T> {
    private MyQueue[] queues;

    public PriorittyQueue(int level) {
        this.queues = new MyQueue[level];
        for (int i = 0; i < level; i++) {
            queues[i] = new MyQueue<>();
        }
    }

    public void push(T data, int levelPriority) {
        if (levelPriority < queues.length) {
            queues[levelPriority].push(data);
        }
    }

    public T pull() {
        for (MyQueue<T> queue : queues) {
            if (!queue.isEmpty()) {
                return queue.poll();
            }
        }
        return null;
    }

    public T peek() {
        for (MyQueue<T> queue : queues) {
            if (!queue.isEmpty()) {
                return queue.peek();
            }
        }
        return null;
    }

    public boolean isEmpty() {
        for (MyQueue<T> queue : queues) {
            if (!queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }


}
