import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main
{

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine())
        {
            String input = sc.nextLine();

            Bot bot = CorrentInput(input);

            System.out.println(bot.getMove());
        }


    }

    private static Bot CorrentInput(String input)
    {
        //Getting Titles

        int[] Titles = new int[5];
        for(int i=2;i<7;i++)
            Titles[i-2] = Character.getNumericValue(input.charAt(i));

        //Setting input based on what player

        String island = input.substring(8);
        int DistanceFromWater;
        int DistanceFromOpponent =island.indexOf('2') - island.indexOf('1');

        //for Player 1
        if(Character.getNumericValue(input.charAt(0)) == 1)
            DistanceFromWater =  island.indexOf('1');
        else // For Player 2
            DistanceFromWater = 14 - island.indexOf('2');

        return new Bot(DistanceFromWater,DistanceFromOpponent,Titles);
    }

}

class Bot
{
    private int DistanceFromWater;
    private int DistanceFromOpponent;
    private int[] Titles;

    public Bot()
    {
        //
    }

    public Bot(int distanceFromWater, int distanceFromOpponent, int[] titles)
    {
        DistanceFromWater = distanceFromWater;
        DistanceFromOpponent = distanceFromOpponent;
        Titles = titles;
    }

    private int retreat()
    {
        if(!Arrays.asList(Titles).contains(DistanceFromOpponent) && Arrays.asList(Titles).contains(4 - DistanceFromOpponent))
            return 25;

        return -1;
    }

    private int move()
    {
        if(DistanceFromWater < 4)
            return 50;

        else
            return 25;
    }


    private int attack()
    {
        if(DistanceFromOpponent > 4)
            return -1;

        else if(Arrays.asList(Titles).contains(DistanceFromOpponent))
        {
            int occurrences = Collections.frequency(Arrays.asList(Titles), DistanceFromOpponent);
            System.err.println("ENTER");
            if(occurrences == 1)
                return 50;
            else if(occurrences == 2)
                return 75;
            else
                return 100;
        }

        else
        return  -1;

    }

    String getMove()
    {
        int attack = attack();
        int retreat = retreat();
        int move = move();

        int max = Math.max(attack,Math.max(retreat,move));

        System.err.print("Max:" + max + "Attack:" + attack + "Move: " + move + "Retreat:" + retreat);


        if(max == attack)
           return "attack;" + Collections.frequency(Arrays.asList(Titles), DistanceFromOpponent) * DistanceFromOpponent;
        else if(max == move)
           return "move;" + Titles[0];
        else
           return "retreat" + Titles[0];

    }

}



