package controlador;

import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Personaje;
import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.PasosInsuficientes;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;

public class BotonMoverArribaDerechaHandler implements EventHandler<ActionEvent> {

	DragonAlgoBall juego;
	ContenedorPrincipal contenedor;
	Turno turno;
	public BotonMoverArribaDerechaHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor){
		this.juego = juego;
		this.contenedor = contenedor;
	}
    @Override
    public void handle(ActionEvent actionEvent) {
        turno = juego.getTurnoActual();
        Personaje aMover = turno.getPersonajeMovil();
        try {
            aMover.MoverPersonajeHaciaArribaDerecha();
        			
		} catch (PasosInsuficientes p) {
			//El cambio de turno esta nada mas porque queria probar algo, no va asi aca puesto
			contenedor.cambioDeTurno();
		}
        catch (MovimientoInvalido p) {
		}
        catch(NullPointerException e){
        	//Ojo! esta excpecion es posible, hay que tenerla en cuenta por mas que no sea del modelo
        	//Tenes que seleccionar "MOVER"        	
        }
        contenedor.setVacio();
        contenedor.ubicarPersonajes();
    }

}
