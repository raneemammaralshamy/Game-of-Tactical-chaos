package GameEnviroment;

public class Customization {
    private int arenax;
    private int arenay;
    private int teamsize;
    private int numberofrounds;
    private GameName gameName;
    private int numberofplayers;
    private int numberofbots;
    private int tempstorelimit;
    public Customization(int arenax,int arenay,
                         int teamsize,
                         int numberofrounds,
                         int numberofplayers,
                         int numberofbots,
                         int tempstorelimit,
                         GameName gameName){
        this.arenax=arenax;
        this.arenay=arenay;
        this.teamsize=teamsize;
        this.numberofrounds=numberofrounds;
        this.gameName=gameName;
        this.numberofplayers=numberofplayers;
        this.numberofbots=numberofbots;
        this.tempstorelimit=tempstorelimit;
    }
    public int getArenax() {
        return arenax;
    }
    public int getArenay() {
        return arenay;
    }
    public int getNumberofrounds() {
        return numberofrounds;
    }
    public int getTeamsize() {
        return teamsize;
    }
    public GameName getGameName() {
        return gameName;
    }
    public int getNumberofbots() {
        return numberofbots;
    }
    public int getNumberofplayers() {
        return numberofplayers;
    }
    public int getTempstorelimit() {
        return tempstorelimit;
    }
}
