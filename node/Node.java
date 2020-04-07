package com.pk.node;

import java.util.ArrayList;

public class Node {
	
	private Integer key;
	private ArrayList<Node> forward = new ArrayList<Node>();
	
	public Node(int key, int level) {
		this.key = key;
		for(int i=0; i <= level; i++) {
			forward.add(null);
		}
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public ArrayList<Node> getForward() {
		return forward;
	}

	public void setUpdate(ArrayList<Node> forward) {
		this.forward = forward;
	}
	


	
}
