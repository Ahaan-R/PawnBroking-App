package pawnApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;

public class PawnManager extends Application {
	Stage window;
	Button button;

	public static void main(String[] args) {
		Application.launch(args);
	}

	

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Pawn Shop");
		button = new Button("Start");

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Pawn Shop by Ahaan,Karthik,Pradyoth");
		dialog.setContentText("Enter the number of customers");
		PawnItem[][] pawnitems = new PawnItem[100][100];
		Customer[] customer = new Customer[100];
		Pawn[] pawn = new Pawn[100];
		button.setOnAction(e -> {
			dialog.showAndWait();

			TextInputDialog dialog1, dialog2, dialog3, dialog4, dialog5, dialog6, dialog7, dialog8, dialog9, dialog10,
					dialogspec;

			int j = Integer.parseInt(dialog.getResult());
			System.out.println("the number of customers is " + j);

			Pawn pawnAfterRemoving = null;
			for (int i = 1; i <= j; i++) {
				dialog1 = new TextInputDialog();
				dialog1.setTitle("Customer Dialog");
				dialog1.setHeaderText("Customer no:" + i);
				dialog1.setContentText("Enter the First Name");
				dialog1.showAndWait();
				String d1 = dialog1.getResult();
				dialog2 = new TextInputDialog();
				dialog2.setTitle("Customer Dialog 2");
				dialog2.setHeaderText("Customer no:" + i);
				dialog2.setContentText("Enter the Last Name");
				dialog2.showAndWait();
				dialog3 = new TextInputDialog();
				dialog3.setTitle("Customer Dialog 3");
				dialog3.setHeaderText("Customer no:" + i);
				dialog3.setContentText("Enter the Customer ID");
				dialog3.showAndWait();
				customer[i] = new Customer(dialog1.getResult(), dialog2.getResult(),
						Integer.parseInt(dialog3.getResult()));
				pawn[i] = new Pawn(customer[i]);
				dialog4 = new TextInputDialog();
				dialog4.setTitle("Customer Dialog 4");
				dialog4.setHeaderText("Customer no:" + i);
				dialog4.setContentText("Enter the number of items you want to pawn");
				dialog4.showAndWait();
				dialogspec = new TextInputDialog();
				dialogspec.setTitle("Time Period");
				dialogspec.setHeaderText("Customer no:" + i);
				dialogspec.setContentText("Enter the Time period in days(Max 90)");
				dialogspec.showAndWait();
				int k = Integer.parseInt(dialog4.getResult());
				for (int m = 1; m <= k; m++) {

					dialog5 = new TextInputDialog();
					dialog5.setTitle("Customer Dialog 5 The name of the item");
					dialog5.setHeaderText("Customer no:" + i + " pawn item no:" + m);
					dialog5.setContentText("Enter the name of the item");
					dialog5.showAndWait();

					dialog6 = new TextInputDialog();
					dialog6.setTitle("Customer Dialog 6 The type of the item(gold,silver)");
					dialog6.setHeaderText("Customer no:" + i + " pawn item no:" + m);
					dialog6.setContentText("Enter the type of the item");
					dialog6.showAndWait();

					dialog7 = new TextInputDialog();
					dialog7.setTitle("Customer Dialog 7 The weight of the item");
					dialog7.setHeaderText("Customer no:" + i + " pawn item no:" + m);
					dialog7.setContentText("Enter the weight of the item");
					dialog7.showAndWait();

					dialog8 = new TextInputDialog();
					dialog8.setTitle("Customer Dialog 8 The karat of the item");
					dialog8.setHeaderText("Customer no:" + i + " pawn item no:" + m);
					dialog8.setContentText("Enter the karat of the item");
					dialog8.showAndWait();

					dialog9 = new TextInputDialog();
					dialog9.setTitle("Customer Dialog 9 The id of the item");
					dialog9.setHeaderText("Customer no:" + i + " pawn item no:" + m);
					dialog9.setContentText("Enter the id of the item");
					dialog9.showAndWait();
					pawnitems[i][m] = new PawnItem(dialog5.getResult(), dialog6.getResult(),
							Integer.parseInt(dialog7.getResult()), Integer.parseInt(dialog8.getResult()),
							Integer.parseInt(dialog9.getResult()));
					// = new PawnItem("Bracelet","gold",10,22,1);
					if (m == 1) {
						pawn[i].insertFirstPawnItem(pawnitems[i][m]);
					} else {
						pawn[i].insertNewPawnItem(pawnitems[i][m]);
					}

					double p = pawnitems[i][m].computeValue();
					System.out.println(p);
					try {
						ResultBox.display(d1, dialog3.getResult(), dialog4.getResult(), m, dialog5.getResult(),
								dialog6.getResult(), p);
					} catch (Exception e1) {
						System.out.println(e1);
					}

					try {
						AlertBox.display(d1, pawn[i].amountToBeReturned(Integer.parseInt(dialogspec.getResult())));
					} catch (Exception e2) {
						System.out.println(e2);
					}
					List<String> choices = new ArrayList<>();
					choices.add("Yes");
					choices.add("No");

					ChoiceDialog<String> d = new ChoiceDialog<>("Yes", choices);
					d.setTitle("Choice Dialog");
					d.setHeaderText("Do you want to remove any item?");
					d.setContentText("Yes/no");

					// Traditional way to get the response value.
					Optional<String> result = d.showAndWait();

					if (result.isPresent()) {
						if (d.getResult().equals("Yes")) {
							int count = 1;
							dialog10 = new TextInputDialog();
							dialog10.setTitle("Customer Dialog 10");
							dialog10.setHeaderText("Customer no:" + i);
							dialog10.setContentText("Enter the id of the item you want to delete");
							dialog10.showAndWait();
							PawnItem itemToBeRemoved = pawnitems[i][Integer.parseInt(dialog10.getResult())];
							System.out.println("Item to be removed : " + itemToBeRemoved);
							System.out.println(
									"id == 2 Yes? " + itemToBeRemoved.equals(new PawnItem("ui", "gold", 3.0f, 24, 2)));
							System.out.println("Number of items before removing = " + pawn[i].numberOfPawnItems());
							pawnAfterRemoving = pawn[i].removePawnItem(itemToBeRemoved);
							System.out.println(
									"Number of items after removing = " + pawnAfterRemoving.numberOfPawnItems());
							System.out.println("inside loop - " + "\n" + pawnAfterRemoving.display());

							System.out.println(pawnitems[i][Integer.parseInt(dialog10.getResult())].toString());

							 System.out.println(pawnitems[i][m].toString()+"");
							AlertBox.display(pawnitems[i][m].toString(),count);

						}
						else if (d.getResult().equals("No"))
						{
							int count = 0;
							
							 System.out.println(pawnitems[i][m].toString()+"");
								//AlertBox.display(pawnitems[i][m].toString(),count);
								
								AlertBox.display(pawn[i].display(),count);
								
								
						}
					}

				}

			}
			//AlertBox.display(pawnAfterRemoving.display());
		});// AlertBox.display("Title of Window", "Wow this alert box is
			// awesome!"));

		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
}

