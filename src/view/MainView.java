package view;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Task;

public class MainView
{
   @FXML private TableView<MainViewModel> customerTable;
   @FXML private TableColumn<MainViewModel, String> dayColumn;
   @FXML private TableColumn<MainViewModel, Task> taskColumn;
   
   
   
   
   
}
