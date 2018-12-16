package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class w2
{
   @FXML
   private Label errorLabel;

   @FXML
   private TextField firstnameField;

   @FXML
   private TextField lastnameField;

   @FXML
   private TextField trainedField;

   @FXML
   private TextField prefField;

   private String title;
   private Scene scene;
   private GUI gui;
   
   public w2(GUI gui)
   {
      try
      {
         this.gui = gui;
         this.title = "Add Employee";
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(
               GUI.class.getResource("AddEmployee.fxml"));
         loader.setController(this);
         Pane root = loader.load();
         this.scene = new Scene(root, 520, 500);
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
      firstnameField.setText("");
      lastnameField.setText("");
      trainedField.setText("");
      prefField.setText("");
   }
   
   @FXML
   public void addpressed() {
      
   }
   
   @FXML
   public void cancelpressed() {
      
   }
}
