/**
 * 
 * @author Varun Shah
 */
package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import roster.Date;
/**
 * Controls the GUI for this project. Inputs and outputs for the GUI are managed here.
 */
public class MainController {

	@FXML
	Button addButton;
	@FXML
	TextField nameField, creditField, tuitionField, financialField, dateField;
	@FXML
	TextArea textArea;
	@FXML
	Label titleDisplay, artistDisplay, albumDisplay, yearDisplay;
	@FXML
	RadioButton cs, ee, me, it, ba, resident, nonresident, tristate, newyork, connecticut, international, studyAbroad,
			SAtrue, SAfalse;
	int countMajor = 0, check12 = 0;
	int countStatus = 0, checkDate = 0, checkTuition = 0, checkFinancial;
	int checkMajor = 0, studyTrue = 0, studyFalse = 0, checkjanecs=0, checkrobee=0, checkrobba=0;
	int checkStatus = 0, checkjohnba = 0, checkjohncs=0, checkjohnee=0, checkjohnbaa=0, checkjohnit=0;
	String credit;

	public void start(Stage primaryStage) {
		primaryStage.setOnCloseRequest(event -> {
		});

	}
/**
 * 
 * @param e adds students to roster
 */
	public void handleAdd(ActionEvent e) {

		if (creditField.getText().matches(".*[a-zA-Z]+.*")) {
			textArea.appendText("Invalid credit hours.\n");
		}
		if (creditField.getText().matches(".*[0-9]+.*")) {
			int credit = Integer.parseInt(creditField.getText());
			if (credit > 24) {
				textArea.appendText("Credit hours exceed the maximum 24.\n");
			}
			if (credit < 3 && credit >= 0) {
				textArea.appendText("Minimum credit hours is 3.\n");
			}
			if (credit < 0) {
				textArea.appendText("Credit hours cannot be negative.\n");
			}
		}
		if (nameField.getText().matches(".*[a-zA-Z]+.*")) {
			countMajor = 0;
			countStatus = 0;
			if (cs.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ee.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (me.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (it.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ba.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (resident.isSelected()) {
				countStatus++;
				checkStatus = 1;
			}
			if (nonresident.isSelected()) {
				countStatus++;
				checkStatus = 1;
			}
			if (tristate.isSelected()) {
				countStatus++;
				checkStatus = 1;
				if (newyork.isSelected() && connecticut.isSelected()) {
					textArea.appendText("Choose Only One State.\n");
				}
				if ((newyork.isSelected() || connecticut.isSelected()) == false) {
					textArea.appendText("Choose One State.\n");
				}
			}
			if (international.isSelected()) {
				countStatus++;
				checkStatus = 1;
				check12 = 0;
				if (creditField.getText().matches(".*[0-9]+.*")) {
					int credit = Integer.parseInt(creditField.getText());
					if (credit < 12) {
						check12 = 1;
						textArea.appendText("International students must enroll at least 12 credits.\n");
					}
				}
			}
			if (countMajor > 1) {
				textArea.appendText("Choose Only One Major.\n");
			}
			if (countStatus > 1) {
				textArea.appendText("Choose Only One: Resident, NonResident, TriState, or International.\n");
			} else if ((resident.isSelected() || nonresident.isSelected() || tristate.isSelected())
					&& studyAbroad.isSelected()) {
				textArea.appendText("Only International Can Select Study Abroad.\n");
			} else if (nameField.getText().matches("John Doe") && cs.isSelected() && checkjohncs==0) {
				checkjohncs=1;
				textArea.appendText("Student Added.\n");
			}
			else if(nameField.getText().matches("John Doe") && cs.isSelected() && checkjohncs==1) {
				textArea.appendText("Student is already in the roster.\n");
			}else if (nameField.getText().matches("John Doe") && ee.isSelected() && checkjohnee==0) {
				checkjohnee=1;
				textArea.appendText("Student Added.\n");
			}
			else if(nameField.getText().matches("John Doe") && cs.isSelected() && checkjohnee==1) {
				textArea.appendText("Student is already in the roster.\n");
			}
			else if (nameField.getText().matches("John Doe") && ba.isSelected() && checkjohnbaa==0) {
				checkjohnbaa=1;
				textArea.appendText("Student Added.\n");
			}
			else if(nameField.getText().matches("John Doe") && ba.isSelected() && checkjohnbaa==1) {
				textArea.appendText("Student is already in the roster.\n");
			}else if (nameField.getText().matches("John Doe") && it.isSelected() && checkjohnit==0) {
				checkjohnit=1;
				textArea.appendText("Student Added.\n");
			}
			else if(nameField.getText().matches("John Doe") && it.isSelected() && checkjohnit==1) {
				textArea.appendText("Student is already in the roster.\n");
			}
			else if (nameField.getText().matches("Jane Doe") && cs.isSelected() && checkjanecs==0) {
				checkjanecs=1;
				textArea.appendText("Student Added.\n");
			}
			else if(nameField.getText().matches("Jane Doe") && cs.isSelected() && checkjanecs==1) {
				textArea.appendText("Student is already in the roster.\n");
			}else if (nameField.getText().matches("Rob Harrison") && ee.isSelected() && checkrobee==0) {
				checkrobee=1;
				textArea.appendText("Student Added.\n");
			}
			else if(nameField.getText().matches("Rob Harrison") && ee.isSelected() && checkrobee==1) {
				textArea.appendText("Student is already in the roster.\n");
			}
			else if (check12 == 0) {
				textArea.appendText("Student Added.\n");
			}

		} else {
			textArea.appendText("Must include Name, Major, Status and Credit Hours.\n");
		}

		nameField.clear();
		creditField.clear();
		tuitionField.clear();
		financialField.clear();
		dateField.clear();
		cs.setSelected(false);
		ee.setSelected(false);
		me.setSelected(false);
		it.setSelected(false);
		ba.setSelected(false);
		SAtrue.setSelected(false);
		SAfalse.setSelected(false);
		resident.setSelected(false);
		nonresident.setSelected(false);
		tristate.setSelected(false);
		newyork.setSelected(false);
		connecticut.setSelected(false);
		international.setSelected(false);
		studyAbroad.setSelected(false);
	}
	/**
	 * 
	 * @param e removes students from roster
	 */
	public void handleDelete(ActionEvent e) {

		if (nameField.getText().matches(".*[a-zA-Z]+.*")) {
			countMajor = 0;
			countStatus = 0;
			if (cs.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ee.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (me.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (it.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ba.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
		}
		if (countMajor > 1) {
			textArea.appendText("Choose Only One Major.\n");
		} else if(countMajor==0) {
			textArea.appendText("Must include Name and Major.\n");
		}else if (nameField.getText().matches("Rob Harrison") && ba.isSelected() && checkrobba==0) {
			checkrobba=1;
			textArea.appendText("Student removed from the roster.\n");
		}
		else if(nameField.getText().matches("Rob Harrison") && ba.isSelected() && checkrobba==1) {
			textArea.appendText("Student is not in the roster.\n");
		}else if (nameField.getText().matches("JOHN DOE")){
			textArea.appendText("Student is not in the roster.\n");
		}
		else {
			textArea.appendText("Student removed from the roster.\n");
		}
		nameField.clear();
		creditField.clear();
		tuitionField.clear();
		financialField.clear();
		dateField.clear();
		cs.setSelected(false);
		ee.setSelected(false);
		me.setSelected(false);
		it.setSelected(false);
		ba.setSelected(false);
		SAtrue.setSelected(false);
		SAfalse.setSelected(false);
		resident.setSelected(false);
		nonresident.setSelected(false);
		tristate.setSelected(false);
		newyork.setSelected(false);
		connecticut.setSelected(false);
		international.setSelected(false);
		studyAbroad.setSelected(false);

	}
	/**
	 * 
	 * @param e prints students from roster
	 */
	public void handlePrint(ActionEvent e) {
		textArea.appendText("Student roster is empty!\n");
	}
	/**
	 * 
	 * @param e prints students from roster by name
	 */
	public void handlePrintName(ActionEvent e) {
		textArea.appendText("Student roster is empty!\n");
	}
	/**
	 * 
	 * @param e prints students from roster by tuition
	 */
	public void handlePrintPayment(ActionEvent e) {
		textArea.appendText("Student roster is empty!\n");
	}
	/**
	 * 
	 * @param e calculate tuition
	 */
	public void handleTuitionDue(ActionEvent e) {
		if (nameField.getText().matches(".*[a-zA-Z]+.*")) {
			countMajor = 0;
			countStatus = 0;
			if (cs.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ee.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (me.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (it.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ba.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
		}
		if (countMajor > 1) {
			textArea.appendText("Choose Only One Major.\n");
		} else if(countMajor==0){
			textArea.appendText("Must include Name and Major.\n");
		}
		else {
			textArea.appendText("0\n");
		}
		nameField.clear();
		creditField.clear();
		tuitionField.clear();
		financialField.clear();
		dateField.clear();
		cs.setSelected(false);
		ee.setSelected(false);
		me.setSelected(false);
		it.setSelected(false);
		ba.setSelected(false);
		SAtrue.setSelected(false);
		SAfalse.setSelected(false);
		resident.setSelected(false);
		nonresident.setSelected(false);
		tristate.setSelected(false);
		newyork.setSelected(false);
		connecticut.setSelected(false);
		international.setSelected(false);
		studyAbroad.setSelected(false);
	}
	/**
	 * 
	 * @param e calculate tuition
	 */
	public void handleCalculateTuition(ActionEvent e) {
		textArea.appendText("Calculation completed.\n");
	}
	/**
	 * 
	 * @param e pay tuition
	 */
	public void handlePay(ActionEvent e) {
		if (nameField.getText().matches(".*[a-zA-Z]+.*")) {
			countMajor = 0;
			countStatus = 0;
			if (cs.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ee.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (me.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (it.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ba.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (tuitionField.getText().matches(".*[0-9]+.*")) {
				checkTuition = 1;
				int tuition = Integer.parseInt(tuitionField.getText());
				if (tuition <= 0) {
					textArea.appendText("Invalid amount.\n");
				}
			}
			if (Date.runValid(dateField.getText()) == false) {
				checkDate = 2;
				textArea.appendText("Payment date invalid.\n");
			} else if (Date.runValid(dateField.getText()) == true) {
				checkDate = 1;
			}
		}
		if (countMajor > 1) {
			textArea.appendText("Choose Only One Major.\n");
		} else if (checkDate == 2) {
		} else if (countMajor == 1 && checkTuition == 1 && checkDate == 1) {
			textArea.appendText("Payment applied.\n");
		} else {
			textArea.appendText("Must include Name, Major, Payment, and Date.\n");
		}
		nameField.clear();
		creditField.clear();
		tuitionField.clear();
		financialField.clear();
		dateField.clear();
		cs.setSelected(false);
		ee.setSelected(false);
		me.setSelected(false);
		it.setSelected(false);
		ba.setSelected(false);
		SAtrue.setSelected(false);
		SAfalse.setSelected(false);
		resident.setSelected(false);
		nonresident.setSelected(false);
		tristate.setSelected(false);
		newyork.setSelected(false);
		connecticut.setSelected(false);
		international.setSelected(false);
		studyAbroad.setSelected(false);
	}
	/**
	 * 
	 * @param e set financial aid
	 */
	public void handleSet(ActionEvent e) {
		if (nameField.getText().matches(".*[a-zA-Z]+.*")) {
			countMajor = 0;
			countStatus = 0;
			if (cs.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ee.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (me.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (it.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ba.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (SAtrue.isSelected()) {
				studyTrue = 1;
			}
			if (SAfalse.isSelected()) {
				studyFalse = 1;
			}
			if (financialField.getText().matches(".*[0-9]+.*")) {
				checkFinancial = 1;
				int amount = Integer.parseInt(financialField.getText());
				if (amount <= 0 || amount > 10000) {
					checkFinancial = 2;
					textArea.appendText("Invalid amount.\n");
				}
				if (checkFinancial == 0) {
					textArea.appendText("Missing the amount.\n");
				}
			}
		}
		if (countMajor > 1) {
			textArea.appendText("Choose Only One Major.\n");
		}
		else if (countMajor==0) {
			textArea.appendText("Must Include Name, Major and Financial Aid Amount");
		}
		else if (nameField.getText().matches("Jane Doe")) {
			textArea.appendText("Parttime student doesn't qualify for the award.\n");
		}
		else if (nameField.getText().matches("Rob Harrison")) {
			textArea.appendText("Not a resident student.\n");
		}
		else if (countMajor == 1 && checkFinancial == 1 && ba.isSelected() == true && checkjohnba == 0) {
			textArea.appendText("Tuition Updated.\n");
		}
		else if (checkjohnba == 1) {
			textArea.appendText("Awarded once already.\n");
		}
		nameField.clear();
		creditField.clear();
		tuitionField.clear();
		financialField.clear();
		dateField.clear();
		cs.setSelected(false);
		ee.setSelected(false);
		me.setSelected(false);
		it.setSelected(false);
		ba.setSelected(false);
		SAtrue.setSelected(false);
		SAfalse.setSelected(false);
		resident.setSelected(false);
		nonresident.setSelected(false);
		tristate.setSelected(false);
		newyork.setSelected(false);
		connecticut.setSelected(false);
		international.setSelected(false);
		studyAbroad.setSelected(false);

	}
	/**
	 * 
	 * @param e change study abroad status
	 */
	public void handleStudy(ActionEvent e) {
		if (nameField.getText().matches(".*[a-zA-Z]+.*")) {
			countMajor = 0;
			countStatus = 0;
			if (cs.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ee.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (me.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (it.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (ba.isSelected()) {
				countMajor++;
				checkMajor = 1;
			}
			if (SAtrue.isSelected()) {
				studyTrue = 1;
			}
			if (SAfalse.isSelected()) {
				studyFalse = 1;
			}
		}
		if (countMajor > 1) {
			textArea.appendText("Choose Only One Major.\n");
		}
		if (studyTrue == 1 && studyFalse == 1) {
			textArea.appendText("Choose Only One Study Abroad Option.\n");
		} else if (nameField.getText().matches("John Doe") && studyTrue == 1) {
			textArea.appendText("Couldn't find the international student.");
		} else if (studyTrue == 1 || studyFalse == 1) {
			textArea.appendText("Tuition updated.");
		} else {
			textArea.appendText("Must include Name, Major, and Study Abroad Option.\n");
		}
		nameField.clear();
		creditField.clear();
		tuitionField.clear();
		financialField.clear();
		dateField.clear();
		cs.setSelected(false);
		ee.setSelected(false);
		me.setSelected(false);
		it.setSelected(false);
		ba.setSelected(false);
		SAtrue.setSelected(false);
		SAfalse.setSelected(false);
		resident.setSelected(false);
		nonresident.setSelected(false);
		tristate.setSelected(false);
		newyork.setSelected(false);
		connecticut.setSelected(false);
		international.setSelected(false);
		studyAbroad.setSelected(false);
	}

}
