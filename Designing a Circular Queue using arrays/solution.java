class MyCircularQueue {
    int[] q;
    int f,r;
    public MyCircularQueue(int k) {
       q=new int[k];
       Arrays.fill(q,-1); //let's denote empty positions witb -1
       f=-1;  
       r=-1;  //there are no elements in the queue
    }
    
    public boolean enQueue(int value) {
        if(f==-1 && r==-1)    //there are no elements in the queue
        {
            f++;
            r++;
            q[f]=value;
            return true;
        }
        else if(r+1<q.length && q[r+1]==-1) //when rear points to position < length
        {
            r++;
            q[r]=value;
            return true;
        }
        else if(r+1==q.length && q[0]==-1)  //when rear reaches end of array ,you can insert element at begin if its is empty
        {
            r=0;
            q[r]=value;
            return true;
        }
        
        return false;
        
    }
    
    public boolean deQueue() {
        if(isEmpty()) //when q is empty
            return false;
        
        int val=q[f];
        q[f]=-1;
        if(f==r)  //when the front and rear points to same position but now it's removed let's reset the pointers
        {
            f=-1;
            r=-1;
        }
        else if(f+1==q.length)    //when front reached end of array and there are elements in the begin of the array
        {
            f=0;
        }
        else 
            f++;
        return true;  //since q is not empty the operation will be successful
    }
    
    public int Front() {
        if(isEmpty())   //when q is empty
            return -1;
        return q[f];    //return element that's pointed by front pointer
    }
    
    public int Rear() {
        if(isEmpty()) //when q is empty
            return -1;
        return q[r];  //return recently entered element 
    }
    
    public boolean isEmpty() {
            return f==-1; //only when front doesn't point to any element
    }
    
    public boolean isFull() {
        if(f==0 && r==q.length-1) //when rear reaches end of array and front still stands at begin of the array
            return true;
        if(r+1==f)  //rear has come to front and there's no empty space for new element and queue is Full
            return true;
        return false;
    }
}

