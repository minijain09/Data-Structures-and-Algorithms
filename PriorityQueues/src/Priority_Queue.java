import java.util.ArrayList;

public class Priority_Queue {

	private ArrayList<Integer> heap;

	public Priority_Queue() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty(){
		return heap.size() == 0;
	}

	int size(){
		return heap.size();
	}

	int getMin() throws PriorityQueueException{
		if(isEmpty()){
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element){
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while(childIndex > 0){
			if(heap.get(childIndex) < heap.get(parentIndex)){
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}else{
				return;
			}
		}
	}
	
	int removeMin() throws PriorityQueueException {
		// Complete this function
		// Throw the exception PriorityQueueException if queue is empty
      if (isEmpty())
      {
        throw new PriorityQueueException();
      }
      int ans=heap.get(0);
      int last=heap.get(heap.size()-1);
      heap.set(0,last);
      heap.remove(heap.size()-1);
      //Down heapify starts
      int parentindex=0;
      int childindex1=1;
      int childindex2=2;
      while (childindex1<heap.size())
      {
        int min=-1;
        if (childindex1<heap.size() && childindex2<heap.size())
          min=Math.min(heap.get(childindex1),Math.min(heap.get(childindex2),heap.get(parentindex)));
        else if (childindex1<heap.size())
          min=Math.min(heap.get(parentindex),heap.get(childindex1));
        if (childindex1<heap.size() && min==heap.get(childindex1))
            {
              int temp=heap.get(parentindex);
              heap.set(parentindex,heap.get(childindex1));
              heap.set(childindex1,temp);
              parentindex=childindex1;
              childindex1=parentindex*2+1;
              childindex2=parentindex*2+2;
            }
        else if (childindex2<heap.size() && min==heap.get(childindex2))
        {
              int temp=heap.get(parentindex);
              heap.set(parentindex,heap.get(childindex2));
              heap.set(childindex2,temp);
              parentindex=childindex2;
              childindex1=parentindex*2+1;
              childindex2=parentindex*2+2;
        }
        else
          break;
      } 
      return ans;
	}
	
	int removeMinBetter() throws PriorityQueueException{
		if(isEmpty()){
			// Throw an exception
			throw new PriorityQueueException();
		}
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		int index = 0;
		int minIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;

		while(leftChildIndex < heap.size()){

			if(heap.get(leftChildIndex) < heap.get(minIndex)){
				minIndex = leftChildIndex;
			}
			if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)){
				minIndex = rightChildIndex;
			}
			if(minIndex == index){
				break;
			}else{
				int temp1 = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp1);
				index = minIndex;
				leftChildIndex = 2 * index + 1;
				rightChildIndex = 2 * index + 2;
			}
		}
		return temp;

	}
}









