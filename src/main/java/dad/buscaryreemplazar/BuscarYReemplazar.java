package dad.buscaryreemplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYReemplazar extends Application {

	private Label etiqueta1;
	private Label etiqueta2;
	
	private TextField texto1;
	private TextField texto2;
	
	private CheckBox izqArriba;
	private CheckBox izqAbajo;
	private CheckBox derArriba;
	private CheckBox derAbajo;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		etiqueta1 = new Label("Buscar:");
		etiqueta2 = new Label("Reemplazar con: ");
		
		texto1 = new TextField();
		texto2 = new TextField();
		
		Button boton1 = new Button("Buscar");
		Button boton2 = new Button("Reemplazar");
		Button boton3 = new Button("Reemplazar todo");
		Button boton4 = new Button("Cerrar");
		Button boton5 = new Button("Ayuda");
		
		boton1.setMaxWidth(Double.MAX_VALUE);
		boton2.setMaxWidth(Double.MAX_VALUE);
		boton3.setMaxWidth(Double.MAX_VALUE);
		boton4.setMaxWidth(Double.MAX_VALUE);
		boton5.setMaxWidth(Double.MAX_VALUE);
		
		izqArriba = new CheckBox("Mayúsculas y minúsculas");
		izqAbajo = new CheckBox("Expresión regular");
		derArriba = new CheckBox("Buscar hacia atrás");
		derAbajo = new CheckBox("Resaltar resultados");
		
		
		
		GridPane izquierda = new GridPane();
		
		izquierda.addRow(0, etiqueta1, texto1);
		izquierda.addRow(1, etiqueta2, texto2);
		
		GridPane centro = new GridPane();

		centro.addRow(0, izqArriba, derArriba);
		centro.addRow(1, izqAbajo, derAbajo);
	
		izquierda.add(centro,1, 2);
		
		VBox derecha = new VBox();
		derecha.getChildren().addAll(boton1,boton2,boton3,boton4,boton5);
		derecha.setPadding(new Insets(5));
		
		ColumnConstraints[] cols = 
			{
				new ColumnConstraints(),
				new ColumnConstraints()
			};
		
		cols[1].setFillWidth(true);
		cols[1].setHgrow(Priority.ALWAYS);
		
		izquierda.getColumnConstraints().addAll(cols);

		BorderPane root= new BorderPane();
		root.setCenter(izquierda);
		root.setRight(derecha);
		root.setPadding(new Insets(5));
		
		BorderPane.setMargin(izquierda, new Insets(5));
		BorderPane.setAlignment(derecha, Pos.CENTER);
		
		Scene scene = new Scene(root, 640, 480);
		
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
