package com.chapter4.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * In this when you are not allowed to modify the node class but you still need to sort it based on the node values.
 * 
 */
public class VerticalOrderII {
	
	    public List<List<Integer>> verticalTraversal(Node root) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        
	        PriorityQueue<Point> pq = new PriorityQueue<Point>(1005,new Comparator<Point>(){
	            public int compare(Point p1,Point p2){
	                if(p1.x < p2.x) return -1;
	                if(p2.x < p1.x) return 1;
	                if(p1.y > p2.y) return -1;
	                if(p1.y < p2.y) return 1;
	                return p1.val - p2.val;
	            }
	        });
	        
	        verticalTraversalHelper(root,0,0,pq);
	        Point prev = null;        
	        List<Integer> l = new ArrayList<>();
	        while(!pq.isEmpty()){
	            Point p = pq.poll();
	            if(prev == null || p.x != prev.x){
	                if(prev != null) res.add(l);
	                l = new ArrayList<>();
	            }
	            l.add(p.val);
	            prev = p;
	        }
	        
	        if(res.size() > 0) res.add(l);
	        return res;
	    }
	    
	    private void verticalTraversalHelper(Node root,int x,int y,PriorityQueue<Point> pq){
	        if(root == null) return;
	        pq.offer(new Point(x,y,root.data));
	        verticalTraversalHelper(root.left,x-1,y-1,pq);
	        verticalTraversalHelper(root.right,x+1,y-1,pq);
	    }
	}
	/**
	 * Additional class is declared as it will be used to store the height order and level order. 
	 * @author cryptonkid
	 *	x - repesents the heightOrder
	 *	y - represents the levelOrder 
	 *	Above 2 will be used to sort it.
	 */
	class Point{
		
	    int x,y,val;
	    Point(int x,int y,int val){
	        this.x = x;
	        this.y = y;
	        this.val = val;
	    }
	}

