package br.com.artur.poo.campominado;

import java.util.Random;

public class Campo {
	private Espaco[][] matriz;

	public Campo() {
		matriz = new Espaco[Constantes.getNUM_LINHAS()][Constantes.getNUM_COL()];
		// For para povoar a matriz com os espaços
		for (int i = 0; i < Constantes.getNUM_LINHAS(); i++) {
			for (int j = 0; j < Constantes.getNUM_COL(); j++) {
				matriz[i][j] = new Espaco();

			}

		}

		for (int i = 0; i < Constantes.getNUM_LINHAS(); i++) {
			for (int j = 0; j < Constantes.getNUM_COL(); j++) {
				if (i > 0) {

					if (j > 0)
						matriz[i][j].adicionarVizinhos(matriz[i - 1][j - 1]);
					matriz[i][j].adicionarVizinhos(matriz[i - 1][j]);
					if (j < Constantes.getNUM_COL() - 1)
						matriz[i][j].adicionarVizinhos(matriz[i - 1][j + 1]);
				}
				if (j > 0)
					matriz[i][j].adicionarVizinhos(matriz[i][j - 1]);
				if (j < Constantes.getNUM_COL() - 1)
					matriz[i][j].adicionarVizinhos(matriz[i][j + 1]);

				if (i < Constantes.getNUM_LINHAS() - 1) {

					if (j > 0)
						matriz[i][j].adicionarVizinhos(matriz[i + 1][j - 1]);
					matriz[i][j].adicionarVizinhos(matriz[i + 1][j]);
					if (j < Constantes.getNUM_COL() - 1)
						matriz[i][j].adicionarVizinhos(matriz[i + 1][j + 1]);
				}

			}

		}

	}

	public Campo(Espaco[][] matriz) {

	}

	public void adicionarMinas() {
		Random rand = new Random();
		int n = Constantes.getNUM_MINAS();
		while (n > 0) {
			int l = rand.nextInt(Constantes.getNUM_LINHAS());
			int c = rand.nextInt(Constantes.getNUM_COL());

			if (matriz[l][c].minar()) {
				n--;
			}
		}
	}

	public boolean isVencido() {
		for (int i = 0; i < Constantes.getNUM_LINHAS(); i++) {
			for (int j = 0; j < Constantes.getNUM_COL(); j++) {
				if (!matriz[i][j].isFinalizado())
					return false;

			}
		}

		return true;
	}

	public boolean isPerdido() {
		for (int i = 0; i < Constantes.getNUM_LINHAS(); i++) {
			for (int j = 0; j < Constantes.getNUM_COL(); j++) {
				if (matriz[i][j].getClicado() && matriz[i][j].getMinado())
					return true;

			}
		}

		return false;
	}

	public Espaco getEspaco(int i, int j) {
		return matriz[i][j];
	}

	@Override
	public String toString() {
		String str = "";

		for (int i = 0; i < Constantes.getNUM_LINHAS(); i++) {

			for (int j = 0; j < Constantes.getNUM_COL(); j++) {

				str += matriz[i][j] + " ";
			}
			str += "\n";

		}
		return str;
	}

}
