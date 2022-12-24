package MainPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class Window extends Application
{
    public Button button_y(String name, int x, int y)
    {
        Button button = new Button("Start Game");
        button.setTranslateX(100);
        button.setTranslateY(550);
        button.setFont(new Font("Arial", 35));
        return button;
    }

    @Override
    public void start(Stage stage) throws Exception{
        Button button = new Button("Start Game");
//        button=button_y("Start Game",100,550);
        button.setTranslateX(100);
        button.setTranslateY(550);
        button.setFont(new Font("Arial", 35));

        Button button1=new Button("Exit");
        button1.setTranslateX(350);
        button1.setTranslateY(550);
        button1.setOnAction(e->stage.close());
        button1.setFont(new Font("Arial",35));
        Label label =new Label("TACTICAL CHAOS");
        //  Label label1 =new Label("  HELLO \n LET'S START THE GAME!");
        label.setTranslateX(300);
        label.setTranslateY(150);
//        label1.setTranslateX(200);
//        label1.setTranslateY(40);
        Stage stage2 = new Stage();

        stage2.setTitle("Second Window");
        stage2.setMaxWidth(600);
        stage2.setMaxHeight(700);
        label.setFont(new Font("Cambria",50));
        label.setTextFill(Color.ANTIQUEWHITE);
//        label1.setFont(new Font("Cambria",80));
//        label1.setTextFill(Color.MINTCREAM);
        ImageView imageView=new ImageView("sample/1.jpg");
        imageView.setTranslateX(650);
        imageView.setTranslateY(300);

        Group root = new Group();

       // display_t game=new display_t();
        button.setOnAction((ActionEvent e) -> {

         //  display_t.display();
        });



        Scene scene = new Scene(root, 900, 700);
        scene.setFill(Color.TEAL);

        stage.setTitle("Tactical Chaos");


        stage.setScene(scene);
        root.getChildren().addAll(label,imageView,button,button1);
        root.getChildren().add(button_y("GG",650,300));
        stage.show();

    }
    public void runner(String[] args)
    {
        launch(args);
    }
}
