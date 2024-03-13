package co.edu.uptc.structures;

public class PriorittyQueue<T> {
    private MyQueue<T>[] queues;

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
        int count = 0;
        MyQueue<T> queueAux = new MyQueue<>();
        for (MyQueue<T> queue : queues) {
            if (!queue.isEmpty() && count == 0) {
                count++;
                queueAux = queue;

            }
        }
        return queueAux.poll();
    }

    public T peek() {
        int count = 0;
        MyQueue<T> queueAux = new MyQueue<>();
        for (MyQueue<T> queue : queues) {
            if (!queue.isEmpty()&& count == 0) {
                count++;
                queueAux = queue;

            }
        }
        return queueAux.peek();
    }

    public boolean isEmpty() {
        boolean verification = false;
        for (MyQueue<T> queue : queues) {
            if (!queue.isEmpty()) {
                verification = false;
            }
        }
        return verification;
    }


}
