package Arena;

import java.util.ArrayList;

public class Arena {
    private int x,y;
    private static Arena arena;
    private Square[][] ArenaField;
    public void setArena(int x,int y) {
        this.x=x;
        this.y=y;
        if(ArenaField==null)
        {ArenaField=new Square[x][];
        for(int i=0;i<x;i++)
            ArenaField[i]=new Square[y];
        for(int i=0;i<x;i++)
            for(int j=0;j<y;j++)
                ArenaField[i][j]=new Square();}
    }
    public static Arena getArena(){if(arena==null)
        arena=new Arena();
        return arena; }
    private Arena() {}
    public boolean outOfBound(int x, int y){
        if(x < 0 || x >= ArenaField.length)
            return true;
        else return y < 0 || y >= ArenaField[0].length;
    }
    public boolean exists(Object X,int x,int y){
        for(Object Y : get(x,y)) {
            if(X.equals(Y))
            return true;
        }
        return false;
    }
    public ArrayList get(int x, int y){ return ArenaField[x][y].getList(); }
    public String getInfo(int x, int y){ return ArenaField[x][y].toString(); }
    public void add(Object X, int x, int y){ ArenaField[x][y].add(X); }
    public void remove(Object X,int x,int y){ ArenaField[x][y].remove(X);}
    public boolean exists(String name,int x,int y){
        for(int i=0;i<get(x,y).size();i++) {
            if(name.equals(getInfo(x,y)))
                return true;
        }
        return false;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
