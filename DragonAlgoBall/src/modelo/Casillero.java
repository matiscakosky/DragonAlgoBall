package modelo;

public class Casillero {
	
	private final ObjetoJuego vacio = null;
	private ObjetoJuego objeto = vacio;
	
	public void agregarObjeto(ObjetoJuego unObjeto) {
		if (this.objeto == vacio) {
			this.objeto = unObjeto;
		}
	}
	
	public ObjetoJuego eliminarObjeto() {
		ObjetoJuego unObjeto = this.objeto;
		this.objeto = vacio;
		return unObjeto;
	}
	
	public ObjetoJuego getObjeto() {
		return this.objeto;
	}
	
	public boolean estaVacio(){
		return (objeto == vacio);
	}
	
}