class MyCircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularQueue(int k) {

        queue = new int[k];
        capacity = k;

        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {

        // Check if queue is full
        if (isFull()) {
            return false;
        }

        // Move rear circularly
        rear = (rear + 1) % capacity;

        queue[rear] = value;
        size++;

        return true;
    }

    public boolean deQueue() {

        // Check if queue is empty
        if (isEmpty()) {
            return false;
        }

        // Move front circularly
        front = (front + 1) % capacity;

        size--;

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}


