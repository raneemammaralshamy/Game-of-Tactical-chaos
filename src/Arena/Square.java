package Arena;

import java.util.ArrayList;

public class Square {
    private ArrayList List;
    public Square(){
        List = new ArrayList();
    }
    public String toString(){
        if(List.size() == 0)
            return "###";
        if(List.size()>1)
            return "...";
        return List.get(List.size() - 1).toString();
    }

    public ArrayList getList(){
        return List;
    }
    public void remove(Object X){List.remove(X);}
    public Object getChampion(){
        if(List.size() == 0)
            return null;
        return List.get(List.size() - 1);
    }
    public void add(Object X){
        List.add(X);
    }
}
