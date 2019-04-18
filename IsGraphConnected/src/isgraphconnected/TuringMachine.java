/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isgraphconnected;

/* It is the main point where everything joins. 
 * It uses two tapes and two finite state machines and work according to the principal of turing machine to validate the graph.
 *
 * @author moheb
 */
public class TuringMachine {
    NodeTape nodeTape;
    EdgeTape edgeTape;
    FSM[] fsm;

    public TuringMachine(NodeTape nodeTape, EdgeTape edgeTape, FSM[] fsm) {
        this.nodeTape = nodeTape;
        this.edgeTape = edgeTape;
        this.fsm = fsm;
    }
    
    public boolean execute()
    {
        validate(fsm[0].getInitalState(), 0); // it marks the appropriate nodes which are connected
        return validate(fsm[1].getInitalState(), 1); // after above finite state machine, it checks if all are marked or not and give the results
    }
    
    public boolean validate(int state, int fsm_i)
    {
        int newState = transition(state, fsm_i);
        
        if(newState == fsm[fsm_i].getAcceptState())
            return true;
        else if(newState == fsm[fsm_i].getRejectState() || newState == -1)
            return false;
        else
           return validate(newState, fsm_i);
    }
    
    public int transition(int curentState, int fsm_i)
    {
        int index = -1;
        for (int i = 0; i < fsm[fsm_i].getTransitionState(curentState).size(); i++) 
        {
            if((nodeTape.getCurrentCell().getData() == fsm[fsm_i].getTransitionState(curentState).get(i).getCurrentData(0)) && (edgeTape.getCurrentCell().getFirstVertex() == fsm[fsm_i].getTransitionState(curentState).get(i).getCurrentData(1)) && (edgeTape.getCurrentCell().getSecondVertex() == fsm[fsm_i].getTransitionState(curentState).get(i).getCurrentData(2)))
            {
                index = fsm[fsm_i].getTransitionState(curentState).get(i).getState();
                nodeTape.getCurrentCell().setData(fsm[fsm_i].getTransitionState(curentState).get(i).getNewData(0));
                edgeTape.getCurrentCell().setFirstVertex(fsm[fsm_i].getTransitionState(curentState).get(i).getNewData(1));
                edgeTape.getCurrentCell().setSecondVertex(fsm[fsm_i].getTransitionState(curentState).get(i).getNewData(2));
                
                char d1 = fsm[fsm_i].getTransitionState(curentState).get(i).getDirection(0);
                char d2 = fsm[fsm_i].getTransitionState(curentState).get(i).getDirection(1);
                
                if(d1 == 'r')
                    nodeTape.moveRight();
                else if(d1 == 'l')
                    nodeTape.moveLeft();
                
                if(d2 == 'r')
                    edgeTape.moveRight();
                else if(d2 == 'l')
                    edgeTape.moveLeft();
                break;
            }
        }
        
        return index;
    }
}
