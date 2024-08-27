package aplication;

import tabelaHash.HashTable;

public class Program {

	public static void main(String[] args) {
		HashTable hs = new HashTable(1000,50,6);
		hs.insere(" ");
		hs.insere("pablo");
		hs.insere("mario");
		hs.insere("abel");
		hs.insere("maria");
		hs.insere("mariana");
		hs.insere("esther");
		hs.insere("julia");
		hs.insere("tereza");
		hs.insere("juliana");
		hs.insere("joana");
		hs.insere("fernando");
		hs.insere("priscila");
		hs.insere("henrique");
		hs.insere("josé");
		System.out.println(hs.busca("paulo"));
		hs.print();
		hs.insere("carlos");
		hs.insere("");

		hs.insere("sergio");
		hs.print();




	} 

}