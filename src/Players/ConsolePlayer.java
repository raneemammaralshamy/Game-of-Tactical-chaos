package Players;
import Arena.Arena;
import Champions.Champion;
import Champions.IAttributes;
import Moves.AttackMove;
import Moves.WalkMove.WalkMoveFactory;
import Moves.WalkMove.WalkMove;

import java.util.ArrayList;
import java.util.Random;


public class ConsolePlayer extends Player {

    public ConsolePlayer(int tempstorelimit,int id) {super(tempstorelimit,id); }

    public void startplanning(ArrayList<Champion> listOfChampions){
        System.out.println("Player "+id);
        System.out.println("0-Exit");
        System.out.println("1-Store");
        System.out.println(currentChampions);
        if(currentChampions.size()>0)//&& ChampionsNotStunned() && ChampionsNotDead()
        System.out.println("2-Champion's Interactions");
        int choice=scanner.nextInt();
        switch(choice) {
            case 0:
                return ;
            case 1:
                buyNewChamps(listOfChampions);
                break;
            case 2:
                interactWithChampions();
                break;
        }
    }

    private void buyNewChamps(ArrayList<Champion> listOfChampions) {
        Random rand = new Random();
        int choice = 0;
        int choicesindex[] = new int[tempstorelimit];
        boolean[] choicexists = new boolean[tempstorelimit];
        int r;
        int championstoreindex[] = new int[tempstorelimit];
        System.out.println("Select A Champion\n0-Exit");
        for (int i = 0; i < tempstorelimit; i++) {
            r = rand.nextInt(listOfChampions.size());
            if (!exists(r, championstoreindex)) {
                System.out.println(i + 1 + "-" + listOfChampions.get(r));
                championstoreindex[i] = r;
            } else if (i == listOfChampions.size() - 1)
                break;
            else i--;
        }
        int x, i, y;
        for (i = 0; i < tempstorelimit; i++) {
            choice = scanner.nextInt();
            if (choice == 0)
                break;
            if (choice > tempstorelimit || choicexists[choice - 1]) {
                i--;
                System.out.println("Invalid Input");
                continue;
            }
            choicexists[choice - 1] = true;
            choicesindex[i] = championstoreindex[choice - 1];
            System.out.print("Enter The Position\nx:");
            x = scanner.nextInt();
            System.out.print("y:");
            y = scanner.nextInt();
            listOfChampions.get(championstoreindex[choice - 1]).setX(x);
            listOfChampions.get(championstoreindex[choice - 1]).setY(y);
            Arena.getArena().add(listOfChampions.get(championstoreindex[choice-1]),x,y);
            listOfChampions.get(championstoreindex[choice -1 ]).setName(listOfChampions.get(championstoreindex[choice-1]).getName()+id+0);
            currentChampions.add(listOfChampions.get(championstoreindex[choice - 1]));
        }

        choicesindex = sort(choicesindex);
        for (int j = 0; j < i; j++)
            System.out.println(choicesindex[j]);
        for (int j = 0; j < i; j++)
            listOfChampions.remove(choicesindex[j]);

        }


    private void championsTargets(){

        for(int i=0;i<currentChampions.size();i++)
            X.add(new ArrayList());
        for(int l=0;l<currentChampions.size();l++) {
            IAttributes attributes = currentChampions.get(l).getAttributes();
            for (int i = currentChampions.get(l).getX() - attributes.getBaseAttackRange(); i <= currentChampions.get(l).getX() + attributes.getBaseAttackRange(); i++)
                for (int j = currentChampions.get(l).getY() - attributes.getBaseAttackRange(); j <= currentChampions.get(l).getY() + attributes.getBaseAttackRange(); j++)
                    if(!Arena.getArena().outOfBound(i,j))
                    for(Object k:Arena.getArena().get(i,j)) {
                        Champion current=(Champion)k;
                        if(id!=Integer.parseInt(current.getName().substring(current.getName().length()-2,current.getName().length()-1)))
                            X.get(l).add(current);
                    }
        }
    }


    private void interactWithChampions(){
        championsTargets();
        int choice1=-1;
        int choice2=-1;
        boolean listOfChoices[]=new boolean[9];
        while(true) {
            System.out.println("0-Exit");
            for (int i = 0; i < currentChampions.size(); i++)
                if (X.get(i).size() > 0 && !listOfChoices[i])
                    System.out.println(i + 1+"-" + currentChampions.get(i).getName());
                choice1 = scanner.nextInt();
                if (choice1 == 0)
                    break;
                listOfChoices[choice1-1] = true;
                //Don't Show Attack In Case Of No Potential Targets
            System.out.println("0-Exit\n1-Attack\n2-Move");
            choice2=scanner.nextInt();
            switch(choice2) {
                case 0:
                    listOfChoices[choice1-1] = false;
                    break;
                case 1:
                    int counter = 1;
                    for (Champion i : X.get(choice1 - 1))
                        System.out.println(counter++ + "-" + i);
                    choice2 = scanner.nextInt();
                    currentChampions.get(choice1 - 1).addMove(new AttackMove(currentChampions.get(choice1 - 1), X.get(choice1 - 1).get(choice2-1)));
                    break;
                case 2:
                    int i = 1;
                    int loop=0;
                    String a[] = new String[4];
                    IAttributes attributes = currentChampions.get(choice1 - 1).getAttributes();
                    if (!Arena.getArena().outOfBound(currentChampions.get(choice1 - 1).getX() + attributes.getBaseMoveSpeed(), currentChampions.get(choice1 - 1).getY())) {
                        System.out.println(i + "-Move Right");
                        i++;
                        a[loop] = "WalkRight";
                    }
                    loop++;
                    if (!Arena.getArena().outOfBound(currentChampions.get(choice1 - 1).getX() - attributes.getBaseMoveSpeed(), currentChampions.get(choice1 - 1).getY())) {
                        System.out.println(i + "-Move Left");
                        i++;
                        a[loop] = "WalkLeft";
                    }
                    loop++;
                    if (!Arena.getArena().outOfBound(currentChampions.get(choice1 - 1).getX(), currentChampions.get(choice1 - 1).getY() + attributes.getBaseMoveSpeed())) {
                        System.out.println(i + "-Move Up");
                        i++;
                        a[loop] = "WalkUp";
                    }
                    loop++;
                    if (!Arena.getArena().outOfBound(currentChampions.get(choice1 - 1).getX(), currentChampions.get(choice1 - 1).getY() - attributes.getBaseMoveSpeed())) {
                        System.out.println(i + "-Move Down");
                        i++;
                        a[loop] = "WalkDown";
                    }
                    WalkMoveFactory walkMoveFactory =new WalkMoveFactory(currentChampions.get(choice1-1));
                    WalkMove b=null;
                    choice2 = scanner.nextInt();
                    for (int j = 0; j < a.length; j++)
                        if (a[j] == null) {
                            continue;
                        } else {
                            choice2--;
                            if (choice2 == 0)
                                b = walkMoveFactory.getMoveInstance(a[j]);
                        }
                    currentChampions.get(choice1-1).addMove(b);
                        break;
                    }
            }
        }



    private boolean exists(int x,int a[]){
        if(a.length==0)
            return false;
        for(int i : a)
            if(x == i)
                return true;
        return false;
    }
    private int[] sort(int []a){
        int max;
        int y=0;
        int k=0;
        int temp[]=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            max=-10;
            for(int j=0;j<a.length;j++){
                if(a[j]>max) {
                    y=j;
                    max=a[j];
                }
            }
            temp[k]=max;
            a[y]=-10;
            k++;
        }
        return temp;
    }
}
