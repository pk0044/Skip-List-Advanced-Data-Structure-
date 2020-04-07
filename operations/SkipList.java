package com.pk.operations;

import java.util.ArrayList;
import java.util.Random;

import com.pk.node.Node;

public class SkipList {
	
	Node header = null;
	Integer MAXLEVEL = 0;
	Integer level = 0;
	ArrayList<Node> update;
	
	public SkipList(Integer MAXLEVEL) {
		this.MAXLEVEL = MAXLEVEL;
		header = new Node(-1, 5);
		level = 0;
		update = new ArrayList<Node>();
		for(int i=0; i<=MAXLEVEL; i++) {
			update.add(null);
		}
		System.out.println(update.size());
	}
	
	private int getRandomNumber(int N) {
		Random random = new Random();
		return random.nextInt(N);
	}
	
	public void insert(int key) {
		Node current = header;
		for(int i=level; i>=0; i--) {
			while(current.getForward().get(i) != null && current.getForward().get(i).getKey() < key) {
				current = current.getForward().get(i);
			}
			update.set(i, current);
		}
	//	update.set(0, current);
		current = current.getForward().get(0);
		
		if(current == null || current.getKey() != key) {
			int randomLevel = getRandomNumber(MAXLEVEL);
			System.out.println("random " + randomLevel);
			if(randomLevel > level) {
				for(int i=level+1; i <= randomLevel; i++) {
					update.set(i, header);
				}
				level = randomLevel;
			}
			
			Node node = new Node(key, randomLevel);
			for(int i=0; i<=randomLevel; i++) {
				node.getForward().set(i, update.get(i).getForward().get(i));
				update.get(i).getForward().set(i, node);
			}
			System.out.println("Key : " + key + " is inserted Successfully!!");
		}
		
	}
	
	public void deleteKey(int key) {
		
	}
	
	public boolean searchKey(int key) {
		return false;
	}
	
	public void display() {
		//System.out.println("empty list");

		for(int i=level; i>=0; i--) {
			Node current = header;
//			System.out.println("level " + i + " ==> ");
			while(current != null) {
				System.out.print(current.getKey() + " ---> ");
				current = current.getForward().get(i);
			}
			System.out.println();
		}
	}
}
