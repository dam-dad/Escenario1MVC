package dad.javafx.mvc.escenario1.ver;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VerView extends VBox {
	
	private ProgressBar progressBar;
	private Label progressLabel;
	
	public VerView() {
		super();
		
		progressBar = new ProgressBar();
		progressLabel = new Label();
		
		HBox progressBox = new HBox(5, new Label("Valor actual:"), progressLabel);

		this.setSpacing(5);
		this.setFillWidth(false);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(progressBar, progressBox);
	}
	
	public ProgressBar getProgressBar() {
		return progressBar;
	}
	
	public Label getProgressLabel() {
		return progressLabel;
	}

}
