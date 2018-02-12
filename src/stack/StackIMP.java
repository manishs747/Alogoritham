package stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackIMP<E> {
	
	protected Object[] elementData;
	protected int elementCount;
	protected transient int modCount = 0;
	
	public static void main(String[] args) {
		 Stack<Integer> st = getJavaStack();
		 while (!st.empty()) {
			 System.out.print(st.pop());
		}
		 
	}
	
	 /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack (the last item
     *          of the <tt>Vector</tt> object).
     * @throws  EmptyStackException  if this stack is empty.
     */
    public synchronized E peek() {
        int     len = elementData.length;;

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }
    
    public synchronized E pop() {
        E       obj;
        int     len = elementData.length;

        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }
    
    public synchronized void removeElementAt(int index) {
        modCount++;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                     elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null; /* to let gc do its work */
    }
    
    public synchronized int size() {
        return elementCount;
    }
    
    public synchronized E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }

        return elementAt(index);
    }


	public static Stack<Integer> getJavaStack() {
		Stack<Integer> st = new Stack<Integer>();
	    // System.out.println("stack: " + st);
	     st.push(new Integer(1));
	     st.push(new Integer(3));
	     st.push(new Integer(5));
	    
	 /*    System.out.println(st);
	     Integer a = (Integer) st.pop();
	     System.out.println(a);
	     System.out.println("stack: " + st);*/;
	     
	     return st;
	}

  
}

