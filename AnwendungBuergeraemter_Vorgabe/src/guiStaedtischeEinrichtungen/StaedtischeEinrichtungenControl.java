package guiStaedtischeEinrichtungen;

import business.BuergeraemterModel;
import guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer{

	private StaedtischeEinrichtungenView seView;
	private BuergeraemterModel baModel;
	
	public StaedtischeEinrichtungenControl(Stage secondStage) {
		baModel = BuergeraemterModel.getInstance();
		seView = new StaedtischeEinrichtungenView(this, secondStage, baModel);
		baModel.addObserver(this);
	}

	@Override
	public void update() {
		seView.zeigeBuergeraemterAn();
		
	}

	
}
