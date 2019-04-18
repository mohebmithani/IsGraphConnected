/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

/* It is a transition table for finite state machine.
 * It tells where next state is?
 * how will node tape and edge tape will move(right or left or nowhere)
 * what changes will be made on current cell of edge and node tape.
 *
 * @author moheb
 */
public class Transitions {
    private int state;
    private int[] currentData, newData; // each array comprise of three elements.(data for node tape, right vertex for edge tape, left vertex for edge tape)
    private char[] direction; // it contains two values for node and edge tape. values can be 'r', 'l', 'n'
    
    public Transitions(int state, int[] currentData, int[] newData, char[] direction) 
    {
        this.state = state;
        this.currentData = currentData;
        this.newData = newData;
        this.direction = direction;
    }
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    public int getCurrentData(int i) {
        return this.currentData[i];
    }
    
    public void setCurrentData(int i, int data) {
        this.currentData[i] = data;
    }

    public int getNewData(int i) {
        return this.newData[i];
    }
    
    public void setNewData(int i, int data) {
        this.newData[i] = data;
    }
    
    public char getDirection(int i) {
        return this.direction[i];
    }
    
    public void setDirection(int i, char direction) {
        this.direction[i] = direction;
    }
}
