package game;
import java.util.Scanner;

public class GameStart {
    public static void main(String[] args) {
    	Character character = null;
    	Scanner scanner = new Scanner(System.in);
    	String flag = " ";
    	String enterFlag = "";
    	String skillType= " ";
    	String jobType = " ";
    	System.out.println("Enter your Name:");
    	String name = scanner.nextLine();
    	System.out.println("Enter your Stat among those one [Str,Dex,Int,Luk]:");
    	String stats = scanner.nextLine();
    	
        if (stats.equals("Str")) {
            character = new Warrior(name,stats);
            jobType = "warrior";
        }
        else if (stats.equals("Dex")){
        	character = new Archor(name,stats);
        	jobType = "archor";
        }
        else if (stats.equals("Int")) {
        	character = new Magician(name,stats);
        	jobType = "magician";
        }
        else if (stats.equals("Luk")) {
        	character = new Thief(name,stats);
        	jobType = "thief";
        }
        
        World world = new World(name,stats,jobType);
        System.out.println("Enter y/n to go shop:");
        enterFlag = scanner.nextLine();
        
        if (enterFlag.equals("y")) {
        	world.showShop();
        }
        else {
        	System.out.println("Nothing");
        }
        
        System.out.println("Enter y/n to show your region:");
        enterFlag = scanner.nextLine();
        
        if (enterFlag.equals("y")) {
        	world.regionShow();
        }
        else {
        	System.out.println("Nothing");
        }
        
        while (!flag.equals("quit")) {
        	if(character!=null) {
        		System.out.println("Enter the skill you want [q,w,e,r] or shop , region, fight");
        		skillType = scanner.nextLine();
        		if (skillType.equals("shop")) {
        			world.showShop();
        		}
        		else if (skillType.equals("region")) {
        			world.regionShow();
        		}
        		else if (skillType.equals("q") || skillType.equals("w") || skillType.equals("e") || skillType.equals("r")) {
        		character.useSkill(skillType);
        		System.out.println("Enter quit to quit");
        		flag = scanner.nextLine();
        		}
        		else if (skillType.equals("fight")) {
        			if (world.region.equals("henesis")){
        				Monster monster = new Slime();
        				while (monster.hp != 0) {
        					System.out.println("You chose to fight with monster press your skill!!");
        					skillType = scanner.nextLine();
        					character.useSkill(skillType);
        					if (skillType.equals("q")) {
        						monster.monsterDie();
        						world.money += 500;
        						break;
        					}
        					else if (skillType.equals("w")) {
        						monster.monsterAttack();
        						world.money -= 200;
        						break;
        					}
        					else if (skillType.equals("e")) {
        						monster.monsterAttack2();
        						flag = "quit";
        					}
        					else {
        						System.out.println("nothing happened");
        						break;
        					}
        				}
        			}
        			else {
        				System.out.println("You should move to other region");
        			}
        			
        		}
        	}       
        	else {
        		System.out.println("Rename your Job!");
        	}
    }
        
       
    }
}