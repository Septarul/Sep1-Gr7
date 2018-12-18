package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * A class representing the window to add an admin.
 * 
 * @author Marian Claudiu Culea
 * @version 1 - 17/12/2018
 */
public class AddAdminView
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

   public AddAdminView(GUI gui)
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
         loader.setLocation(GUI.class.getResource("AddAdmin.fxml"));
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
       * Returns the user to the MainLoggedView.
       */
      gui.setWindow("logged");
   }

   @FXML
   public void addpressed()
   {
      /**
       * Adds the admin to the admin list in the ModelManager.
       */

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

}
