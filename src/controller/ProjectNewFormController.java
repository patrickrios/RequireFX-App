package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.entity.Project;
import model.exception.AlreadyExistsExpcetion;
import model.exception.InputToShortException;

public class ProjectNewFormController extends LayoutController{
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
        super.getLayoutController().removePopup(anchorProjectNewForm);
    }

    @FXML
    void createProject() {
        String projectName = inputProjectName.getText();
        String projectDesc = inputDescription.getText();
        if ( this.isCreating ){
            try {
                Project newProj = new Project(projectName, projectDesc);
                newProj.saveNewProject();
                labelNameException.setText("Projeto salvo");
                this.inputProjectName.setText("");
                this.inputDescription.setText("");
                super.getLayoutController().removePopup(anchorProjectNewForm);
                super.getLayoutController().openProject(newProj);
            }
            catch (Exception e) {
                labelNameException.setText("Não salvou");
            }
        }else {
            this.project.updateThis(inputProjectName.getText(), inputDescription.getText());
            super.getLayoutController().updateProjectName(projectName);
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