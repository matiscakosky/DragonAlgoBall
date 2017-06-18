package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.turnos.Turno;
import modelo.turnos.TurnoEquipoZ;
import vista.eventos.AplicacionOnKeyPressEventHandler;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("DragonAlgoBall");

        Turno turno =  new TurnoEquipoZ(null, null);
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, turno);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

         //add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();
        
        /*Para cambiar el icono del prompt message
         * 
        // Get the Stage.
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        // Add a custom icon.
        stage.getIcons().add(new Image(this.getClass().getResource("login.png").toString()));*/    
            

    }

}
