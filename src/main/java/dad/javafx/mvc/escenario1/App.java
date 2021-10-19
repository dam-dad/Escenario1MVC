package dad.javafx.mvc.escenario1;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import dad.javafx.mvc.escenario1.modificar.ModificarController;
import dad.javafx.mvc.escenario1.ver.VerController;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private static final File FICHERO = new File("valor.txt");

	
	// model
	
	private IntegerProperty valor = new SimpleIntegerProperty(25);
	
	// controllers
	
	private ModificarController modificarController;
	private VerController verController;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		// modificar
		
		modificarController = new ModificarController();
		
		Scene modificarScene = new Scene(modificarController.getView(), 320, 200);
		
		Stage modificarStage = new Stage();
		modificarStage.setTitle("Modificar");
		modificarStage.setScene(modificarScene);
		modificarStage.show();
		
		// ver

		verController = new VerController();
		
		Scene verScene = new Scene(verController.getView(), 320, 200);
		
		Stage verStage = new Stage();
		verStage.setTitle("Ver");
		verStage.setScene(verScene);
		verStage.show();
		
		// bindings
		
		modificarController.getModel().valorProperty().bindBidirectional(valor);
		verController.getModel().valorProperty().bind(valor);
		
		
		// listeners

		modificarController.getModel().valorProperty().addListener((o, ov, nv) -> {
			System.out.println("antes valía " + ov + " y ahora valgo " + nv);
		});
		
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("iniciando mi aplicación");
		
		// leemos el valor desde un fichero, y si no existe, usamos 50
		if (FICHERO.exists()) {
			String contenido = Files.readString(FICHERO.toPath(), StandardCharsets.UTF_8);
			valor.set(Integer.parseInt(contenido));
		} else
			valor.set(50);
		
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("cerrando mi aplicación");
		
		// escribimos el valor en un fichero
		Files.writeString(FICHERO.toPath(), "" + valor.get(), StandardCharsets.UTF_8);
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}