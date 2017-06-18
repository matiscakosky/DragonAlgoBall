package vista;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Tablero;
import modelo.turnos.Turno;
import vista.eventos.BotonMoverHandler;
import vista.eventos.BotonAtacarHandler;
import vista.eventos.BotonAtaqueEspecialHandler;
import vista.eventos.BotonEvolucionarHandler;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
  //  VistaJuego vistaJuego;
    Canvas canvasCentral;
    VBox contenedorCentral;
    Tablero tablero;

    public ContenedorPrincipal(Stage stage, Turno turno) {
    	
    	
        this.setBotonera(turno);
    }

    private void setBotonera( Turno turno) {

        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        BotonAtacarHandler atacarButtonHandler = new BotonAtacarHandler(turno);
        botonAtacar.setOnAction(atacarButtonHandler);
        
        
        Button botonAtaqueEspecial = new Button();
        botonAtaqueEspecial.setText("Ataque Especial");
        BotonAtaqueEspecialHandler ataqueEspecialButtonHandler = new BotonAtaqueEspecialHandler(turno);
        botonAtaqueEspecial.setOnAction(ataqueEspecialButtonHandler);

        Button botonMover = new Button();
        botonMover.setText("Mover");
        BotonMoverHandler moverButtonHandler = new BotonMoverHandler();
        botonMover.setOnAction(moverButtonHandler);
        
        Button botonEvolucionar = new Button();
        botonEvolucionar.setText("Evolucionar");
        BotonEvolucionarHandler evolucionarButtonHandler = new BotonEvolucionarHandler(turno);
        botonEvolucionar.setOnAction(evolucionarButtonHandler);

        VBox contenedorVertical = new VBox(botonMover, botonAtaqueEspecial, botonAtacar, botonEvolucionar);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);

    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
/*
   private void setCentro(Robot robot) {

        canvasCentral = new Canvas(460, 220);
        vistaRobot = new VistaRobot(robot, canvasCentral);
        vistaRobot.dibujar();

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }*/
/*
    private void setConsola() {

        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }
    */

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }


}
