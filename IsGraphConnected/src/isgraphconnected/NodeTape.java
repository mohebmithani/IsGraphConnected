/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

/* It comprise of all the cells which contains information about how many nodes are there.
 * It is my first tape. It contains first cell of the tape and the current cell on which we are working.
 *
 * @author Moheb
 */
public class NodeTape {
    private NodeCell first;
    private NodeCell currentCell;

    public NodeTape() {
        this.first = new NodeCell(-88, null, null);
        this.currentCell = this.first;
    }

    public NodeCell getCurrentCell() 
    {
        return currentCell;
    }        
    
    public boolean isEmpty()
    {
        return this.first.getData() == -88;
    }
    
    public boolean find(int Data) 
    {
        NodeCell temp = this.first;
        if(this.isEmpty())
            return false;
        
        while(temp != null)
        {
            if(temp.getData() == Data)
                return true;
            temp = temp.getNext();
        }
      
        // not found
        return false;
    }
    
    public NodeCell Delete(int Data)
    {
        NodeCell temp = this.first;
        if(this.isEmpty())       
            return null;       
        
        while(temp != null)
        {
            if(temp.getData() == Data)
            {
                if(temp.getNext() != null)
                {
                    if(temp.getPrevious() == null)
                    {
                        temp.getNext().setPrevious(null);
                        this.first = temp.getNext();
                    }
                    else
                    {
                        temp.getPrevious().setNext(temp.getNext());
                        temp.getNext().setPrevious(temp.getPrevious());
                    }
                }
                else
                {
                    if(temp.getPrevious() != null)
                    {
                        temp.getPrevious().setNext(null);
                        temp.setPrevious(null);
                    }
                    else
                        this.first = null;
                }
                return temp;
            }
            temp = temp.getNext();
        }
      
        //NOT FOUND
        return null;
    }
    
    public void insert(int Data)
    {
        NodeCell nextCell = new NodeCell(Data, null);
        NodeCell temp = this.first;
        
        if(this.isEmpty())
        {
            nextCell.setPrevious(this.first);
            this.first.setNext(nextCell);
            this.first = nextCell;
            this.currentCell = nextCell;
            return;
        }
        
        while(temp.getNext() != null)
        {
            temp = temp.getNext();
        }
        
        nextCell.setPrevious(temp);
        temp.setNext(nextCell);
    }
    
    public void overwrite(int data)
    {
       if(this.isEmpty())
           return;
       this.currentCell.setData(data);
    }
    
    public void moveRight()
    {
        if(this.currentCell.getNext() == null)
        {
            NodeCell tempCell = new NodeCell(-99, null, this.currentCell);
            this.currentCell.setNext(tempCell);
        }
        this.currentCell = this.currentCell.getNext();
    }
    
    public void moveLeft()
    {
        if(this.currentCell.getPrevious() == null)
            return;
        this.currentCell = this.currentCell.getPrevious();
    }
}
