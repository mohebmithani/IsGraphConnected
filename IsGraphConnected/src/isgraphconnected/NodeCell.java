/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

/* It is the cell of first tape known as 'Node Cell'. It stores number of nodes in the graph.
 * Further it contains the reference of the adjacent cell forward and backward for easy traversal.
 *
 * @author Moheb
 */
public class NodeCell {
    private int data;
    private NodeCell next;
    private NodeCell previous;
    
    public NodeCell() {
        this.data = 0;
        this.next = null;
        this.previous = null;
    }
    
    public NodeCell(int data, NodeCell next) {
        this.data = data;
        this.next = next;
        this.previous = null;
    }
    
    public NodeCell(int data, NodeCell next, NodeCell previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeCell getNext() {
        return next;
    }

    public void setNext(NodeCell next) {
        this.next = next;
    }
    
    public NodeCell getPrevious() {
        return this.previous;
    }
    
    public void setPrevious(NodeCell previous) {
        this.previous = previous;
    }
}
