# Overview: -
“Is Graph Connected?” is one of my academic projects for the implementation of theory of computation. It is a GUI project which takes an undirected graph of maximum 5 nodes from the user and tells whether the graph is connected or not. The GUI part is done with **JavaFX Material Design** and the calculation/processing is done with the help of **Turing Machine**.
# Turing Machine: -
## Components:
I have used two tapes for this purpose:
1. **Tape for Node**: It comprise of all the cells which contains information about how many nodes are there.
2. **Tape for Edges**: It comprise of all the cells which contains information about which nodes are connected. It also stores one cell which indicates if a node is marked during its iteration
## Symbols:
   There are four symbols used in this Turing Machine:
1. Numbers (1-5): it denotes nodes in the graph
2. -88: it denotes the first cell of the graph
3. -99: since tapes are infinite in Turing Machine therefore this symbol is used to denote the blank cell of the tapes.
4. -77: It works as a breaker. My second tape stores two type of information therefore “-77” is used to separate both.
## Working:
1. First Tape (Node Tape) is created with first cell as “-88”. Other nodes are added after that according to the user.
2. Second Tape (Edge Tape) is created with first cell as “-88, -88”. Second tape uses two values for one cell: 1st Vertex, 2nd Vertex. Other Edges are added after that according to the user.
3. After all the edges are inserted two more values are stored. 
    * “-77, -77” for separating left-hand side values from the value of right-hand side.
    * “0, 0” denoting no nodes in the Node Tape are yet being marked by the algorithm.
4. Actual working starts in this step. We select one node from **Node Table** (let’s say “2”) and searches every cell of **Edge Table** if it is on either vertex. 
    * If we found (let’s say “2,3”) then we search the other vertex (3) in the Node Table if it is **marked**(i-e “-3”). If it is marked, then we go to our node in question (i-e “2”) in Node Table and mark it i-e making it negative (-2). Since we have marked one node, so we will traverse to the breaker (“-77”) in the Edge Table and change “0” to “1”.
    * if we didn’t find the node in Edge Table and reach breaker (“-77”) then we jump to step#5
5. Now we move just one cell right in Node Table but move all the way to start in Edge Table to repeat step#4 for the next node. If we have reached to the end in Node Table but the value after breaker is “1” then we will start again both tables.
6. We will keep repeating this process until we reach to the end in Node Table (i-e “-99”) and the value after “-77” in Edge Table is “0” which means no node have been marked previously thus completing our process. 
7. We always mark first node i-e 1 at the start of the process.
8. After the process is ended. We once again traverse through the Node Table to see how many nodes are marked. If all are marked, then **accept** (i-e graph is connected) otherwise **reject** (i-e graph is not connected)
9. The two processes explained above are being executed by two **Finite State Machine**
## Algorithm for First FSM:
~~~
Select first Node and Mark it
REPEAT
    For each Node N
        If (N is unmarked and there is an edge from N to an already marked node) Then,
            Mark Node N
    End
Until no more nodes can be marked
~~~
## Algorithm for Second FSM:
~~~
For each Node N
    If (N is unmarked) Then,
        REJECT
End
ACCEPT
~~~
# Data Structures Used: -
There are five major data structures used in this program:
1. **NodeTape**: It contains the reference to the first node cell and reference to the current node cell.
2. **EdgeTape**: It contains the reference to the first edge cell and reference to the current edge cell. Edge cell will contain two vertices in it.
3. **Transitions**: It contains four things.
    * **state**: which state to transition?
    * **currentData**: What data will be found in current cell of Node and Edge Tape? It will contain an array of 3 ints. 1st value will be node of Node Table and other two values will be vertices of Edge Table.
    * **newData**: What data to write in current cell of Node and Edge Tape? It will contain an array of 3 ints. 1st value will be node of Node Table and other two values will be vertices of Edge Table.
    * **direction**: Where to move next in Node and Edge Table? It will contain an array of 2 chars. 1st for the direction of Node Table and 2nd for the direction of Edge Table. There can be 3 values for one direction:
        * “r” for right
        * “l” for left
        * “n” for nothing (don’t move)
4. **FSM**: It contains five things:
    * **noOfStates**: It will tell the total number of states in the Finite State Machine.
    * **transitionState**: It is an array of arrayList of “Transitions”. It stores all the transition for the FSM.
    * **initialState**: It indicates the start point of FSM.
    * **acceptState**: It denotes the accepted state of the FSM.
    * **rejectState**: It denotes the rejected state of the FSM.
5. TuringMaching: It comprise of all the above structures. It contains two Tapes(Node and Edge) and two FSM’s as an array.
# Graphical User Interface: -
I’ve used JavaFX Material design library from JFoenix. I’ve used basic components from this library and also used FontAwesomeFX libray for better icons. Links to the library is given below:
* JFoenix – [jfoenix-8.0.4]( https://github.com/jfoenixadmin/JFoenix)
* FontAwesomeFX - [fontawesomefx-glyphsbrowser-1.3.0]( https://github.com/Jerady/fontawesomefx-glyphsbrowser)
# Some Snippets: -
   ## Adding Nodes:
   ![Adding Node GIF](https://github.com/mohebmithani/IsGraphConnected/blob/master/IsGraphConnected/images/add_node.gif)
   ## Adding Edges:
   ![Adding Node GIF](https://github.com/mohebmithani/IsGraphConnected/blob/master/IsGraphConnected/images/add_edge.gif)
   ## Getting Result:
   ![Adding Node GIF](https://github.com/mohebmithani/IsGraphConnected/blob/master/IsGraphConnected/images/result.gif)
###### Note:
* This projects works only for 5 nodes. You can easily generalize it by carefully understanding it.
* Since it is specific i'd to make 29 states for first FSM.
   

