/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

import java.util.ArrayList;

/* It is a finite state machine data structure.
 * It contains total number of states in the fsm
 * a transition table
 * an initial state
 * and accept and reject state, there is no looping condition in this.
 *
 * @author moheb
 */
public class FSM {
    private int noOfStates;
    private ArrayList<Transitions>[] transitionState;
    private final int initalState;
    private int acceptState;
    private int rejectState;

    public FSM(int noOfStates, ArrayList<Transitions>[] transitionState, int initalState, int acceptState, int rejectState) {
        this.noOfStates = noOfStates;
        this.transitionState = transitionState;
        this.initalState = initalState;
        this.acceptState = acceptState;
        this.rejectState = rejectState;
    }
    
    public int getRejectState() {
        return rejectState;
    }

    public void setRejectState(int rejectState) {
        this.rejectState = rejectState;
    }

    public int getNoOfStates() {
        return noOfStates;
    }

    public void setNoOfStates(int noOfStates) {
        this.noOfStates = noOfStates;
    }

    public ArrayList<Transitions>[] getTransitionStates() {
        return transitionState;
    }
    
    public ArrayList<Transitions> getTransitionState(int index) {
        return transitionState[index];
    }

    public void setTransitionState(ArrayList<Transitions>[] transitionState) {
        this.transitionState = transitionState;
    }

    public int getAcceptState() {
        return acceptState;
    }

    public void setAcceptState(int acceptState) {
        this.acceptState = acceptState;
    }

    public int getInitalState() {
        return initalState;
    }
    
    
    
}


