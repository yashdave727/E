import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WordCounter extends Application {
	
	private TextArea text;
	private Button button1, button2;
	private Label label;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		initUI(stage);
	}
	
	private void initUI(Stage stage) {
		
		VBox pane = new VBox();
		
		text = new TextArea();
		
		label = new Label();
		
		button1 = new Button("Count Words");
		button2 = new Button("Count Characters");
		
		pane.getChildren().add(text);
		
		pane.getChildren().add(button1);
		pane.getChildren().add(button2);
		
		pane.getChildren().add(label);
		
		button1.setOnAction(new Counter1(label, text));
		button2.setOnAction(new Counter2(label, text));
		
		Scene scene = new Scene(pane, 300, 300);
		
		stage.setTitle("Word Counter");
		stage.setScene(scene);
		stage.show();
	}
}


class Counter1 implements EventHandler<ActionEvent> {

	private TextArea text;
	private Label label;

	Counter1(Label label, TextArea text) {
		this.label = label;
		this.text = text;
	}

	@Override
	public void handle(ActionEvent event) {
			
			String[] acc = this.text.getText().split(" ");
			
			if (this.text.getText().isEmpty()) {
				this.label.setText("There are " + 0 + " word(s)");
			}
			else {
				this.label.setText("There are " + acc.length + " word(s)");
			}
		
	}


}
	

	class Counter2 implements EventHandler<ActionEvent> {
		
		private Label label;
		private TextArea text;

		Counter2(Label label, TextArea text) {
			this.label = label;
			this.text = text;
		}

		@Override
		public void handle(ActionEvent event) {
			
			this.label.setText("There are " + this.text.getLength() + " character(s)");
			
		}
	
	
}
