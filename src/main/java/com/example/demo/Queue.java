package com.example.demo;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Queue {
	private static HashMap<String, ConcurrentLinkedQueue<String>> queueList = new HashMap<String, ConcurrentLinkedQueue<String>>();

	public Queue(String queueName, ConcurrentLinkedQueue<String> queue) {
		queueList.put(queueName, queue);
	}
	
	public Queue() {		
	}

	public static ConcurrentLinkedQueue<String> getQueue (String queueName) {
		if (queueList.get(queueName) != null) {
			return queueList.get(queueName);
		} else {
			ConcurrentLinkedQueue<String> novaFila = new ConcurrentLinkedQueue<>();
			queueList.put(queueName, novaFila);
			return novaFila;
		}
	}
}
