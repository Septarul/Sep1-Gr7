package view;

import controller.Controller;
import javafx.stage.Stage;
/**
 * 
 * @author Radu Candea
 * @version 3.1 - 17/12/2018
 */
public interface GuiInterface
{

   public void start(Controller controller);
   public void start(Stage primaryStage);
   public Object[] getInput(String type);
   public void showError(String error);
   public void setWindow(String type);

}
