import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Write a comparator that sorts them in order of decreasing score.
//If 2 or more players have the same score, sort those players alphabetically by name.

class Player{
    String name;
    int score;
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player>{

    @Override
    public int compare(Player a, Player b) {
        if (b.score == a.score) {
            return a.name.compareTo(b.name);
        } else {
            return Integer.compare(b.score, a.score);
        }
    }

}

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Player[] player = new Player[n];
        Checker checker = new Checker();
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        Arrays.sort(player, checker);
        for (Player value : player) {
            System.out.printf("%s %s\n", value.name, value.score);
        }

    }
}