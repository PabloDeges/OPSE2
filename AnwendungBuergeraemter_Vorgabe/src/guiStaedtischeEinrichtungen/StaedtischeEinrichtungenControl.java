package guiStaedtischeEinrichtungen;

import businessBuergeramt.BuergeraemterModel;
import businessSporthalle.SporthalleModel;
import guiBuergeraemter.BuergeraemterView;
import javafx.stage.Stage;
import ownUtil.Observer;

public class StaedtischeEinrichtungenControl implements Observer{

	private StaedtischeEinrichtungenView seView;
	private BuergeraemterModel baModel;
	private SporthalleModel shModel;
	
	public StaedtischeEinrichtungenControl(Stage secondStage) {
		baModel = BuergeraemterModel.getInstance();
		shModel = SporthalleModel.getInstance();
		seView = new StaedtischeEinrichtungenView(this, secondStage, baModel, shModel);
		baModel.addObserver(this);
		shModel.addObserver(this);
	}

	@Override
	public void update() {
		seView.zeigeBuergeraemterAn();
//		seView.zeigeSporthallenAn();
		
	}

	
}
