package vista;

import controlador.OpcionComoJugarEventHandler;
import controlador.OpcionPantallaCompletaEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage stage) {

        Menu menuOpciones = new Menu("Opciones");
        Menu menuAyuda = new Menu("Ayuda");
        
        MenuItem opcionComoJuego = new MenuItem("�C�mo juego?");
        
        OpcionComoJugarEventHandler opcionComoJuegarHandler = new OpcionComoJugarEventHandler();
        opcionComoJuego.setOnAction(opcionComoJuegarHandler);
        
        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        
        opcionPantallaCompleta.setDisable(true);
        
        //Agregar opciones de sonido activado y desactivado.
        
        menuOpciones.getItems().addAll(opcionPantallaCompleta);
        menuAyuda.getItems().addAll(opcionComoJuego);
        
        this.getMenus().addAll(menuOpciones, menuAyuda);

    	}
    	
    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}
