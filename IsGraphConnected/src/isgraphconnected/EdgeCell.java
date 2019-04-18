/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

/* It is the cell of second tape known as 'Edge Cell'. It stores the number of both nodes which are connected.
 * Further it contains the reference of the adjacent cell forward and backward for easy traversal.
 *
 *
 * @author Moheb
 */
public class EdgeCell {
    private int firstVertex;
    private int secondVertex;
    private EdgeCell next;
    private EdgeCell previous;
    
    public EdgeCell() {
        this.firstVertex = 0;
        this.secondVertex = 0;
        this.next = null;
        this.previous = null;
    }
    
    public EdgeCell(int firstVertex, int secondVertex, EdgeCell next) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.next = next;
        this.previous = null;
    }
    
    public EdgeCell(int firstVertex, int secondVertex, EdgeCell next, EdgeCell previous) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.next = next;
        this.previous = previous;
    }

    public int getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(int firstVertex) {
        this.firstVertex = firstVertex;
    }

    public int getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(int secondVertex) {
        this.secondVertex = secondVertex;
    }

    public EdgeCell getNext() {
        return next;
    }

    public void setNext(EdgeCell next) {
        this.next = next;
    }
    
    public EdgeCell getPrevious() {
        return this.previous;
    }
    
    public void setPrevious(EdgeCell previous) {
        this.previous = previous;
    }

    
}
