package br.com.artur.poo.campominado;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JFrameCampo extends JFrame implements Recomeco {
	private JPanel painel;
	private JButtonEspaco[][] matrizBut;
	private Campo c;
	private JButton resetButton;

	public JFrameCampo(Campo c) {
		this.c = c;
		confIniciais();
	}

	public JFrameCampo() {
	};

	private void confIniciais() {
		this.painel = new JPanel();
		this.add(painel);
		painel.setLayout(null);
		this.matrizBut = new JButtonEspaco[Constantes.getNUM_LINHAS()][Constantes.getNUM_COL()];
		for (int i = 0; i < Constantes.getNUM_LINHAS(); i++) {
			for (int j = 0; j < Constantes.getNUM_COL(); j++) {
				// Cria cada quadradinho visualmente
				matrizBut[i][j] = new JButtonEspaco(this.c, this);
				c.getEspaco(i, j).setButton(matrizBut[i][j]);
				matrizBut[i][j].setPos(i, j);
				// Define largura e altura de cada quadradinho
				matrizBut[i][j].setSize(Constantes.getTAM_ESPACO(), Constantes.getTAM_ESPACO());
				// Define onde cada botão vai ficar no campo
				matrizBut[i][j].setLocation(Constantes.getTAM_ESPACO() * j,
						Constantes.getTAM_ESPACO() * i + Constantes.getOFFSET_SUPERIOR());
				painel.add(matrizBut[i][j]);
			}

		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Constantes.getTAM_ESPACO() * Constantes.getNUM_COL(),
				Constantes.getNUM_LINHAS() * Constantes.getTAM_ESPACO() + Constantes.getOFFSET_SUPERIOR()
						+ Constantes.getALTURA_BARRA_SUP());
		this.setVisible(true);
		this.setResizable(false);

		this.resetButton = new JButton();
		this.painel.add(this.resetButton);
		this.resetButton.addActionListener((java.awt.event.ActionEvent evt) -> {
			this.reset();
		});
		this.resetButton.setSize(Constantes.getTAM_ESPACO(), Constantes.getTAM_ESPACO());
		this.resetButton.setLocation(
				(Constantes.getTAM_ESPACO() * Constantes.getNUM_COL()) / 2 - Constantes.getTAM_ESPACO() / 2,
				Constantes.getOFFSET_SUPERIOR() - Constantes.getTAM_ESPACO() - 4);
	}

	@Override
	public void reset() {
		for (int i = 0; i < Constantes.getNUM_LINHAS(); i++) {
			for (int j = 0; j < Constantes.getNUM_COL(); j++) {
				matrizBut[i][j].reset();
			}

		}
		this.c.adicionarMinas();
	}

	public void revelarMinas() {
		for (int i = 0; i < Constantes.getNUM_LINHAS(); i++) {
			for (int j = 0; j < Constantes.getNUM_COL(); j++) {
				if (matrizBut[i][j].getE().getMinado()) {
					matrizBut[i][j].revela("-1");
				}
			}

		}
	}

	// Método para desativar botôes quando o jogador ganhar ou
	// perder o jogo
	public void desativaBot() {
		for (int i = 0; i < Constantes.getNUM_LINHAS(); i++) {
			for (int j = 0; j < Constantes.getNUM_COL(); j++) {
				matrizBut[i][j].setEnabled(false);

			}

		}
	}

	public void checaEstado() {
		System.out.println("Verificando se ganhou ou perdeu");
		if (this.c.isPerdido()) {

			System.out.println("Perdeu");
			this.desativaBot();
			JOptionPane.showMessageDialog(null, "VOCê PERDEU", "FRACASSADO", JOptionPane.INFORMATION_MESSAGE);

		}

		if (this.c.isVencido()) {
			// O que fazer visualmente quando ganhar
			System.out.println("Ganhou");
			this.desativaBot();
			JOptionPane.showMessageDialog(null, "VOCê GANHOU", "VENCEDOR", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void checaEstado(String msg1, String msg2) {
		System.out.println("Verificando se ganhou ou perdeu");
		if (this.c.isPerdido()) {

			System.out.println("Perdeu");
			this.desativaBot();
			JOptionPane.showMessageDialog(null, msg1, msg2, JOptionPane.INFORMATION_MESSAGE);

		}

		if (this.c.isVencido()) {
			// O que fazer visualmente quando ganhar
			System.out.println("Ganhou");
			this.desativaBot();
			JOptionPane.showMessageDialog(null, "VOCê GANHOU", "VENCEDOR", JOptionPane.INFORMATION_MESSAGE);

		}
	}

}
