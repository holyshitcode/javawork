package game;

public class Warrior extends Character {
	String specialty;
	String weapons;
	
	public Warrior(String name, String stats) {
        super(name, stats);
        this.specialty = "warrior";
        this.weapons = "sword";
        this.getWeapons();
        //this.bagExtend();
        //jjj
	}
	
	public void getWeapons() {
		System.out.println("I have "+this.weapons +" in my hand");
	}
	
	public void q() {
		System.out.println("Get my great sword!");
	}
	public void w() {
		System.out.println("Don't stare at me!");
	}
	public void e() {
		System.out.println("Spiraling sword!!");
	}
	public void r() {
		System.out.println("Rain of Swords!");
	}
	
	
}
