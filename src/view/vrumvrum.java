package view;

import java.util.concurrent.Semaphore;

import controller.cruzamento;

public class vrumvrum {

	public static void main(String[] args) {
		int carro = 4;
		Semaphore smf = new Semaphore(1);
		
		for (int i = 1; i <= carro; i++) {
			new cruzamento(i, smf).start();
		}
	}

}
