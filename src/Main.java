import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Bot name = new Bot();

        name.firstMove(sc.nextLine());
        
        while(sc.hasNextLine()) {
            name.setInput(sc.nextLine());
            System.out.println(name.returnMove());
        }
            

    }
}
class Bot
{
    private int DistanceFromWater;
    private int DistanceFromOpponent;
    private int[] Titles;
    private int suffle = 0;

    public void setInput(String input)
    {
        //Getting Titles

        Titles = new int[5];
        for(int i=2;i<7;i++)
            Titles[i-2] = Character.getNumericValue(input.charAt(i));

        //Setting input based on what player

        String island = input.substring(8);

        DistanceFromOpponent =island.indexOf('2') - island.indexOf('1');

        //for Player 1
        if(Character.getNumericValue(input.charAt(0)) == 1)
            DistanceFromWater =  island.indexOf('1');
        else // For Player 2
            DistanceFromWater = 14 - island.indexOf('2');

    }
    private int getFrequency(int n)
    {
        int r =0;

        for(int x=0;x<Titles.length;x++)
        {
            if(Titles[x] == n)
            {
                r++;
            }
        }

        return r;
    }
    private boolean contains(int n)
    {
        for(int x=0;x<Titles.length;x++)
        {
            if(Titles[x] == n )
                return true;
        }
        return false;
    }

    private int attack()
    {

        if(contains(DistanceFromOpponent))
        {
            int occurrences = getFrequency(DistanceFromOpponent);

            if(occurrences == 1)
                return 24;
            else if(occurrences == 2)
                return 75;
            else
                return 100;
        }
        else
            return -1;


    }

    public String returnMove()
    {
        if(attack() >= 75)
        {
            String r = "attack;";

            for(int x=0;x<getFrequency(DistanceFromOpponent);x++)
                r += DistanceFromOpponent;

            return r;
        }

        int one = getFrequency(1);
        int two = getFrequency(2);
        int three = getFrequency(3);
        int four = getFrequency(4);

        int[] fmax = {one,two,three,four};
        Arrays.sort(fmax);

       for(int x=3;x>=0;x--)
       {
           if (contains(DistanceFromOpponent - fmax[x]) && attack() == -1)
               return "move;" + (DistanceFromOpponent - fmax[x]);
           if(contains(fmax[x] - DistanceFromOpponent))
               return "retreat;" + (fmax[x] - DistanceFromOpponent);
       }

        if(DistanceFromOpponent > 4)
        {
            if(contains(4))
                return "move;4";
            else if(contains(3))
                return "move;3";
            else if(contains(2))
                return "move;2";
            else if(contains(1))
                return "move;1";
        }

        suffle ++;
        System.err.print(suffle);
        return "shuffle";
    }


    public void firstMove(String s)
    {
        setInput(s);
        if(contains(4))
            System.out.println("move;4");
        else if(contains(3))
            System.out.println("move;3");
        else if(contains(2))
            System.out.println("move;2");
        else if(contains(1))
            System.out.println("move;1");


    }
}
