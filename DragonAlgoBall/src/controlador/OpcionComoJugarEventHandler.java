package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionComoJugarEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("¿Cómo Juego?");
        alert.setHeaderText("Explicacion del Juego:");
        String mensaje = " bla bla bla bla bla bla";
        alert.setContentText(mensaje);
        alert.show();
    }

}