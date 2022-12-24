package FilesManager;

import Champions.Champion;

import java.util.ArrayList;

import static MainPackage.MainClass.filemanager;

public class StoreFilter {
    public ArrayList<Champion> getChampionsList(){
       return filemanager.readFileToList("Store.txt");
    }
}
