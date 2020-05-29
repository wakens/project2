import java.util.Arrays;

class Winnings
{
    // INSTANCE VARIABLES
    private int score;
    private int choice;
    static String[] WINSS;
    
    /*
	 * This is just a way to have all the variables inside be static.
	 */
    static {
        Winnings.WINSS = new String[] { "QUIT", "YAHTZEE", "FULL HOUSE", "LARGE STRAIGHT", "SMALL STRAIGHT", "FOUR OF A KIND", "THREE OF A KIND", "A PAIR", "TWO PAIRS", "NUMBER OF 1'S", "NUMBER OF 2'S", "NUMBER OF 3'S", "NUMBER OF 4'S", "NUMBER OF 5'S", "NUMBER OF 6'S", "CHANCE" };
    }
    
    // GETTERS
    public int score() { return this.score; }
    public int choice() { return this.choice; }
    
    // CONSTRUCTOR
    public Winnings() {
        this.score = 0;
    }
    
    /*
     * This method looks at the 5 dice numbers the user has gotten, checks for any special winning cases
     * and adds the winnings to show the user what they've won.
     */
    public void checkWinnings(final int[] aDice, final int[] wins) {
        this.choice = MiniYahtzee.w.option(Winnings.WINSS, "Which do you want to see if you have?");
        int x = 0;
        int y = 0;
        int winings = 0;
        int winingsa = 0;
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;
        Arrays.sort(aDice);
        for (y = 0; y < 5; ++y) {
            if (aDice[y] == 1) {
                ++ones;
            }
            if (aDice[y] == 2) {
                ++twos;
            }
            if (aDice[y] == 3) {
                ++threes;
            }
            if (aDice[y] == 4) {
                ++fours;
            }
            if (aDice[y] == 5) {
                ++fives;
            }
            if (aDice[y] == 6) {
                ++sixes;
            }
        }
        if (aDice[0] == aDice[1] - 1 && aDice[1] == aDice[2] - 1 && aDice[2] == aDice[3] - 1 && aDice[3] == aDice[4] - 1 && this.choice == 3) {
            winingsa = 1;
        }
        else if (ones > 0 && twos > 0 && threes > 0 && fours > 0) {
            winingsa = 2;
        }
        else if (threes > 0 && fours > 0 && fives > 0 && sixes > 0) {
            winingsa = 2;
        }
        else if (twos > 0 && threes > 0 && fours > 0 && fives > 0) {
            winingsa = 2;
        }
        for (x = 0; x < 5; ++x) {
            if (x != 0 && aDice[0] == aDice[x]) {
                ++winings;
            }
            if (x != 0 && x != 1 && aDice[1] == aDice[x]) {
                ++winings;
            }
            if (x != 0 && x != 1 && x != 2 && aDice[2] == aDice[x]) {
                ++winings;
            }
            if (x != 0 && x != 1 && x != 2 && x != 3 && aDice[3] == aDice[x]) {
                ++winings;
            }
        }
        if (winingsa == 1 && this.choice == 3) {
            MiniYahtzee.w.msg("You have a large straight!");
            this.score = 40;
        }
        else if (winingsa == 2 && this.choice == 4) {
            MiniYahtzee.w.msg("You have a small straight!");
            this.score = 30;
        }
        else if (winings == 10 && this.choice == 1) {
            MiniYahtzee.w.msg("Yatzee!");
            this.score = 50;
        }
        else if (this.choice == 6 && winings >= 3) {
            MiniYahtzee.w.msg("You have three of a kind.");
            this.score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
        }
        else if (this.choice == 7 && winings > 0) {
            MiniYahtzee.w.msg("You have a pair.");
            this.score = 5;
        }
        else if (winings == 2 && this.choice == 8) {
            MiniYahtzee.w.msg("You have two pairs.");
            this.score = 10;
        }
        else if (winings == 4 && this.choice == 2) {
            MiniYahtzee.w.msg("You have a full house.");
            this.score = 25;
        }
        else if (winings >= 6 && this.choice == 5) {
            MiniYahtzee.w.msg("You have four of a kind.");
            this.score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
        }
        else if (this.choice == 9) {
            MiniYahtzee.w.msg("You have " + ones + " one(s).");
            this.score = ones;
        }
        else if (this.choice == 10) {
            MiniYahtzee.w.msg("You have " + twos + " two(s).");
            this.score = twos * 2;
        }
        else if (this.choice == 11) {
            MiniYahtzee.w.msg("You have " + threes + " three(s).");
            this.score = threes * 3;
        }
        else if (this.choice == 12) {
            MiniYahtzee.w.msg("You have " + fours + " four(s).");
            this.score = fours * 4;
        }
        else if (this.choice == 13) {
            MiniYahtzee.w.msg("You have " + fives + " five(s).");
            this.score = fives * 5;
        }
        else if (this.choice == 14) {
            MiniYahtzee.w.msg("You have " + sixes + " sixe(s).");
            this.score = sixes * 6;
        }
        else if (this.choice == 15) {
            this.score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
            MiniYahtzee.w.msg("Your get " + this.score + " point(s).");
        }
    }
}
