import java.util.Random;

class Die
{
    // INSTANCE VARIABLES
    private int value;
    private Random rand;
    
    // GETTER 
    public int get() {
        return this.value;
    }
    
    // CONSTRUCTOR
    public Die() {
        this.value = 0;
        this.rand = new Random();
    }
   
    /*
     * This method sets the value to a random number between 1 and 6. 
     */
    public void roll() {
        this.value = 1 + this.rand.nextInt(6);
    }
}
