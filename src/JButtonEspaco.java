package br.com.artur.poo.campominado;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public final class JButtonEspaco extends JButton implements Recomeco {
	private int i; // linha
	private int j; // coluna
	 private Campo c;
	private Espaco e;
	private JFrameCampo campoGrafico;
	private String text;

	public JButtonEspaco(Campo c, JFrameCampo cg) {
		text = "";
		this.campoGrafico = cg;
		this.setText(text);
		setText("");
	    setMargin(new java.awt.Insets(0, 0, 0, 0));
	    setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
		this.c = c;
		this.addActionListener((java.awt.event.ActionEvent evt) -> { 
		botaoPressionado(false);
		});
		this.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mousePressed(java.awt.event.MouseEvent e) {

		        if (javax.swing.SwingUtilities.isRightMouseButton(e)) {
		            botaoPressionado(true);
		        }

		    }
		}
		);
	}
	
	public JButtonEspaco () {};
	@Override
	public void reset() {
		this.e.reset();
		this.text = "";
		this.setText(text);
		this.setEnabled(true);
	}

	//Adição desse escutador para ele detectar quando um quadradinho for clicado

	private void botaoPressionado(boolean mouseBotaoDireito) {
		// Quando o botão for pressionado, vai alterá-lo visualmente
		
		// se clicar no botão esquerdo do mouse -> REVELAR
		if (!mouseBotaoDireito) {
			 if (!this.e.getMarcado()) this.clicar();
		} // se clicar no botão direito do mouse -> MARCAR 
		else {
			this.marcar();
			System.out.println("d");
		}
		this.campoGrafico.checaEstado();
		

	}

	public void clicar() {
		// Retorna numero de vizinhos minados se o espaço não possuir mina
		int numVizinhosMinados = e.clicar();

		if (e.getMinado()) {
			this.campoGrafico.revelarMinas();

		}
		// Envolve conceitos de recursividade
		// Se o espaço não tiver vizinhos minados, vai abrindo
		// os que também não tiverem vizinhos minados

		if (numVizinhosMinados == 0) {
			// Revelar os vizinhos que não tiverem minas adjacentes
			for (Espaco vizinho : e.getVizinhos()) {
				if (!vizinho.getClicado()) {
					vizinho.getButton().clicar();
				}
			}

		}
		this.text = Integer.toString(numVizinhosMinados);
		this.revela(this.text);

	}
	
	
	public void marcar() {
		if(this.e.getClicado()) return;
		boolean estaMarcado = this.e.marcar();
		if (this.e.getMarcado()) {
			this.setText("M");
		} else {
			this.setText("");
		}
	}

	public void setPos(int i, int j) {
		this.setI(i);
		this.setJ(j);
		this.e = c.getEspaco(i, j);
	}

	public void revela(String cod) {
		setText(cod);
		// Não permite clicar mais
		this.setEnabled(false);

	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	public Espaco getE() {
		return this.e;
	}
}
