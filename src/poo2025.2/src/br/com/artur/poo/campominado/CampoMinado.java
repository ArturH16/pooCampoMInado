package br.com.artur.poo.campominado;

public class CampoMinado {
	public static void main(String args[]) {
		/*Espaco e1 = new Espaco();
		Espaco e2 = new Espaco();
		e1.adicionarVizinhos(e2);
		e2.minar();
		System.out.println(e1.clicar());*/
		
		Campo c  = new Campo();
		c.adicionarMinas();
		JFrameCampo f = new JFrameCampo(c);
		System.out.println(c);
	}

}
