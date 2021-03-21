/**
 * Move class is to create objects that are used with the Monster class (composition) 
 */
public class Move{
    private String name;          //a string to store the name of the move
    private String type;          //a string to store the type of the move
    private int power;            //an integer to store the power of the move
    private float accuracy;       //a float to store the accuracy stat of the move

    /**
    * A constructor for class Move to intialize the member variavles 
    * @param name
    * @param type 
    * @param power
    * @param accuracy 
    */ 
    public Move (String name, String type, int power, float accuracy){
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getPower() { return power; }
    public float getAccuracy() { return accuracy; }

    
}