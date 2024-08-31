package aplication;

import java.util.Hashtable;

import tabelaHash.HashTable;

public class Program {

	public static void main(String[] args) {

		System.out.println("iniciando");
		
//		Hashtable<String, String> ht = new Hashtable<String, String>();
//		
//		ht.put("claudio", "claudio");
//		ht.put("joana", "joana");
//		ht.put("maria", "maria");
//		ht.put("roberto", "roberto");
//		ht.put("vladmir", "vladmir");
//		ht.put("joel", "joel");
		
		HashTable ht = new HashTable(22, 75, 2);
		
		ht.insere("claudio");
		ht.insere("joana");
		ht.insere("maria");
		ht.insere("roberto");
		ht.insere("vladmir");
		ht.insere("joel");
		
		

		System.out.println("encerrando");
		




	} 

}