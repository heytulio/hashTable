package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

import org.junit.jupiter.api.Test;

import linkedList.LinkedList;
import tabelaHash.HashTable;

class TesteTabelaHash {

	@Test
	public void teste1() {
		//buscar elemento que é o primeiro na lista
		HashTable ht = new HashTable(14, 50, 2);
		
		ht.insere("Carlos");
		ht.insere("Sergio");
		
		assertEquals(true, ht.busca("Carlos"));
		
	}
	@Test
	public void teste2() {
		//buscar um elemento existente que seja o último da lista e não seja o
		//primeiro
		HashTable ht = new HashTable(14, 50, 2);
		
		ht.insere("Carlos");
		ht.insere("Sergio");
		ht.insere("José");
		ht.insere("Vitor");
		ht.insere("Maria");
		ht.print();
		assertEquals(true, ht.busca("Carlos"));
		
	}
	
	@Test
	public void teste3() {
		//buscar um elemento que nunca foi inserido
		HashTable ht = new HashTable(14, 50, 2);
		ht.insere("Carlos");
		ht.insere("Sergio");
		ht.insere("José");
		ht.insere("Vitor");
		ht.insere("Maria");
		ht.print();
		assertEquals(false, ht.busca("rafael"));
	}
	
	@Test
	public void teste4() {
		//buscar um elemento que já foi inserido e removido
		HashTable ht = new HashTable(14, 50, 2);
		ht.insere("Carlos");
		ht.insere("Sergio");
		ht.insere("José");
		ht.insere("Vitor");
		ht.insere("Maria");
		ht.print();
		ht.remove("Vitor");
		ht.print();
		assertEquals(false, ht.busca("Vitor"));
		
	}
	@Test
	public void teste5() {
		//remover todos os elementos de uma posição da tabela e voltar a inserir
		//elementos novamente
		HashTable ht = new HashTable(14, 50, 2);
		ht.insere("Carlos");
		ht.insere("Sergio");
		ht.insere("José");
		ht.insere("Vitor");
		ht.insere("Maria");
		ht.print();
		ht.remove("Vitor");
		ht.remove("Sergio");
		ht.print();
		ht.insere("Sergio");
		ht.insere("Vitor");
		ht.print();
		boolean[] res = new boolean[]{ht.busca("Sergio"), ht.busca("Vitor")};
		boolean[] expected = new boolean[] {true, true};
		assertEquals(Arrays.toString(expected), Arrays.toString(res));
		
	}
	
	@Test
	public void teste6() {
		//insercao de string null
		HashTable ht = new HashTable(14, 50, 2);
		ht.insere(null);
		
		assertEquals(false, ht.busca(null));
	}
	
	@Test
	public void teste7() {
		//insercao de string com caracteres nao latinos
		HashTable ht = new HashTable(14, 50, 2);
		
		ht.insere("うずまきナルト");
		assertEquals(true, ht.busca("うずまきナルト"));
		
	}
	
	@Test
	public void teste8() {
		//inserção de string que ultrapassa a margem e aumenta a ht
		
		HashTable ht = new HashTable(10, 50, 2);
		
		LinkedList[] vetor = ht.getTable();
		
		ht.insere("pablo");
		ht.insere("mario");
		ht.insere("abel");
		ht.insere("maria");
		ht.insere("mariana");
		ht.insere("carlos");
		ht.insere("sergio");
		ht.insere("henrique");
		ht.insere("caio");
		ht.insere("suzana");
		ht.insere("irene");
		ht.insere("gloria");
		ht.insere("juliana");
		ht.insere("vinicius");
		ht.print();
		ht.insere("luis");
		ht.print();
		
		assertNotEquals(vetor, ht.getTable());
		
	}
	
	@Test
	public void teste9() {
		//preencher todos os indices da tabela e remover em sequencia
		HashTable ht = new HashTable(10, 50, 2);
		ht.insere("vinicius");
		ht.insere("sergio");
		ht.insere("gloria");
		ht.insere("henrique");
		ht.insere("mariana");
		ht.print();
		
		ht.remove("vinicius");
		ht.remove("sergio");
		ht.remove("gloria");
		ht.remove("henrique");
		ht.remove("mariana");
		ht.print();
		
		assertEquals(0, ht.size());
	}
	
	@Test
	public void teste10() {
		//preencher todos os indices da tabela e remover em sequencia
		//e depois preencher novamente a tabela
		HashTable ht = new HashTable(10, 50, 2);
		ht.insere("vinicius");
		ht.insere("sergio");
		ht.insere("gloria");
		ht.insere("henrique");
		ht.insere("mariana");
		ht.print();
		
		ht.remove("vinicius");
		ht.remove("sergio");
		ht.remove("gloria");
		ht.remove("henrique");
		ht.remove("mariana");
		ht.print();
		
		ht.insere("vinicius");
		ht.insere("sergio");
		ht.insere("gloria");
		ht.insere("henrique");
		ht.insere("mariana");
		
		assertEquals(5, ht.size());
	}
	
	
	@Test
	public void teste11() {
		//teste de string similares para verificar colisao
		HashTable ht = new HashTable(14, 50, 2);
		
		ht.insere("abc");
		ht.insere("bca");
		ht.insere("cba");
		ht.insere("bac");
		ht.insere("cab");
		
		ht.print();
		//TODO implementar um assert que valide esse teste
	}
	
	@Test
	public void teste12() {
		//teste de case sensitive
		HashTable ht = new HashTable(14, 50, 2);
		
		ht.insere("abc");
		
		assertEquals(false, ht.busca("Abc"));
	}

	@Test
	public void teste13() {
		//insercao de string com caracteres especiais
		HashTable ht = new HashTable(14, 50, 2);
		
		ht.insere("Olá, tudo bem?");
		
		assertEquals(true, ht.busca("Olá, tudo bem?"));
	}
	
	@Test
	public void teste14() {
		//testando consistencia
		HashTable ht = new HashTable(14, 50, 2);
		
		ht.insere("vinicius");
		ht.insere("sergio");
		ht.insere("gloria");
		
		ht.remove("sergio");
		ht.remove("henrique");
		
		ht.insere("henrique");
		ht.insere("mariana");
		System.out.println(ht.busca("carlos"));
		ht.print();
		
		//TODO implementar um assert para validar esse teste
		
		
	}
	
	@Test
	public void teste15() {
		//teste de consistencia do hash, inserindo uma string, removendo e a inserindo dnv
		HashTable ht = new HashTable(14, 50, 2);
		ht.insere("henrique");
		int firstIndex = ht.buscaIndex("henrique");
		ht.remove("henrique");
		
		ht.insere("henrique");
		assertEquals(firstIndex, ht.buscaIndex("henrique"));
		
	}
	
	public static final int TESTLENGTH = 10;
	
	public static void main(String[] args) {
		
		System.out.println("Inicio do insert test");
		executeInsertTest();
		System.out.println("Inicio do search test");
		executeSearchTest();
		System.out.println("Inicio do remove test");
		executeSearchTest();
		
		
		

	}
	
	public static void executeInsertTest() {
		double[] javaHTTimes = new double[TESTLENGTH];
		double[] nossaHTTimes = new double[TESTLENGTH];
		
		for(int i = 0; i < TESTLENGTH; i++) {
			String s = stringGenerator(); //gera uma string aleatoria de len 7
	
			long inicialInsertTime = System.nanoTime();
			Hashtable<String, String> javaHT = new Hashtable<>(); //por padrao tem m = 11 e margem = 0.75
			
			javaHT.put(s, s);
			
			long finalInsertTime = System.nanoTime();
			
			long totalTime = finalInsertTime - inicialInsertTime;
			
			javaHTTimes[i] = totalTime / 1000000000.0;
						
			inicialInsertTime = System.nanoTime();
			HashTable nossaHT = new HashTable(22, 75, 2); //iremos usar os mesmos parametros default da javaHT
			nossaHT.insere(s);
			
			finalInsertTime = System.nanoTime();
			
			totalTime = finalInsertTime - inicialInsertTime;
			
			nossaHTTimes[i] = totalTime / 1000000000.0;
		}
		
		System.out.println("media java.util.Hastable: "+ Arrays.stream(javaHTTimes).sum()/10);
		System.out.println("media tabelaHash.Hastable: "+ Arrays.stream(nossaHTTimes).sum()/10);
	}
	
	public static void executeSearchTest() {
		double[] javaHTTimes = new double[TESTLENGTH];
		double[] nossaHTTimes = new double[TESTLENGTH];
		
		for(int i = 0; i < TESTLENGTH; i++) {
			//gera strings aleatorias de len 7
			String s1 = stringGenerator();
			String s2 = stringGenerator();
			String s3 = stringGenerator();
			
			Hashtable<String, String> javaHT = new Hashtable<>(); //por padrao tem m = 11 e margem = 0.75
			
			javaHT.put(s1, s1);
			javaHT.put(s2, s2);
			javaHT.put(s3, s3);
			
			long inicialInsertTime = System.nanoTime();

			javaHT.get(s2);
			
			long finalInsertTime = System.nanoTime();
			
			long totalTime = finalInsertTime - inicialInsertTime;
			
			javaHTTimes[i] = totalTime / 1000000000.0;
			
			
			HashTable nossaHT = new HashTable(22, 75, 2); //iremos usar os mesmos parametros default da javaHT
			
			nossaHT.insere(s1);
			nossaHT.insere(s2);
			nossaHT.insere(s3);
			
			inicialInsertTime = System.nanoTime();

			nossaHT.busca(s2);
			
			finalInsertTime = System.nanoTime();
			
			totalTime = finalInsertTime - inicialInsertTime;
			
			nossaHTTimes[i] = totalTime / 1000000000.0;

		}
		
		System.out.println("media java.util.Hastable: "+ Arrays.stream(javaHTTimes).sum()/10);
		System.out.println("media tabelaHash.Hastable: "+ Arrays.stream(nossaHTTimes).sum()/10);
	}
	
	public static void executeRemoveTest() {
		double[] javaHTTimes = new double[TESTLENGTH];
		double[] nossaHTTimes = new double[TESTLENGTH];
		
		for(int i = 0; i < TESTLENGTH; i++) {
			//gera strings aleatorias de len 7
			String s1 = stringGenerator();
			String s2 = stringGenerator();
			String s3 = stringGenerator();
			
			Hashtable<String, String> javaHT = new Hashtable<>(); //por padrao tem m = 11 e margem = 0.75
			
			javaHT.put(s1, s1);
			javaHT.put(s2, s2);
			javaHT.put(s3, s3);
			
			long inicialInsertTime = System.nanoTime();

			javaHT.remove(s2);
			
			long finalInsertTime = System.nanoTime();
			
			long totalTime = finalInsertTime - inicialInsertTime;
			
			javaHTTimes[i] = totalTime / 1000000000.0;

			
			HashTable nossaHT = new HashTable(22, 75, 2); //iremos usar os mesmos parametros default da javaHT
			
			nossaHT.insere(s1);
			nossaHT.insere(s2);
			nossaHT.insere(s3);
			
			inicialInsertTime = System.nanoTime();

			nossaHT.remove(s2);
			
			finalInsertTime = System.nanoTime();
			
			totalTime = finalInsertTime - inicialInsertTime;
			
			nossaHTTimes[i] = totalTime / 1000000000.0;
		}
		
		System.out.println("media java.util.Hastable: "+ Arrays.stream(javaHTTimes).sum()/10);
		System.out.println("media tabelaHash.Hastable: "+ Arrays.stream(nossaHTTimes).sum()/10);
	}
	
	public static String stringGenerator() {
		char[] s = new char[7];
		Random r = new Random();
		for(int i = 0; i < s.length; i++) {
			s[i] = (char )r.nextInt(32, 127);
		}
		
		return String.copyValueOf(s);
	}
}
