package controller;

import java.util.concurrent.Semaphore;

public class cruzamento extends Thread {
	private Semaphore smf;
	private int carro;
	private String sentido;
	
	public cruzamento (int _carro, Semaphore _smf) {
		this.carro = _carro;
		this.smf = _smf;
	}
	
	@Override
	public void run() {
		try {
			smf.acquire();
			preferencia();
			System.out.println("O carro "+ carro + " recebeu preferência, e seguiu para a " + sentido);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			smf.release();
		}
	}
	
	public void preferencia() {
		switch (carro) {
		case 1:
			sentido= "cima";
			break;
		case 2:
			sentido= "baixo";
			break;
		case 3:
			sentido= "direita";
			break;
		case 4:
			sentido= "esquerda";
			break;
		}
	}
}
