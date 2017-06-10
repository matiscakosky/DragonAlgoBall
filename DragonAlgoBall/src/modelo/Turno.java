package modelo;

import modelo.excepciones.PosicionInvalida;

public class Turno {

	private Tablero tablero;
	private Personaje personajeQueSeMueve;
	private Personaje personajeQueAtaca;
	private Personaje personajeQueSeAtaca;
	private Personaje personajeEvoluciona;
	private Equipo equipo;
	
	public Turno(Tablero tablero, Equipo equipo){
		this.equipo = equipo;
		this.tablero = tablero;
		this.AumentarKiInicioDeTurno();
	}
	
	public Personaje validarPersonaje(Posicion posicion){
		Personaje personaje = this.tablero.obtenerPersonaje(posicion);
		if(!this.equipo.contiene(personaje)){
			throw new PosicionInvalida();
		}
		return personaje;
	}
		
	public void elegirPersonajeAtacante(Posicion posicion){
		this.personajeQueAtaca = (Personaje) this.validarPersonaje(posicion);
	}
	
	public void elegirPersonajeAtacable(Posicion posicion){
		this.personajeQueSeAtaca = (Personaje) this.validarPersonaje(posicion);
	}
	
	public void elegirPersonajeMovil(Posicion posicion){
		this.personajeQueSeMueve = (Personaje) this.validarPersonaje(posicion); 
	}
	
	public void elegirPersonajeEvolucionar(Posicion posicion){
		this.personajeEvoluciona = (Personaje) this.validarPersonaje(posicion);
	}

	public void AumentarKiInicioDeTurno(){
		for(Personaje personaje : equipo.getMiembros()){
			personaje.aumentarKi(StatsJuego.kiAumentoPorTurno);
		}
	}
	
	public void evolucionarPersonajeAFase1(Personaje personaje){
		personaje.evolucionarAFase1();
	}
	
	public void evolucionarPersonajeAFase2(Personaje personaje){
		personaje.evolucionarAFase2();
	}
	
	//para la prueba de integracion//
	public void moverPersonaje1(){
		//harcodeado para probar integracion//
		Posicion pos = new Posicion(1,1);
		elegirPersonajeMovil(pos);
		this.personajeQueSeMueve.MoverPersonajeHaciaAbajoDerecha();
		this.personajeQueSeMueve.MoverPersonajeHaciaAbajoDerecha();
	}
	public void moverPersonaje2(){
		//harcodeado para probar integracion//
		Posicion pos = new Posicion(10,10);
		elegirPersonajeMovil(pos);
		this.personajeQueSeMueve.MoverPersonajeHaciaArribaIzquierda();
		this.personajeQueSeMueve.MoverPersonajeHaciaArribaIzquierda();
		this.personajeEvoluciona.evolucionarAFase1();
	}
	public void moverPersonaje3(){
		//harcodeado para probar integracion//
		Posicion pos = new Posicion(10,10);
		elegirPersonajeMovil(pos);
		this.personajeQueSeMueve.MoverPersonajeHaciaArribaIzquierda();
		this.personajeQueSeMueve.MoverPersonajeHaciaArribaIzquierda();
		this.personajeQueSeMueve.MoverPersonajeHaciaArriba();
		this.personajeEvoluciona.evolucionarAFase2();
	}
	
	public void atacar(){
	
	}
}
