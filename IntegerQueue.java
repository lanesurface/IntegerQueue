
/**
 * A simple array-based implementation of an Integer queue
 * 
 * @version 1.0
 * @author Lane
 *
 */
public class IntegerQueue
{
	public int size;
	private int front, rear;
	private Integer queueArray[];
	
	/**
	 * Construct a new IntegerQueue with the default size of 10
	 */
	public IntegerQueue()
	{
		this(10);
	}
	/**
	 * Construct a new IntegerQueue with the specified size
	 * @param size The size of the queue array
	 */
	public IntegerQueue(int size)
	{
		if (size == 0) throw new IllegalArgumentException("You must specify a size greater than zero.");
		else
		{
			this.size = size;
			front = 0;
			rear = size;
			queueArray = new Integer[size];
		}
	}
	/**
	 * Appends an element to the queue
	 * @param i The integer to append to the queue
	 * @return The position of the appended element, returns -1 if the operation failed
	 */
	public int enqueue(Integer i)
	{
		if ((rear + 1) % size == front) return -1;
		else if (isEmpty())
			front = rear = 0;
		else rear = (rear + 1) % size;
		queueArray[rear] = i;
		return rear;
	}
	/**
	 * Removes the front-most element from the queue
	 * @return The position of the element removed, returns -1 if the operation failed
	 */
	public int dequeue()
	{
		int previousFront = front; // For returning the index of the element we just popped
		if (isEmpty()) return -1;
		else if (front == rear) front = rear = -1;
		else front = (front + 1) % size;
		return previousFront;
	}
	/**
	 * Checks to see if the queue is empty
	 * @return The state of the elements in the queue
	 */
	public boolean isEmpty()
	{
		if (front == -1 && rear == -1) return true;
		else return false;
	}
	/**
	 * Get's the element at the front of the queue without removing it
	 * @see #enqueue
	 * @return The front-most element
	 */
	public Integer front()
	{
		if (front != -1) return queueArray[front];
		else throw new IllegalAccessError("Failed to fetch the front, the IntegerQueue is empty.");
	}
}
