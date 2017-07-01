package com.example.demo;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Receiver implements Runnable {
	private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
	
	public Receiver (String queueName) {
		this.queue = Queue.getQueue(queueName);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			String mensagem = queue.poll();
			if(mensagem != null) {
				System.out.println("Mensagem na fila: " + mensagem);
			} else {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
