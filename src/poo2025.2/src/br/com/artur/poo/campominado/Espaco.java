package br.com.artur.poo.campominado;

import java.util.ArrayList;

public class Espaco extends Jogadas implements Recomeco {
	private boolean minado;
	private boolean revelado;
	private boolean marcado;
	private boolean clicado;
	private ArrayList<Espaco> vizinhos;
	private JButtonEspaco button;

	public Espaco() {
		this.minado = false;
		this.revelado = false;
		this.marcado = false;
		this.clicado = false;
		this.vizinhos = new ArrayList<>();
	}

	Espaco(boolean minado) {
		this.minado = minado;

	}

	public boolean getMinado() {
		return minado;
	}

	public void setMinado(boolean minado) {
		this.minado = minado;
	}

	public boolean getRevelado() {
		return revelado;
	}

	public void setRevelado(boolean revelado) {
		this.revelado = revelado;
	}

	public boolean getMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

	public boolean getClicado() {
		return clicado;
	}

	public void setClicado(boolean clicado) {
		this.clicado = clicado;
	}

	public void adicionarVizinhos(Espaco e) {
		this.vizinhos.add(e);
	}

	// Método minar indica se o espaço tem uma mina
	// Se o espaço não tiver uma mina, esse método vai adicionar mina
	// Se já tiver, deixa do jeito que está (retorna false)
	public boolean minar() {
		if (!this.minado) {
			this.minado = true;
			return true;
		} else {
			return false;
		}
	}

	// No método marcar, se o espaço já
	// estiver marcado, ele desmarcar;
	// se não, ele vai marcar
	@Override
	public boolean marcar() {
		this.marcado = !this.marcado;
		return this.marcado;

	}

	// -1 - clicou numa mina
	// 0 -sem minas nos vizinhos
	// n - possui n minas nos vizinhos
	@Override
	public int clicar() {
		this.clicado = true;
		if (this.minado) {
			return -1;
		} else {
			return numMinasVizinhos();
		}
	}

//Método que vai percorrer todos os vizinhos do quadradinho
//
	public int numMinasVizinhos() {
		int n = 0;
		for (Espaco e : this.vizinhos) {
			if (e.minado) {
				n++;
			}
		}
		return n;
	}

	@Override

	public void reset() {
		this.minado = false;
		this.revelado = false;
		this.marcado = false;
		this.clicado = false;
	}

	public boolean isFinalizado() {
		if (this.minado && this.marcado)
			return true;
		if (!this.minado && !this.marcado && this.clicado)
			return true;
		return false;
	}

	public JButtonEspaco getButton() {
		return this.button;

	}

	public void setButton(JButtonEspaco button) {
		this.button = button;
	}

	public ArrayList<Espaco> getVizinhos() {
		return this.vizinhos;
	}

	public void setVizinhos(ArrayList<Espaco> vizinhos) {
		this.vizinhos = vizinhos;
	}

	@Override
	public String toString() {
		if (this.minado)
			return "-1";
		return "+" + this.numMinasVizinhos();
	}
}
