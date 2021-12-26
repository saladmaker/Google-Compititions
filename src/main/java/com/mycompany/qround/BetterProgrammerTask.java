/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qround;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Queue;

/**
 *
 * @author bilal
 */
public class BetterProgrammerTask {

    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }

    public static List<Node> traverseTreeInWidth(Node root) {
        List<Node> result = new ArrayList<Node>();
        result.add(root);
        int level = 1;
        
        boolean nothing = false;
        List<Node> chilNodes = root.getChildren();
        result.addAll(chilNodes);
        List<Node> next = new ArrayList<>();
        while(!nothing){
            
            for (Node chilNode : chilNodes) {
                next.addAll(chilNode.getChildren());
            }
            if(next.size()>0){
                nothing=true;
            }
            result.addAll(next);
            chilNodes =next;
            
        }
        return result;

    }
    public static List<String> transferFromAtoC(int n) {
        /*
          Towers Of Hanoi.
          There are three pegs: A, B and C. There are n disks. All disks are different in size.
          The disks are initially stacked on peg A so that they increase in size from the top to the bottom.
          The goal is to transfer the entire tower from the A peg to the C peg.
          One disk at a time can be moved from the top of a stack either to an empty peg or to
          a peg with a larger disk than itself on the top of its stack.

          The method should return a sequence of disk moves, each move is a String with two letters (A, B or C)
          corresponding to the peg the disk moves from and the peg it moves to.
          For example, the move "AC" means that a top disk from peg A should be moved to peg C.
         */
        List<String> result =new ArrayList<>();
        for(int counter = n; counter>0; counter--){
            
        }
        /*
        
        
        1234
        5
        -
        123
        5
        4
        
        123
        -
        45
        
        12
        3
        45
        
        125
        3
        4
        
        125
        34
        -
        
        12
        345
        -
        
        1
        345
        2
        
        1
        34
        25
        
        14
        3
        25
        
        145
        3
        2
        
        145
        -
        23
        
        14
        5
        23
        
        1
        5
        234
        
        1
        -
        2345
        
        -
        1
        2345
        */
        /*
        
        */
        return null;
    }

    
}
