package GameEnviroment;

import Arena.Arena;
import Champions.Champion;
import Champions.ChampionStates;
import Champions.Classes.*;
import GameEnviroment.Rounds.PlanningPhase;
import GameEnviroment.Rounds.Round;
import Iterators.Iiterable;
import Iterators.Iiterator;
import Moves.BattleMove;
import Players.AutoPlayer;
import Players.ConsolePlayer;
import Players.Player;
import java.util.ArrayList;

public class Game implements ICustomizable{

    private RoundsManager RoundsManager;
    private ArrayList<Player> Players;
    private Arena ArenaField;
    private Customization customization;

    public Game(Customization customization) {
        this.customization=customization;
        if(customization.getGameName()==GameName.TacticalChaos)
            RoundsManager=new TacticalChaosTM();
        Players=new ArrayList();
        ArenaField=Arena.getArena();
        ArenaField.setArena(customization.getArenax(),customization.getArenay());
       // for(int i=0;i<customization.getNumberofplayers();i++)
         //   Players.add(new ConsolePlayer(customization.getTempstorelimit(),i));
        for(int i=0;i<customization.getNumberofbots();i++)
            Players.add(new AutoPlayer(customization.getTempstorelimit(),i));
    }

    public void runGame(){
        RoundsManager.runTurn();
    }










    public class TacticalChaosTM extends RoundsManager{
        public class Demon extends Class {

            public Demon(ArrayList<Champion> currentChampions){
                super(currentChampions);
            }

            public void activateClass(){

            }

        }
        public class Dragons extends Class {
            public Dragons(ArrayList<Champion> currentChampions){
                super(currentChampions);
            }

            public void activateClass() {

            }
        }
        ArrayList <BattleMove> listOfPossibleMoves;
        public void insertListOfMoves(){

        }
        public TacticalChaosTM(){
            ManagerIterator=GetIterator();
        }
        public void addPlayers(){

        }
        public void runTurn(){
            Round currentRound=ManagerIterator.GetNext();
            PlanningPhase Planning=new PlanningPhase();
            for(int i=0;i<customization.getNumberofrounds();i++) {
                for (int j = 0; j < Players.size(); j++)
                    Players.get(j).startplanning(Planning.getTemporalList());

                for (int z = 0; z < Players.size(); z++) {
                    for (Champion j : Players.get(z).getChampionList())
                        for (BattleMove k : j.getListOfMoves())
                            k.performMove();
                }
            }
            for(int i=0;i<Players.size();i++)
                System.out.println(Players.get(i).getChampionList());
            for(int i=0;i<Players.size();i++)
                for(Champion j:Players.get(i).getChampionList())
                    if(j.getState()== ChampionStates.Dead)
                        Players.get(i).getChampionList().remove(j);
        }
        public void Execute(){}
    }






    abstract public class RoundsManager implements Iiterable {
        protected ArrayList<Round> RoundsList;
        protected RoundsManagerIterator ManagerIterator;
        public RoundsManager(){RoundsList=new ArrayList();}
        abstract public void runTurn();
        abstract public void Execute();

        abstract public class Class {
            protected ArrayList<Champion> currentChampions;
            public abstract void activateClass();
            public Class(ArrayList<Champion> currentChampions){
                this.currentChampions=currentChampions;
            }
        }





        public RoundsManagerIterator GetIterator() { return new RoundsManagerIterator(); }
        private class RoundsManagerIterator implements Iiterator{
            private int index=0;
            @Override
            public boolean HasNext() {
                if(index<customization.getNumberofrounds())
                    return true;
                return false;
            }

            @Override
            public Round GetNext() {
                if(HasNext())
                    RoundsList.add(new Round());
                return RoundsList.get(index++);
            }
        }
    }
}
