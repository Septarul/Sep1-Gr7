package view;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * A class representing the GUI.
 * @author Marian Claudiu Culea
 * @version 1.5 - 17/12/2018
 */
public class GUI extends Application implements GuiInterface
{
   private Controller controller;
   private Stage primaryStage;
   private MainView mainView;
   private LoginView w13;
   private AddAdminView w1;
   private LoggedMain w2;
   private String currentViewID;

   private static GUI me;

   public GUI()
   {
      if (me == null)
      {
         me = this;
      }
   }

   @Override 
   public void start(Controller controller)
   {
      /**
       * Launches the GUI giving it a controller.
       * @param controller
       *          the controller.
       */
      this.controller = controller;

      new Thread(new Runnable()
      {
         public void run()
         {
            Application.launch(GUI.class);
         }
      }).start();
   }

   
   public void start(Stage primaryStage)
   {
      /**
       * Giving the GUI a primary stage.
       * @param primaryStage
       *          the stage that will be displaying.
       */
      if (this != me)
      {
         me.start(primaryStage);
         return;
      }
      this.primaryStage = primaryStage;
      this.mainView = new MainView(this);
      primaryStage.setScene(mainView.getScene());
      primaryStage.setTitle(mainView.getTitle());
      primaryStage.show();
   }
   
   public Controller getController()
   {
      /**
       * Returns the controller.
       */
      return controller;
   }

   public void setWindow(String type)
   {
      /**
       * Changing the primary to the specified stage.
       * @param type
       *         a string that represents the Id of a window. 
       */
      this.currentViewID = type;
      try
      {
         switch (currentViewID)
         {
            case "main":
               if (mainView == null)
               {
                  mainView = new MainView(this);
               }
               else
               {
                  mainView.initialize();
               }
               primaryStage.setScene(mainView.getScene());
               primaryStage.setTitle(mainView.getTitle());
               break;
            case "login":
               if (w13 == null)
               {
                  w13 = new LoginView(
                        this);
               }
               else
               {
                  w13.initialize();
               }
               primaryStage.setScene(w13.getScene());
               primaryStage.setTitle(w13.getTitle());
               break;
            case "addadmin":
               if (w1 == null)
               {
                  w1 = new AddAdminView(
                        this);
               }
               else
               {
                  w1.initialize();
               }
               primaryStage.setScene(w1.getScene());
               primaryStage.setTitle(w1.getTitle());
               break;
            case "logged":
               if (w2 == null)
               {
                  w2 = new LoggedMain(
                        this);
               }
               else
               {
                  w2.initialize();
               }
               primaryStage.setScene(w2.getScene());
               primaryStage.setTitle(w2.getTitle());
               break;
            } 
         primaryStage.show();
      }
      catch (Exception e)
      {
      }
   }

   @Override
   public Object[] getInput(String type)
   {
      /**
       * Returning the input of an specific window.
       * @param type
       *         a string that represents the Id of a window. 
       * @return the Object array from the window to the id type.
       */
      switch (currentViewID)
      {
         case "MAIN":
            return mainView.getInput(type);
         case "login":
          return w13.getInput(type);
      }
      return null;
   }

   @Override
   public void showError(String error)
   {
      /**
       * Displaying an error on an specific window.
       * @param error
       *         a string that represents the error. 
       *
       */
      switch (currentViewID)
      {
         case "main":
            mainView.showError(error);
            break;
          case "login":
             w13.showError(error);
          break;
      }
   }

}
