package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * A class representing the login window.
 * 
 * @author Marian Claudiu Culea
 * @version 1.2 - 17/12/2018
 */
public class LoginView
{
   @FXML
   private Label error;

   @FXML
   private TextField username;

   @FXML
   private TextField password;

   private String title;
   private Scene scene;
   private GUI gui;
   /**
    * One-argument constructor. Setting up the scene and title.
    * 
    * @param gui
    *           The gui.
    */
   public LoginView(GUI gui)
   {
      
      try
      {
         this.gui = gui;
         this.title = "Add Admin";
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(GUI.class.getResource("AddAdmin1.fxml"));
         loader.setController(this);
         Pane root = loader.load();
         this.scene = new Scene(root, 600, 300);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
/**
 * getter for the scene
 * @return the scene
 */
   public Scene getScene()
   {
      
      return scene;
   }
/**
 * getter for the title
 * @return the title
 */
   public String getTitle()
   {
      
      return title;
   }
   /**
    * Initializing the fields to be empty.
    */
   public void initialize()
   {
      
      username.setText("");
      password.setText("");
      error.setText("");
   }
   /**
    * Returns the user to the MainView.
    */
   @FXML
   public void cancelpressed()
   {
      
      gui.setWindow("main");
   }
   /**
    * Calls executeLogin method in the controller with the user name and the
    * password as parameters.
    */
   @FXML
   public void addpressed()
   {
      
      gui.getController().executeLogin(username.getText(), password.getText());
   }
   /**
    * Displays an error on the screen.
    * 
    * @param error1
    *           the error that is displaying.
    */
   public void showError(String error1)
   {
      
      error.setText(error1);
   }
   /**
    * Moving the username and the passowrd in to a String array.
    * @param type
    *          String representing the user and pass
    * @return a string array with user and password
    */
   public String[] getInput(String type)
   {
      
      return new String[] { username.getText(), password.getText() };
   }

}
