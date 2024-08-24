package tabelaHash;

import java.util.Arrays;
import linkedList.LinkedList;

public class HashTable {
	private LinkedList[] vetor;
	private int m;

	@SuppressWarnings("unchecked")
	public HashTable(int n, int margem, int a) {
		int m0 = n / a;

		boolean[] primos = crivoDeAtkin(m0 * 2);
		for (int i = m0; i < primos.length; i++) {
			if (primos[i]) {
				this.m = i;
				break;
			}
		}

		vetor = new LinkedList[m];

	}

	private int hash(String chave) {
		String somador = "";
		for (int i = 0; i < chave.length(); i++) {
			somador += (int) chave.charAt(i);
		}

		int x = Integer.parseInt(somador);

		return x % m;
	}

	public void insere(String str) {
		int hash = hash(str);

		if (vetor[hash] == null) {
			LinkedList lista = new LinkedList();
			vetor[hash] = lista;
			lista.insert(str);
			return;
		}

		vetor[hash].insert(str);
	}

	public void remove(String str) {
		int hash = hash(str);

		if (vetor[hash] == null) {
			return;
		}

		vetor[hash].remove(str);
		return;
	}

	public boolean buscar(String str) {
		int hash = hash(str);
		LinkedList lista = vetor[hash];
		if (lista == null) {
			return false;
		}

		if (lista.find() != null) {
			return true;
		}

		return false;
	}
	public void print() {
		vetor.toString();
		
	}
//	public void print(int info) {
//		int hash = hash(str);
//		LinkedList<String> lista = vetor[hash];
//	}
	

	private static boolean[] crivoDeAtkin(int limite) {
		boolean[] primos = new boolean[limite + 1];
		Arrays.fill(primos, false);

		// Implementa o Crivo de Atkin
		for (int x = 1; x * x <= limite; x++) {
			for (int y = 1; y * y <= limite; y++) {
				int n = 4 * x * x + y * y;
				if (n <= limite && (n % 12 == 1 || n % 12 == 5)) {
					primos[n] = !primos[n];
				}

				n = 3 * x * x + y * y;
				if (n <= limite && n % 12 == 7) {
					primos[n] = !primos[n];
				}

				n = 3 * x * x - y * y;
				if (x > y && n <= limite && n % 12 == 11) {
					primos[n] = !primos[n];
				}
			}
		}

		// Remove múltiplos de quadrados de primos
		for (int i = 5; i * i <= limite; i++) {
			if (primos[i]) {
				for (int k = i * i; k <= limite; k += i * i) {
					primos[k] = false;
				}
			}
		}

		return primos;
	}
}
