package view;

import controller.Controller;
import javafx.stage.Stage;

public interface GuiInterface
{

   public void start(Controller controller);
   public void start(Stage primaryStage);

}
