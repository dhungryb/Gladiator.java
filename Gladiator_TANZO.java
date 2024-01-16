package gladiator_tanzo;
import java.util.Scanner;
//import statement
public class Gladiator_TANZO {

   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         
        while (true){
            
            try {
                System.out.print("Enter Gladiator 1 Name: ");
                String name1 = in.nextLine();
                
                System.out.print("Enter " + name1 + " health points: ");
                double health = in.nextDouble();
                
                System.out.print("Enter " + name1 + " damage points: ");
                int damage = in.nextInt();
                
                System.out.print("Enter " + name1 + " defense points: ");
                int defense = in.nextInt();
                
                System.out.print("Enter " + name1 + " initiative points: ");
                int initiative = in.nextInt();
                
                String enemyName = "Computer";
                double enemyHealth = 100.0;
                int randDamage = (int) (Math.random() * (50 - 25 + 1) + 25);
                int randDefense = (int) (Math.random() * (30 - 15 + 1) + 15);
                int randInit = (int) (Math.random() * (100 - 10 + 1) + 10);
                
             
        Gladiator glad1 = 
                new Gladiator(name1,health, damage, defense, initiative);
        Gladiator glad2 =
                new Gladiator(enemyName,enemyHealth, randDamage, randDefense, randInit);
        
       System.out.println(
               Gladiator.fight(glad1, glad2).getName()
               + " wins.");
                
       
             break;
            }catch(Exception e){
                System.out.println("Invalid Input!");
                in.nextLine();
            }
        }
        
        
        
    }
    
}
