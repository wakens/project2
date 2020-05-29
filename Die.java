import java.util.Random;

// 
// Decompiled by Procyon v0.5.36
// 

class Die
{
    private int value;
    private Random rand;
    
    public Die() {
        this.value = 0;
        this.rand = new Random();
    }
    
    public void roll() {
        this.value = 1 + this.rand.nextInt(6);
    }
    
    public int get() {
        return this.value;
    }
}
