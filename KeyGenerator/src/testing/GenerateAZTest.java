
package testing;

import static org.junit.Assert.*;
import main.GenerateAZ;

import org.junit.Test;

/**
 * Clase de pruebas unitarias JUnit
 * 
 * @author Miguel Igual
 */
public class GenerateAZTest {


	int lon=12;
	int opt=3;
	
	GenerateAZ gen = new GenerateAZ(lon, opt);
	
	/**
	 * Método de prueba para {@link main.GenerateAZ#GenerateAZ(int, int)}.
	 */
	@Test
	public void testGenerateAZ() {
		assertEquals(gen.getClass(), GenerateAZ.class);
	}

	/**
	 * Método de prueba para {@link main.GenerateAZ#generate()}.
	 */
	@Test
	public void testGenerate() {
		assertEquals(opt, 3);
		assertEquals(lon, 12);
		assertEquals(gen.generate().length, 12);
	}

	/**
	 * Método de prueba para {@link main.GenerateAZ#letters()}.
	 */
	@Test
	public void testLetters() {
		gen.setOpt(0);
		gen.generate();
		assertNotEquals(gen.getWord(), null);
		assertEquals(gen.getWord().length, 12 );
		
	}

	/**
	 * Método de prueba para {@link main.GenerateAZ#numbers()}.
	 */
	@Test
	public void testNumbers() {
		gen.setOpt(1);
		gen.setLon(14);
		gen.generate();
		assertNotEquals(gen.getWord(), null);
		assertEquals(gen.getWord().length, 14 );
		
	}

	/**
	 * Método de prueba para {@link main.GenerateAZ#hexa()}.
	 */
	@Test
	public void testHexa() {
		gen.setOpt(2);
		gen.setLon(15);
		gen.generate();
		assertNotEquals(gen.getWord(), null);
		assertEquals(gen.getWord().length, 15 );
		
	}

	/**
	 * Método de prueba para {@link main.GenerateAZ#numLetters()}.
	 */
	@Test
	public void testNumLetters() {
		gen.setOpt(3);
		gen.setLon(20);
		gen.generate();
		assertNotEquals(gen.getWord(), null);
		assertEquals(gen.getWord().length, 20 );
	}

	/**
	 * Método de prueba para {@link main.GenerateAZ#special()}.
	 */
	@Test
	public void testSpecial() {
		gen.setOpt(4);
		gen.setLon(48);
		gen.generate();
		assertNotEquals(gen.getWord(), null);
		assertEquals(gen.getWord().length, 48 );
	}

	/**
	 * Método de prueba para {@link main.GenerateAZ#keyGenerated()}.
	 */
	@Test
	public void testKeyGenerated() {
		gen.setLon(23);
		assertNotEquals(gen.keyGenerated(), null);
		assertEquals(gen.keyGenerated().length(), 23);
	}

	/**
	 * Método de prueba para {@link main.GenerateAZ#generateRandom()}.
	 */
	@Test
	public void testGenerateRandom() {
		int rand;
		
		gen.setOpt(0);
		rand=gen.generateRandom();
		assertTrue("Tiene que ser menor que 26", (rand>=0 && rand<26) );
		System.out.println(rand);
		
		gen.setOpt(1);
		rand=gen.generateRandom();
		assertTrue("Tiene que ser menor que 10", (rand>=0 && rand<10) );
		System.out.println(rand);
		
		gen.setOpt(2);
		rand=gen.generateRandom();
		assertTrue("Tiene que ser menor que 16", (rand>=0 && rand<16) );
		System.out.println(rand);
		
		gen.setOpt(3);
		rand=gen.generateRandom();
		assertTrue("Tiene que ser menor que 36", (rand>=0 && rand<36) );
		System.out.println(rand);
		
		gen.setOpt(4);
		rand=gen.generateRandom();
		assertTrue("Tiene que ser menor que 73", (rand>=0 && rand<73) );
		System.out.println(rand);
		


	}

}
