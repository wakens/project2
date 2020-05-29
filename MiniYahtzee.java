import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.5.36
// 

public class MiniYahtzee
{
    static Window w;
    static String[] NUMS;
    static String[] YES;
    
    static {
        MiniYahtzee.NUMS = new String[] { "0", "1", "2", "3", "4", "5" };
        MiniYahtzee.YES = new String[] { "QUIT", "CONTINUE PLAYING" };
        MiniYahtzee.w = new Window();
    }
    
    public static void main(final String[] args) {
        int play = 1;
        int scorea = 0;
        int sum = 0;
        final int[] wins = new int[15];
        while (play == 1 && sum < 15) {
            sum = 0;
            final int[] aDice = new int[5];
            int roll = 0;
            int rerolla = 0;
            int rerollb = 3;
            final Die die = new Die();
            for (int x = 0; x < 5; ++x) {
                die.roll();
                aDice[x] = die.get();
            }
            MiniYahtzee.w.msg("Welcome to Yahtzee! \nThe game will start after you press okay, and then you must decide which dice you want to reroll. \nYou will only get one look at your dice so make sure to remember which it is! \n");
            MiniYahtzee.w.msg("Die 1: " + aDice[0] + "               Die 2: " + aDice[1] + "               Die 3: " + aDice[2] + "               Die 4: " + aDice[3] + "               Die 5: " + aDice[4]);
            do {
                rerolla = MiniYahtzee.w.option(MiniYahtzee.NUMS, "How many total dice do you want to reroll? (0-5)");
                if (rerolla > 0) {
                    final int[] reroll = new int[rerolla];
                    for (int y = 0; y < rerolla; ++y) {
                        rerollb = MiniYahtzee.w.option(MiniYahtzee.NUMS, "Which ones?");
                        reroll[y] = rerollb;
                    }
                    for (int w = 0; w < rerolla; ++w) {
                        if (reroll[w] == 1) {
                            die.roll();
                            aDice[0] = die.get();
                        }
                        if (reroll[w] == 2) {
                            die.roll();
                            aDice[1] = die.get();
                        }
                        if (reroll[w] == 3) {
                            die.roll();
                            aDice[2] = die.get();
                        }
                        if (reroll[w] == 4) {
                            die.roll();
                            aDice[3] = die.get();
                        }
                        if (reroll[w] == 5) {
                            die.roll();
                            aDice[4] = die.get();
                        }
                    }
                    ++roll;
                    MiniYahtzee.w.msg("Die 1: " + aDice[0] + "               Die 2: " + aDice[1] + "               Die 3: " + aDice[2] + "               Die 4: " + aDice[3] + "               Die 5: " + aDice[4]);
                }
            } while (roll < 2 && rerolla > 0);
            final Winnings prize = new Winnings();
            prize.checkWinnings(aDice, wins);
            if (prize.choice() == 0) {
                MiniYahtzee.w.msg("You've decided to quit Yahtzee.");
                break;
            }
            wins[prize.choice() - 1] = 1;
            for (int z = 0; z < 15; ++z) {
                sum += wins[z];
            }
            scorea += prize.score();
            MiniYahtzee.w.msg("Your total score this game was: " + scorea);
            if (sum < 15) {
                play = MiniYahtzee.w.option(MiniYahtzee.YES, "Do you want to continue playing or quit?");
            }
            else {
                MiniYahtzee.w.msg("GAME OVER! Your total points were ");
            }
        }
    }
    
    static int inputInt(final String Prompt) {
        int result = 0;
        try {
            result = Integer.parseInt(input(Prompt).trim());
        }
        catch (Exception e) {
            result = 0;
        }
        return result;
    }
    
    static String input(final String prompt) {
        String inputLine = "";
        System.out.print(prompt);
        try {
            final InputStreamReader sys = new InputStreamReader(System.in);
            final BufferedReader inBuffer = new BufferedReader(sys);
            inputLine = inBuffer.readLine();
        }
        catch (Exception e) {
            final String err = e.toString();
            System.out.print(err);
        }
        return inputLine;
    }
}
