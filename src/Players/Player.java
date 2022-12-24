package Players;

import Arena.Arena;
import Champions.Champion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

abstract public class Player {
    protected int id;
    protected ArrayList<Champion> currentChampions;
    protected Scanner scanner;
    protected int tempstorelimit;
    protected ArrayList<ArrayList<Champion>> X;
    public Player(int tempstorelimit,int id){
        currentChampions =new ArrayList();
        X=new ArrayList();
        this.tempstorelimit=tempstorelimit;
        this.id=id;
    scanner=new Scanner(System.in);}
    abstract public void startplanning(ArrayList<Champion> TemporarStoreChampions);
    public ArrayList<Champion> getChampionList(){ return currentChampions; }
}
