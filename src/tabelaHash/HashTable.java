package tabelaHash;

import java.util.Arrays;
import linkedList.LinkedList;

public class HashTable {
	private LinkedList[] vetor;
	private int m;
	private int size;
	private int margem;
	private int a;

	public HashTable(int n, int margem, int a) {
		int m0 = n / a;

		boolean[] primos = crivoDeAtkin(m0 * 2);
		for (int i = m0; i < primos.length; i++) {
			if (primos[i]) {
				this.m = i;
				break;
			}
		}
		this.margem = margem;
		this.a = a;
		vetor = new LinkedList[m];
		System.out.println("M = " + m);
	}

	private int hhash(String chave) {
		int somador = 0;
		for (int i = 0; i < chave.length(); i++) {
			somador += (int) chave.charAt(i);
		}
		int x = (somador);

		return x % m;
	}

	private int hash(String chave) {
		String somador = "";
		for (int i = 0; i < chave.length(); i++) {
			somador += (int) chave.charAt(i);
		}
		if (somador.length() > 6) {
			somador = somador.substring(somador.length() - 6);
		}

		int x = Integer.parseInt(somador) * chave.length();

		return x % m;
	}

	public void insere(String str) {
		if (str != null) {
			str = str.trim();
			if (str == "") {
				return;
			}
			int hash = hash(str);
			if (vetor[hash] == null) {
				LinkedList lista = new LinkedList();
				vetor[hash] = lista;
				lista.insert(str);
				size++;
				return;
			}

			vetor[hash].insert(str);
			size++;

			if (mediaPorPosicao() >= a * (1 + margem / 100.0)) {
				arrumaHashTable();
			}
		}
	}

	public void remove(String str) {
		if (str != null) {
			str = str.trim();
			if (str == "") {
				return;
			}
			int hash = hash(str);

			if (vetor[hash] == null) {
				return;
			}
			vetor[hash].remove(str);
			size--;
			return;
		}
	}

	public boolean busca(String str) {
		if (str != null) {
			str = str.trim();
			if (str == "") {
				return false;
			}
			int hash = hash(str);
			LinkedList lista = vetor[hash];
			if (lista == null) {
				return false;
			}

			if (lista.find(str)) {
				return true;
			}

			return false;
		}
		return false;
	}

	public void print() {
		if (vetor == null) {
			return;
		}
//		for (LinkedList i : vetor) {
//			if (i != null) {
//				System.out.print("[");
//				i.print();
//				System.out.println("]");
//			}
//		}

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != null) {
				System.out.print(i + ": ");
				System.out.print("[");
				vetor[i].print();
				System.out.println("]");
			}
		}
		System.out.println();

	}

	private double mediaPorPosicao() {
		return size / m;
	}

	private void arrumaHashTable() {

		int newM = m * 2;

		boolean[] primos = crivoDeAtkin(newM * 2);

		for (int i = newM; i < primos.length; i++) {
			if (primos[i]) {
				newM = i;
				break;
			}
		}

		LinkedList[] newArray = new LinkedList[newM];
		m = newM;

		for (LinkedList i : vetor) {
			if (i != null) {
				String[] values = i.getValues();
				for (String s : values) {
					int hash = hash(s);

					if (newArray[hash] == null) {
						LinkedList l = new LinkedList();
						l.insert(s);
						newArray[hash] = l;
						continue;
					}
					newArray[hash].insert(s);
				}
			}
		}

		vetor = newArray;

	}

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