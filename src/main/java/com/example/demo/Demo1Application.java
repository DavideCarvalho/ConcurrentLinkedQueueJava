package com.example.demo;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Demo1Application.class, args);
		String NOME_DA_FILA = "Teste";
		System.out.println("Iniciando Teste de ConcurrentLinkedQueue");

		Queue queue = new Queue(NOME_DA_FILA, new ConcurrentLinkedQueue<String>());

		Runnable receptor = new Receiver(NOME_DA_FILA);
		Thread t1 = new Thread(receptor);
		t1.start();
		
		Producer producer = new Producer(NOME_DA_FILA);
		Thread t2 = new Thread(producer);
		t2.start();
		
		System.out.println("Finalizando teste de ConcurrentLinkedQueue");
	}
}
