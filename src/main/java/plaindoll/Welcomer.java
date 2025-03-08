package plaindoll;

import java.util.Random;

public class Welcomer{
	private Random random;

	public Welcomer() {
        random = new Random();
    }
	public String sayWelcome() {
		return "Welcome home, good hunter. What is it your desire?";
	}
	public String sayFarewell() {
		return "Farewell, good hunter. May you find your worth in waking world.";
	}
	public String sayNeedGold(){
		return "Not enough gold";
	}
	public String saySome(){
		return "something in the way";
	}

	public String sayHunterReplica() {
	String[] replicas = {
		"Welcome home, good hunter. What is it your desire?",
		"Farewell, good hunter. May you find your worth in waking world.",
	};

	int index = random.nextInt(replicas.length);
	return replicas[index];
	}
}
