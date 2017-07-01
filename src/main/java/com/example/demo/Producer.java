package com.example.demo;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.example.demo.Queue;

public class Producer implements Runnable {
	ConcurrentLinkedQueue<String> fila = new ConcurrentLinkedQueue<String>();

	public Producer(String queueName) {
		fila = Queue.getQueue(queueName);
	}

	@Override
	public void run() {
		int contador = 1;
		while (true) {
			try {
				Thread.sleep(2000);
				fila.offer("Teste " + contador);
				contador++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
