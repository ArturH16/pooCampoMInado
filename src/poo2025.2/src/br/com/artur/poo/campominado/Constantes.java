package br.com.artur.poo.campominado;

public final class Constantes {
	private static int NUM_LINHAS = 5;
	private static int NUM_COL = 5;
	private static int NUM_MINAS = 5;
	private static int TAM_ESPACO = 30;
	private static int OFFSET_SUPERIOR = 100;
	private static int ALTURA_BARRA_SUP = 30;

	public Constantes() {

	}

	public Constantes(int NUM_MINAS) {
		setNUM_MINAS(NUM_MINAS);
	}

	public static int getNUM_COL() {
		return NUM_COL;
	}

	public static void setNUM_COL(int nUM_COL) {
		NUM_COL = nUM_COL;
	}

	public static int getNUM_LINHAS() {
		return NUM_LINHAS;
	}

	public static void setNUM_LINHAS(int nUM_LINHAS) {
		NUM_LINHAS = nUM_LINHAS;
	}

	public static int getNUM_MINAS() {
		return NUM_MINAS;
	}

	public static void setNUM_MINAS(int nUM_MINAS) {
		NUM_MINAS = nUM_MINAS;
	}

	public static int getTAM_ESPACO() {
		return TAM_ESPACO;
	}

	public static void setTAM_ESPACO(int tAM_ESPACO) {
		TAM_ESPACO = tAM_ESPACO;
	}

	public static int getOFFSET_SUPERIOR() {
		return OFFSET_SUPERIOR;
	}

	public static void setOFFSET_SUPERIOR(int oFFSET_SUPERIOR) {
		OFFSET_SUPERIOR = oFFSET_SUPERIOR;
	}

	public static int getALTURA_BARRA_SUP() {
		return ALTURA_BARRA_SUP;
	}

	public static void setALTURA_BARRA_SUP(int aLTURA_BARRA_SUP) {
		ALTURA_BARRA_SUP = aLTURA_BARRA_SUP;
	}
}
