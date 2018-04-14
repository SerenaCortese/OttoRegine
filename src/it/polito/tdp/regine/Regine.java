package it.polito.tdp.regine;

import java.util.ArrayList;
import java.util.List;

/**
 * La disposizione di un certo numero di regine sulla scacchiera
 * 
 * @author Fulvio
 *
 */
public class Regine {
	/**
	 * Posiziona regina su scacchiera di dimensione N. 
	 * @param N dimensione della scacchiera
	 * @return
	 */
	public List<Integer> posiziona(int N) {

		List<Integer> soluzione = new ArrayList<Integer>();

		if (cerca(soluzione, N, 0)) {
			return soluzione;
		} else {
			return null;
		}

	}

	/**
	 * Assumendo che scacchiera sia piena nelle righe da 0 a livello-1, determina le
	 * possibili posizioni per una regina alla riga==livello e prova ricorsivamente
	 * a posizionarla.
	 * 
	 * @param scacchiera
	 *            lista delle posizioni (colonna) delle regine precenenti
	 * @param N
	 *            dimensione scacchiera
	 * @param livello
	 *            riga a cui deve lavorare la ricorsione
	 */
	private boolean cerca(List<Integer> scacchiera, int N, int livello) {

		if (livello == N) {
			// caso terminale, soluzione trovata
			return true;
		}
				
		for (int mossa = 0; mossa < N; mossa++) { //le mosse possibili sono le colonne nella scacchiera
			if (posizioneSicura(scacchiera, livello, N, mossa)) {
				scacchiera.add(mossa);
				if (cerca(scacchiera, N, livello + 1))
					return true; 
				//così appena ricevo un true da un livello annidato, cioè ha trovato la soluzione
				//si ferma tutto dopo aver trovato la prima soluzione
				//non faccio backtrack così da avere in memoria la soluzione appena trovato
				scacchiera.remove(livello);
			}
		}
		return false;
	}

	private boolean posizioneSicura(List<Integer> scacchiera, int livello, int n, int mossa) {

		for (int riga = 0; riga < livello; riga++) {//guardo tutte le righe precedenti a quella della mossa

			// colonne
			if (scacchiera.get(riga) == mossa)
				return false;

			// diagonale dx
			if (riga - scacchiera.get(riga) == livello - mossa)
				return false;

			// diagonale sx
			if (riga + scacchiera.get(riga) == livello + mossa)
				return false;

		}

		return true;
	}

}

/*
 * 
 * 
 * [Q] --> R1=riga, C1=schacchiera.get(riga)
 * 
 * 
 * 
 * 			[Q] --> R2=livello, C2=mossa
 * 
 * Diagonale destra: R1-C1 == R2-C2
 * 
 * Diagonale sinistra: R1+C1 = R2+C2
 * 
 */