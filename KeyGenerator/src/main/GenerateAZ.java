package main;

/**
 * Aplicación que genera una clave de seguridad aleatoria
 * en base a parámetros personalizables.
 * 
 * @author Miguel Igual
 *
 */
public class GenerateAZ{
	

	/**
	 * Número entero. Longitud de la clave.
	 */
	private int lon;
	/**
	 * Número entero. Indice de la opción escogida.
	 */
	private int opt;
	/**
	 * Matriz de carácteres que contiene la clave generada.
	 */
	private char[] word;
	/**
	 * Matriz que contiene los cáracteres de la A a la Z en mayúsculas.
	 */
	private char[] mayus;
	/**
	 * Matriz que contiene los cáracteres de la A a la Z en minúsculas.
	 */
	private char[] minus;
	/**
	 * Matriz que contiene los números del 0 al 9 en formato carácter.
	 */
	private char[] numbers; 
	/**
	 * Matriz que contiene los cáracteres hexadecimales [0-9] y [a-f].
	 */
	private char[] hexa; 
	/**
	 * Matriz que es una combinación de la de letras minúsculas y la de números.
	 */
	private char[] numLetters; 
	/**
	 * Matriz combinación de la matriz 'numLetters' más 37 carácteres especiales. 
	 */
	private char[] special; 
	
	/**
	 * @param lon Longitud de la clave
	 * @param opt Opción elegida
	 */
	public GenerateAZ(int lon, int opt){
		super();
		this.setLon(lon);
		this.opt=opt;
	}
	/**
	 * Método que declara y rellena las matrices con secuencias de carácteres 
	 * y genera a través de otras funciones la matriz que contiene una clave 
	 * generada aleatoriamente.
	 * 
	 * @return Devuelve la matriz 'word' que contiene la clave generada.
	 */
	public char[] generate(){
		
		mayus = new char[26];
		minus = new char[26];
		numbers = new char[10];
		hexa = new char[16];
		numLetters = new char[36];
		special = new char[73];
		
		//No usadas(para futura version)
		mayus[0]='A';
		mayus[1]='B';
		mayus[2]='C';
		mayus[3]='D';
		mayus[4]='E';
		mayus[5]='F';
		mayus[6]='G';
		mayus[7]='H';
		mayus[8]='I';
		mayus[9]='J';
		mayus[10]='K';
		mayus[11]='L';
		mayus[12]='M';
		mayus[13]='N';
		mayus[14]='O';
		mayus[15]='P';
		mayus[16]='Q';
		mayus[17]='R';
		mayus[18]='S';
		mayus[19]='T';
		mayus[20]='U';
		mayus[21]='V';
		mayus[22]='W';
		mayus[23]='X';
		mayus[24]='Y';
		mayus[25]='Z';
		
		minus[0]='a';
		minus[1]='b';
		minus[2]='c';
		minus[3]='d';
		minus[4]='e';
		minus[5]='f';
		minus[6]='g';
		minus[7]='h';
		minus[8]='i';
		minus[9]='j';
		minus[10]='k';
		minus[11]='l';
		minus[12]='m';
		minus[13]='n';
		minus[14]='o';
		minus[15]='p';
		minus[16]='q';
		minus[17]='r';
		minus[18]='s';
		minus[19]='t';
		minus[20]='u';
		minus[21]='v';
		minus[22]='w';
		minus[23]='x';
		minus[24]='y';
		minus[25]='z';
		
		numbers[0]=(char) ('0');
		numbers[1]=(char) ('1');
		numbers[2]=(char) ('2');
		numbers[3]=(char) ('3');
		numbers[4]=(char) ('4');
		numbers[5]=(char) ('5');
		numbers[6]=(char) ('6');
		numbers[7]=(char) ('7');
		numbers[8]=(char) ('8');
		numbers[9]=(char) ('9');
		
		special[0]='º';				
		special[1]='|';		
		special[2]='@';		
		special[3]='#';		
		special[4]='~';		
		special[5]='€';		
		special[6]='¬';		
		special[7]='/';		
		special[8]='(';		
		special[9]=')';		
		special[10]='=';				
		special[11]='¡';		
		special[12]='ª';		
		special[13]='!';		
		special[14]='"';		
		special[15]='·';		
		special[16]='$';		
		special[17]='%';		
		special[18]='&';	
		special[19]='?';
		special[20]='¿';
		special[21]='`';
		special[22]='+';
		special[23]='´';
		special[24]=',';
		special[25]='.';
		special[26]='-';
		special[27]=';';
		special[28]=':';
		special[29]='_';
		special[30]='^';
		special[31]='*';
		special[32]='¨';
		special[33]='[';
		special[34]=']';
		special[35]='{';
		special[36]='}';
		// 
		
		
		//hexadecimal
		for(int i=0; i<10; i++){
			hexa[i]=numbers[i];
		}
		for(int i=0; i<6; i++){
			hexa[i+10]=minus[i];
		}
		
		//num+letras
		for(int i=0; i<26; i++){
			numLetters[i]=minus[i];
		}
		for(int i=0; i<10; i++){
			numLetters[i+26]=numbers[i];
		}
		
		//special
		for(int i=0; i<10; i++){
			special[i+37]=numbers[i];
		}
		for(int i=0; i<26; i++){
			special[i+47]=minus[i];
		}
		
		switch (opt){
		case 0: letters();
		break;
		case 1: numbers();
		break;
		case 2: hexa();
		break;
		case 3: numLetters();
		break;
		case 4: special();
		break;
		}
		
		return word;
	}
	
	/**
	 * Método que rellena la matriz 'word' con carácteres aleatorios en base
	 * a la matriz que contiene solo letras.
	 */
	public void letters(){
		setWord(new char[getLon()]);
		for(int i=0; i<getLon(); i++){
			word[i]=minus[generateRandom()];
		}
	}
	
	/**
	 * Método que rellena la matriz 'word' con carácteres aleatorios en base
	 * a la matriz que contiene solo números.
	 */
	public void numbers(){
		setWord(new char[getLon()]);
		for(int i=0; i<getLon(); i++){
			word[i]=numbers[generateRandom()];
		}
	}
	
	/**
	 * Método que rellena la matriz 'word' con carácteres aleatorios en base
	 * a la matriz que contiene caracteres hexadecimales.
	 */
	public void hexa(){
		setWord(new char[getLon()]);
		for(int i=0; i<getLon(); i++){
			word[i]=hexa[generateRandom()];
		}
	}
	
	/**
	 * Método que rellena la matriz 'word' con carácteres aleatorios en base
	 * a la matriz que contiene mezcla de letras y números.
	 */
	public void numLetters(){
		setWord(new char[getLon()]);
		for(int i=0; i<getLon(); i++){
			word[i]=numLetters[generateRandom()];
		}
	}
	
	/**
	 * Método que rellena la matriz 'word' con carácteres aleatorios en base
	 * a la matriz que contiene letras, números y carácteres especiales.
	 */
	public void special(){
		setWord(new char[getLon()]);
		for(int i=0; i<getLon(); i++){
			word[i]=special[generateRandom()];
		}
	}
	
	/**
	 * Método que devuelve la clave generada en formato cadena de texto.
	 * 
	 * @return la clave en formato texto
	 */
	public String keyGenerated(){
		String s = new String(generate());
		return s;
		
	}
	
	/**
	 * Método que genera y devuelve un número aleatorio que utilizamos para 
	 * determinar el índice de la matriz aleatoriamente. Actúa según la opción
	 * escogida de manera que el rango de números posibles coincida con la
	 * longitud de la matriz a emplear.
	 *   
	 * @return devuelve el número aleatorio generado
	 */
	public int generateRandom(){
		int rand=0;
		
		switch(opt){
		//letras
		case 0: rand=(int)(Math.random()*26);
		break;
		//numeros
		case 1: rand=(int)(Math.random()*10);
		break;
		//hexa
		case 2: rand=(int)(Math.random()*16);
		break;
		//num+letras
		case 3: rand=(int)(Math.random()*36);
		break;
		//special
		case 4: rand=(int)(Math.random()*73);
		break;
		}
		
		return rand;
	}
	/**
	 * Obtiene el valor de la variable 'lon'.
	 * 
	 * @return valor de la variable 'lon'
	 */
	public int getLon() {
		return lon;
	}
	/**
	 * Establece el valor de la variable 'lon'.
	 * 
	 * @param lon Número entero a establecer como valor de 'lon'
	 */
	public void setLon(int lon) {
		this.lon = lon;
	}
	/**
	 * Obtiene el valor de la variable 'word'.
	 * 
	 * @return valor de la variable 'word'
	 */
	public char[] getWord() {
		return word;
	}
	/**
	 * Establece el valor de la matriz word.
	 * 
	 * @param word
	 */
	public void setWord(char[] word) {
		this.word = word;
	}
	/**
	 * Establece el valor de la variable opt.
	 * 
	 * @param i Número entero a establecer como valor de 'opt'
	 */
	public void setOpt(int i) {
		this.opt = i;
		
	}

}
