package dad.javafx.mvc.escenario1.ver;

public class VerController {
	
	private VerModel model = new VerModel();
	private VerView view = new VerView();
	
	public VerController() {
		
		view.getProgressBar().progressProperty().bind(model.valorProperty().divide(100.0));
		
		view.getProgressLabel().textProperty().bind(model.valorProperty().asString());
	
		model.setValor(75);
	}
	
	public VerView getView() {
		return view;
	}
	
	public VerModel getModel() {
		return model;
	}

}
