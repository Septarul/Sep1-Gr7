
import controller.Controller;
import model.Model;
import model.ModelManager;
import view.GUI;
import view.GuiInterface;


public class Main
{
   public static void main(String[] args) throws Exception
   {
      Model model = new ModelManager();
      GuiInterface view = new GUI();
      Controller controller = new Controller(model, view);
      view.start(controller);
   }
}
