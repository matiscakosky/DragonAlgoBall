package vista;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;

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
        stage.show();

    }
}

  
