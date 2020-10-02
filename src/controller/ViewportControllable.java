package controller;

import javafx.scene.Parent;
import model.entity.Project;

public interface ViewportControllable {
    void setContent(Parent child);
    void removeContent(Parent content);
    void addPopup(Parent popup);
    void removePopup(Parent popup);
    void updateProjectName(String name);
    void openProject(Project project);
    void closeProject();
}
