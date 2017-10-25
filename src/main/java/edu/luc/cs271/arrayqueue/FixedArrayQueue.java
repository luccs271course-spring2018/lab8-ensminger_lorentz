package edu.luc.cs271.arrayqueue;

import java.util.*;
import java.util.ArrayList;
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

    if (size == capacity) {
      return false;
    }
    size = size + 1;
    rear = (rear + 1) % capacity;
    data[rear] = obj;
    return true;
  }

  @Override
  public E peek() {
    if (size == 0) {
      return null;
    } else {
      return data[front];
    }
  }

  @Override
  public E poll() {
    if (size == 0) {
      return null;
    }

    E result = data[front];
    front = (front + 1) % capacity;
    size = size - 1;
    // System.out.println("poll " + size);
    return result;
  }

  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
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
    if (size == 0) {
      return capacityList;
    }
    for (int i = front; i != rear; i = (i + 1) % capacity) {
      capacityList.add(data[i]);
    }
    capacityList.add(data[rear]);
    return capacityList;
  }
}
