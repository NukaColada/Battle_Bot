import java.util.Scanner;

public class Main
{

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        String input = "1;14344;000010000000002";

        CorrentInput(input);


    }

    private static void CorrentInput(String input)
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

    }

}
