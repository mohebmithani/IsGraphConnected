/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

/* It comprise of all the cells which contains information about which nodes are connected.
 * It also stores one cell which indicates if a node is marked during its iteration
 * It is my second tape. It contains first cell of the tape and the current cell on which we are working.
 *
 * @author Moheb
 */
public class EdgeTape {
    private EdgeCell first;
    private EdgeCell currentCell;

    public EdgeTape() {
        this.first = new EdgeCell(-88, -88, null, null);
        this.currentCell = this.first;
    }

    public EdgeCell getCurrentCell() 
    {
        return currentCell;
    }        
    
    public boolean isEmpty()
    {
        return this.first.getFirstVertex() == -88;
    }
    
    public boolean find(int Data) 
    {
        EdgeCell temp = this.first;
        if(this.isEmpty())
            return false;
        
        while(temp != null)
        {
            if(temp.getFirstVertex() == Data || temp.getSecondVertex() == Data)
                return true;
            temp = temp.getNext();
        }
      
        // not found
        return false;
    }
    
    public void insert(int firstVertex, int secondVertex)
    {
        EdgeCell nextCell = new EdgeCell(firstVertex, secondVertex, null);
        EdgeCell temp = this.first;
        
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
    
    public void overwrite(int firstVertex, int secondVertex)
    {
       if(this.isEmpty())
           return;
       this.currentCell.setFirstVertex(firstVertex);
       this.currentCell.setSecondVertex(secondVertex);
    }
    
    public void moveRight()
    {
        if(this.currentCell.getNext() == null)
        {
            EdgeCell tempCell = new EdgeCell(-99, -99, null, this.currentCell);
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
