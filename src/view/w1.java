package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class w1
{
   @FXML
   private Label errorLabel;

   @FXML
   private TextField userField;

   @FXML
   private TextField passField;

   private String title;
   private Scene scene;
   private GUI gui;

   public w1(GUI gui)
   {
      try
      {
         this.gui = gui;
         this.title = "Add Admin";
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(
               GUI.class.getResource("AddAdmin.fxml"));
         loader.setController(this);
         Pane root = loader.load();
         this.scene = new Scene(root, 520, 300);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public Scene getScene()
   {
      return scene;
   }

   public String getTitle()
   {
      return title;
   }
   
   public void initialize()
   {
      userField.setText("");
      passField.setText("");
   }
   
   @FXML
   public void cancelpressed() {
      gui.getController().executeAddAdmin();
   }
   
   @FXML
   private void cancelButtonSelected()
   {
      nextWindow();
   }
   
   public void showError(String error)
   {
      errorLabel.setText(error);
   }

   public void nextWindow()
   {
      getScene().getWindow().hide();
      gui.setWindow("MAIN");
   }


}
