package vista;


import controlador.AlertaHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
    	stage.setTitle("DragonAlgoBall");
        //stage.initStyle(StageStyle.UTILITY);
        AudioClip musicaDeFondo = new AudioClip("file:src/vista/Sonidos/TemaBienvenida.mp3");
        musicaDeFondo.play();
        ContenedorBienvenidos ventanainicial = new ContenedorBienvenidos(stage,musicaDeFondo);
        Scene escenaBienvenidos = new Scene(ventanainicial,1000,640);
        stage.setScene(escenaBienvenidos);
        stage.setMinHeight(escenaBienvenidos.getHeight());
        stage.setMinWidth(escenaBienvenidos.getWidth());
        stage.setMaxHeight(escenaBienvenidos.getHeight());
        stage.setMaxWidth(escenaBienvenidos.getHeight());
        stage.setFullScreen(false);
        AlertaHandler alerta = new AlertaHandler();
        stage.setOnCloseRequest(alerta);

        /*Turno turno =  new TurnoEquipoZ(null, null);
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, turno);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
         */


        stage.show();
        
            

    }

}

