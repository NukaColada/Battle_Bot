
public class Bot
{
    private int DistanceFromWater;
    private int DistanceFromOpponent;
    private int[] Titles;

    public Bot()
    {
        DistanceFromWater = - 1;
        DistanceFromOpponent = -1;
        Titles = null;
    }

    public Bot(int distanceFromWater, int distanceFromOpponent, int[] titles) {
        DistanceFromWater = distanceFromWater;
        DistanceFromOpponent = distanceFromOpponent;
        Titles = titles;
    }

    public int getDistanceFromWater() {
        return DistanceFromWater;
    }

    public void setDistanceFromWater(int distanceFromWater) {
        DistanceFromWater = distanceFromWater;
    }

    public int getDistanceFromOpponent() {
        return DistanceFromOpponent;
    }

    public void setDistanceFromOpponent(int distanceFromOpponent) {
        DistanceFromOpponent = distanceFromOpponent;
    }

    public int[] getTitles() {
        return Titles;
    }

    public void setTitles(int[] titles) {
        Titles = titles;
    }
}
