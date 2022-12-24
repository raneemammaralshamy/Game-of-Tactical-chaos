package GameEnviroment.Rounds;

import Champions.Champion;
import FilesManager.StoreFilter;

import java.util.ArrayList;

public class PlanningPhase {
    public ArrayList<Champion> getTemporalList(){
        StoreFilter TemporalStore=new StoreFilter();
        return TemporalStore.getChampionsList(); }
}
