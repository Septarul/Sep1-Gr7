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

   public LoginView(GUI gui)
   {
      /**
       * One-argument constructor. Setting up the scene and title.
       * 
       * @param gui
       *           The gui.
       */
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

   public Scene getScene()
   {
      /**
       * Returns the scene.
       */
      return scene;
   }

   public String getTitle()
   {
      /**
       * Returns the title.
       */
      return title;
   }

   public void initialize()
   {
      /**
       * Initializing the fields to be empty.
       */
      username.setText("");
      password.setText("");
      error.setText("");
   }

   @FXML
   public void cancelpressed()
   {
      /**
       * Returns the user to the MainView.
       */
      gui.setWindow("main");
   }

   @FXML
   public void addpressed()
   {
      /**
       * Calls executeLogin method in the controller with the username and the
       * password as parameters.
       */
      gui.getController().executeLogin(username.getText(), password.getText());
   }

   public void showError(String error1)
   {
      /**
       * Displays an error on the screen.
       * 
       * @param error
       *           the error that is displaying.
       */
      error.setText(error1);
   }

   public String[] getInput(String type)
   {
      /**
       * Moving the username and the passowrd in to a String array.
       */
      return new String[] { username.getText(), password.getText() };
   }

}
