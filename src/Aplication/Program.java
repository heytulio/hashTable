package Aplication;

import tabelaHash.HashTable;

public class Program {

	public static void main(String[] args) {
		HashTable hs = new HashTable(50,999,5);
		hs.insere(" ");
		hs.insere("pablo");
		hs.insere("mario");
		hs.insere("abel");
		hs.insere("maria");
		hs.insere("mariana");
		hs.insere("esther");
		hs.insere("julia");
		hs.insere("tereza");
		hs.insere("");
		hs.print();
		System.out.println(hs.busca(""));
		System.out.println(hs.busca(" "));
		System.out.println(hs.busca("inexistente"));
		System.out.println(hs.busca("mariana"));
		System.out.println(hs.busca("pablo"));
		System.out.println(hs.busca("maria"));
		System.out.println(hs.busca("julia"));
		System.out.println(hs.busca("tereza"));
		hs.remove("tereza");
		hs.remove("pablo");
		hs.remove("maria");
		hs.remove("julia");
		hs.remove("inexistente");
		hs.remove("");
		hs.remove(" ");
		hs.print();


	} 

}
