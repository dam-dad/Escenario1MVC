package dad.javafx.mvc.escenario1.modificar;

import javafx.event.ActionEvent;
import javafx.util.converter.NumberStringConverter;

public class ModificarController {
	
	private ModificarModel model = new ModificarModel();
	private ModificarView view = new ModificarView();
	
	public ModificarController() {
		
		view.getValorText().textProperty().bindBidirectional(model.intermedioProperty(), new NumberStringConverter());
		
		view.getEstablecerButton().setOnAction(e -> onEstablecerAction(e));

		view.getIncrementarButton().setOnAction(e -> onIncrementarAction(e));

		view.getDecrementarButton().setOnAction(e -> onDecrementarAction(e));

	}
	
	public ModificarView getView() {
		return view;
	}
	
	public ModificarModel getModel() {
		return model;
	}
	
	// listeners

	private void onIncrementarAction(ActionEvent e) {
		model.setValor(model.getValor() + 1);
	}

	private void onDecrementarAction(ActionEvent e) {
		model.setValor(model.getValor() - 1);
	}

	private void onEstablecerAction(ActionEvent e) {
		model.setValor(model.getIntermedio());
	}

}
