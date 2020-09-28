package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.entity.Project;
import model.exception.AlreadyExistsExpcetion;
import model.exception.InputToShortException;

public class ProjectNewFormController {
    @FXML
    private HBox anchorProjectNewForm;
    @FXML
    private TextField inputProjectName;
    @FXML
    private Label labelNameException;
    @FXML
    private Label actionTitle;
    @FXML
    private TextArea inputDescription;
    @FXML
    private Button buttonSubmit;

    private Project project;
    private boolean isCreating = true;

    public void editingProject(Project project){
        this.project = project;
        this.inputProjectName.setText(project.getName());
        this.inputDescription.setText(project.getDescription());
    }

    public void setTitle(String title){
        this.actionTitle.setText(title);
    }

    public void setButtonSubmitText(String text){
        this.buttonSubmit.setText(text);
    }

    public void isCreating(boolean is){
        this.isCreating = is;
    }

    @FXML
    void closeForm() {
        StackPane form = (StackPane)anchorProjectNewForm.getParent();
        form.getChildren().remove(anchorProjectNewForm);
    }

    @FXML
    void createProject() {
        if ( this.isCreating ){
            try {
                Project newProj = new Project(inputProjectName.getText(), inputDescription.getText());
                newProj.saveNewProject();
                labelNameException.setText("Projeto salvo");
                this.inputProjectName.setText("");
                this.inputDescription.setText("");
            }
            catch (Exception e) {
                labelNameException.setText("Não salvou");
            }
        }else {
            this.project.updateThis(inputProjectName.getText(), inputDescription.getText());
        }
    }

    @FXML
    void verifyInputName(){
        String input = inputProjectName.getText();
        try {
            verifyLength(input);
            Project verify = new Project(input, "");
            verify.verifyExistence();
            buttonSubmit.setDisable(false);
            labelNameException.setText("");
        }
        catch (InputToShortException e) {
            labelNameException.setText("Muito curto");
            buttonSubmit.setDisable(true);
        }
        catch (AlreadyExistsExpcetion alreadyExistsExpcetion) {
            labelNameException.setText("Já existe");
            buttonSubmit.setDisable(true);
        }
    }

    private void verifyLength(String string) throws InputToShortException {
        if (string.length() < 5)
            throw new InputToShortException();
    }
}