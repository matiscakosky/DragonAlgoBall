package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
        stage.initStyle(StageStyle.UTILITY);
        VentanaInicial ventanainicial = new VentanaInicial(stage);
        Scene escenaBienvenidos = new Scene(ventanainicial,1000,640);
        stage.setScene(escenaBienvenidos);
        stage.setMinHeight(escenaBienvenidos.getHeight());
        stage.setMinWidth(escenaBienvenidos.getWidth());
        stage.setFullScreen(false);

        /*Turno turno =  new TurnoEquipoZ(null, null);
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, turno);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
         */


        stage.show();
        
            

    }

}
