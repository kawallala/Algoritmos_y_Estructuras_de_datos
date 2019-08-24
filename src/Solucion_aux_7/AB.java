package Solucion_aux_7;

class AB{

	double priority;
	String caracter;

	AB izq;
	AB der;

	public AB(double pr, String caracter){
		priority = pr;
		this.caracter = caracter;
		izq = null;
		der = null;
	}

	public AB(double pr, String caracter, AB izq, AB der){
		priority = pr;
		this.caracter = caracter;
		this.izq = izq;
		this.der = der;
	}

}