package FilesManager;

import Champions.Champion;
import Champions.IAttributes;
import Champions.Util;

import java.util.ArrayList;

public class FileManager {
    private static ArrayList<WriterReaderStore> filesList;
    private static FileManager fileManager;
    private FileManager() {
        filesList =new ArrayList();
    }
    public static FileManager getInstance() {
        if (fileManager == null)
            fileManager = new FileManager();
        return fileManager;
    }
    public void addFile(String path){
        filesList.add(new WriterReaderStore(path));
    }

    public ArrayList readFileToList(String path){
        int index= getPathIndex(path);
        if (index != -1) {
            return filesList.get(index).readObjectList();
        } else {
            System.out.println("This file doesn't exist");
            return null;
        }
    }

    public void closeFile(String path) {
        try{
            int index= getPathIndex(path);
            if (index == -1)
                return;
            filesList.get(index).Closer();
        }catch(Exception e){}
    }
    public void printFileInformation(String path){
        int index= getPathIndex(path);
        if (index == -1)
            return;
        ArrayList List = filesList.get(index).readObjectList();
        for (Object i : List){
            System.out.println(i);
        }
    }
    public int getPathIndex(String path){
        for (int i = 0 ; i < filesList.size() ; i++){
            String filePath = filesList.get(i).getPath();
            if (filePath.equals(path)){
                return i;
            }
        }
        return -1;
    }
    public void addChampionList(String path,String path2){
        int index= getPathIndex(path);
        if (index == -1)
            return;
        ArrayList champion = readFileToList(path2);
        for(Object i : champion){
            filesList.get(index).addObject(i);
        }
    }
    public void addNewChampions(String path) {
        int index= getPathIndex(path);
        if (index == -1)
            return;
        while (Util.hasNext()) {

            String temp = Util.nextLine();
            String name = temp.substring(0,temp.indexOf(' '));
            temp=temp.substring(temp.indexOf(':')+1);


            String Health=temp.substring(0,temp.indexOf(','));
            int health = Integer.parseInt(Health);

            temp=temp.substring((temp.indexOf(',')+1));

            temp=temp.substring((temp.indexOf(':')+1));

            String MoveSpeed=temp.substring(0,temp.indexOf(','));
            int movespeed=Integer.parseInt(MoveSpeed);

            temp=temp.substring(temp.indexOf(':')+1);

            String VisionRange=temp.substring(0,temp.indexOf(','));
            int visionrange=Integer.parseInt(VisionRange);

            temp=temp.substring(temp.indexOf(':')+1);

            String AttackDamage=temp.substring(0,temp.indexOf(','));
            int attackDamage=Integer.parseInt(AttackDamage);

            temp=temp.substring(temp.indexOf(':')+1);

            String AttackRange=temp.substring(0,temp.indexOf(','));
            int attackrange=Integer.parseInt(AttackRange);

            temp=temp.substring(temp.indexOf(':')+1);

            String Armor=temp.substring(0,temp.indexOf(','));
            int armor=Integer.parseInt(Armor);

            temp=temp.substring(temp.indexOf(':')+1);

            String CricitalStrikeChance=temp.substring(0,temp.indexOf(','));
            int cricitalstrikechance=Integer.parseInt(CricitalStrikeChance);

            temp=temp.substring(temp.indexOf(':')+1);

            String CricitalStrikeDamage=temp.substring(0,temp.indexOf(','));
            float cricitalstrikedamage=Float.parseFloat(CricitalStrikeDamage);

            temp=temp.substring(temp.indexOf(':')+1);

            String MagicResist=temp.substring(0,temp.indexOf(','));
            int magicresist=Integer.parseInt(MagicResist);



            Champion champion1 = new Champion(name);
            IAttributes champion1Attributes=champion1.getAttributesInstance();

            champion1.setAttributes(champion1Attributes);
            champion1Attributes.setAttribute(health,movespeed,visionrange,attackDamage,attackrange,armor,cricitalstrikechance,cricitalstrikedamage,magicresist);
            filesList.get(index).addObject(champion1);
        }
    }
    /*public void removeObject(String path,int i){
        int index= getPathIndex(path);
        if (index == -1)
            return;
        ArrayList removeList = filesList.get(index).readObject();
        removeList.remove(i);
        closeFile(path);
        deleteFile(path);
        createFile(path);
        for(Object j:removeList)
            filesList.get(index).addObject(j);
    }*/
    /*public void createFile(String path){
        new WriterReaderStore(path);
    }*/
    public void deleteFile(String path){
        int index= getPathIndex(path);
        if (index == -1)
            return;
        if(filesList.get(index).deleteFile()){
            System.out.println("file " +path+" deleted successfully.. ");
        } else {
            System.out.println("file " +path+" couldn't be deleted");
        }
    }
}

