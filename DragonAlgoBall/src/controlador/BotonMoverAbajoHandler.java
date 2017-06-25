package controlador;

import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Personaje;
import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.PasosInsuficientes;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {

	DragonAlgoBall juego;
	ContenedorPrincipal contenedor;
	Turno turno;
	
	public BotonMoverAbajoHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor){
		this.juego = juego;
		this.contenedor = contenedor;
	}
    @Override
    public void handle(ActionEvent actionEvent) {
        turno = juego.getTurnoActual();
        Personaje aMover = turno.getPersonajeMovil();
        try {
            aMover.MoverPersonajeHaciaAbajo();
        			
		} catch (PasosInsuficientes p) {

		}
        catch (MovimientoInvalido p) {
		}
        catch(NullPointerException e){
        	//Ojo! esta excpecion es posible, hay que tenerla en cuenta por mas que no sea del modelo
        	//Tenes que seleccionar "MOVER"        	
        }
        contenedor.dibujarTablero();
    }
}
