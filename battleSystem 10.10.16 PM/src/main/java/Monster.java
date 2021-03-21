/**
 * Monster class is associated with the Move class (composition) 
 */
public class Monster {
    private String name;     // the name of the creature
    private String type;     //the type of the creature
    private int hp;          // the hit points of the creature
    private int speed;       //the speed stat of the creature
    private int attack;      //the attack stat of the creature
    private int defense;     //the defense stat of the creature
    private Move move1;      //an instance variable from the Move class to represent the player's first move
    private Move move2;      //an instance variable from the Move class to represent the player's second move
    private Move move3;      //an instance variable from the Move class to represent the player's third move
    private Move move4;      //an instance variable from the Move class to represent the player's fourth move

    /**
    * A constructor for class Monster to inatialize the member variables
    * @param name  
    * @param type
    * @param name  
    * @param hp
    * @param speed  
    * @param attack
    * @param defense  
    * @param move1
    * @param move2  
    * @param move3
    * @param move4
    */
    public Monster (String name, String type, int hp, int speed, int attack, int defense, Move move1, Move move2, Move move3, Move move4){
        this.name = name;
        this.type = type;
        this.hp= hp;
        this.speed = speed;
        this.attack = attack;
        this.defense= defense;
        this.move1 = move1;
        this.move2= move2;
        this.move3 = move3;
        this.move4 = move4;
    }  
    
    public String getName() { return name; }
    public String getType() { return type; }
    public int getHP() { return hp; }
    public int getSpeed() { return speed; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public Move getMove1() { return move1; }
    public Move getMove2() { return move2; }
    public Move getMove3() { return move3; }
    public Move getMove4() { return move4; }

    /**
    * Function to calculate the hp of the monster 
    * @param damageDealt   the monster's damage calculated from the HumanPlayer and CPUPlayer classes
    */
    public void calculateHP(int damageDealt){
        this.hp = this.hp - damageDealt;
    }
    
}