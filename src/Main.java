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

        int fmax = (Math.max(one, Math.max(two, Math.max(three, four))));

        if(four == fmax)
        {
            if(contains(DistanceFromOpponent - 4))
                return "move;" + (DistanceFromOpponent - 4);
        }
        else if(three == fmax)
        {
            if(contains(DistanceFromOpponent - 3))
                return "move;" + (DistanceFromOpponent - 3);
        }
        else if(two == fmax)
        {
            if(contains(DistanceFromOpponent - 2))
                return "move;" + (DistanceFromOpponent - 2);
        }
        else if(one == fmax)
        {
            if(contains(DistanceFromOpponent - 1))
                return "move;" + (DistanceFromOpponent - 1);
        }

        return "NULL";
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
