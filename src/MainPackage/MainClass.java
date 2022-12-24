package MainPackage;

import Arena.Arena;
import FilesManager.FileManager;
import GameEnviroment.Customization;
import GameEnviroment.Game;
import GameEnviroment.GameName;
import Players.ConsolePlayer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import MainPackage.Window;



public class MainClass {

    public static FileManager filemanager;

    public static void main(String[] args) {
            Window x=new Window();
            x.runner(args);
            filemanager = FileManager.getInstance();
            filemanager.addFile("Champions.txt");
            filemanager.addFile("Store.txt");
            filemanager.addNewChampions("Store.txt");
            //filemanager.addNewChampions("Champions.txt");
            //filemanager.addChampionList("Store.txt", "Champions.txt");//Add From Champions To Store
            Game game=new Game(new Customization(10,10,1,5,2,4,5, GameName.TacticalChaos));
            game.runGame();
            //filemanager.printFileInformation("Store.txt");
            filemanager.closeFile("Store.txt");
            filemanager.deleteFile("Store.txt");

    }
}
