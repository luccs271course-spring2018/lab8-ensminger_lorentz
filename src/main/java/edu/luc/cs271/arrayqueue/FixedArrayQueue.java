package edu.luc.cs271.arrayqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private int capacity;

  private int size;

  private int front;

  private int rear;

  private E[] data;

  // TODO why do we need an explicit constructor?
	

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;
  }

  @Override
  public boolean offer(final E obj) {
    if(size == capacity)
	{
		int newCapacity = 2 * capacity;
		E[] newData = (E[]) new Object[newCapacity];
		int j = front;
		for(int i = 0; i < size; i++)
		{
			newData[i] = data[i];
			j = (j+1) % capacity;
		}
		front = 0;
		rear = size -1; 
		capacity = newCapacity;
		data = newData;
	}
	size = size + 1;
	rear = (rear + 1) % capacity;
	data[rear] = obj;
	return true;
  }

  @Override
  public E peek() {
    if(size == 0){
		return null;
	}
    else{
		return data[front];
	}
  }

  @Override
  public E poll() {
   	if(size == 0){
		return null;
	}
	 else{
    		E result = data[front];
		 	front = (front + 1)%capacity;
		 size = size - 1;
		 return result;
	 }
  }

  @Override
  public boolean isEmpty() {
    if((int)data[front] == 0)
	{
    return true;
	}
	  else{
		  return false;
	  }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<E> asList() {
    // TODO implement using an ArrayList preallocated with the right size
	  ArrayList<E> capacityList = new ArrayList<>(size);
	  for(int i = 0; i < size; i++)
	  {
		  capacityList.add(data[i]);
	  }
    return Arrays.asList();
  }
}
