package view;

import java.util.ArrayList;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application implements GuiInterface
{
   private Controller controller;
   private Stage primaryStage;

   private MainView mainView;
   private ViewControllerSearch viewControllerSearchView;
   private ViewControllerAddEmployee viewControllerAddEmployee;
   private ViewControllerAddTask viewControllerAddTask;
   private ViewControllerDayLogged viewControllerDayLogged;
   private ViewControllerDay viewControllerDay;
   private ViewControllerEmployeesLogged viewControllerEmplyeesLogged;
   private ViewControllerMainLogged viewControllerMainLogged;
   private String currentViewControllerID;

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
      this.controller = controller;

      new Thread(new Runnable()
      {
         public void run()
         {
            Application.launch(GUI.class);
         }
      }).start();
   }

   @Override // Application
   public void start(Stage primaryStage)
   {
      if (me != this)
      {
         me.start(primaryStage);
         return;
      }
      this.primaryStage = primaryStage;

      setWindow("MAIN");
   }
/*??
   public void setWindow(String type)
   {
      this.currentViewControllerID = type;
      try
      {
         switch (currentViewControllerID)
         {
            case "MAIN":
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
            case "SEARCH":
               if (viewControllerEditCustomer == null)
               {
                  viewControllerEditCustomer = new ViewControllerEditCustomer(
                        this);
               }
               primaryStage.setScene(viewControllerEditCustomer.getScene());
               primaryStage.setTitle(viewControllerEditCustomer.getTitle());
               break;
            case "SHOW":
               if (viewControllerEditCustomer == null)
               {
                  viewControllerEditCustomer = new ViewControllerEditCustomer(
                        this);
               }
               primaryStage.setScene(viewControllerEditCustomer.getScene());
               primaryStage.setTitle(viewControllerEditCustomer.getTitle());
               break;
            case "ELIST":
            case "TLIST":
            case "LOGIN":
            case "SHOW":
         }
         primaryStage.show();
      }
      catch (Exception e)
      {
      }
   }
*/
   @Override
   public Object[] getInput(String type)
   {
      switch (currentViewControllerID)
      {
         case "MAIN":
            return mainView.getInput(type);
         case "SEARCH":
          return viewControllerEditCustomer.getInput(type);
      }
      return null;
   }

   @Override // interface
   public void showOutput(Object[] output)
   {
      if (currentViewControllerID.equals("LIST"))
      {
         setWindow("ADD");
      }
      viewControllerEditCustomer.showOutput(output);
   }

   @Override // interface
   public void showError(String error)
   {
      switch (currentViewControllerID)
      {
         case "LIST":
            viewControllerCustomers.showError(error);
            break;
          case "ADD":
             viewControllerEditCustomer.showError(error);
          break;
      }
   }

   public Controller getController()
   {
      return controller;
   }

   @Override
   public void remove(ArrayList<Integer> indices)
   {
      viewControllerCustomers.remove(indices);
   }

   @Override
   public Integer[] confirmRemoving(Integer[] indices)
   {
      return viewControllerCustomers.confirmRemoving(indices);
   }
}
