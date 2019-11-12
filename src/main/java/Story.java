/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noees
 */

//class that does nothing but storing methods to print out every part of the story
public class Story {
	
	public static void printIntro(){
                GameLogic.separatorPrint('#',30);
		System.out.println("STORY");
                GameLogic.separatorPrint('#',30);		
                System.out.println("You are the last man standing after your village got raided by the henchmen of the evil emperor.");
		System.out.println("Every single one of your friends, family and neighbours got murdered. You are standing in burning ruins of this once beautiful village.");
		System.out.println("All you want now is revenge, so you begin planning your journey to defeat the evil emperor and free the lands!");
		GameLogic.continueCommand();
	}
	
	public static void printFirstActIntro(){
		GameLogic.separatorPrint('#',30);
		System.out.println("ACT I - INTRO");
		GameLogic.separatorPrint('#',30);
		System.out.println("As you begin your journey you start travelling trough the nearby woods to reach the everlasting mountains.");
		System.out.println("The everlasting mountains are a very dangerous place. It says nobody came back alive from there.");
		System.out.println("\nAfter a long day of walking through the woods, you finally reach the everlasting mountains.");
		System.out.println("You don't care about the things you've heard about this dangerous place and start your journey to defeat the evil emperor.");
		GameLogic.continueCommand();
	}
	
	public static void printFirstActOutro(){
		GameLogic.separatorPrint('#',30);
		System.out.println("ACT I - OUTRO");
		GameLogic.separatorPrint('#',30);
		System.out.println("You did it! You crossed the everlasting mountains and you're still alive!");
		System.out.println("As you climb down the last hill, you're more than happy to feel hard ground underneath your feet again.");
		System.out.println("\nYou feel empowered and the experience you gained allows you to learn another trait!");
		GameLogic.continueCommand();
	}
	
	public static void printSecondActIntro(){
		GameLogic.separatorPrint('#',30);
		System.out.println("ACT II - INTRO");
		GameLogic.separatorPrint('#',30);
		System.out.println("You begin travelling across the landlines of this once well populated countryside.");
		System.out.println("You collected some gold from the monsters you killed along the way.");
		System.out.println("Luckily you know that every once in a while a travelling trader comes across these landlines.");
		System.out.println("You know exactly where the castle of the evil emperor is, but you have to cross these haunted landlines first...");
		GameLogic.continueCommand();
	}
	
	public static void printSecondActOutro(){
		GameLogic.separatorPrint('#',30);
		System.out.println("ACT II - OUTRO");
		GameLogic.separatorPrint('#',30);
		System.out.println("You managed to cross these haunted landlines and you're still alive!");
		System.out.println("You are just a few hours away from your final destination; the castle of the Evil Emperor!");
		System.out.println("You know that you probably can't rest there, so you make a last break to restore some health.");
		System.out.println("\nAfter all you've seen you feel empowered to learn another trait.");
		GameLogic.continueCommand();
	}
	
	public static void printThirdActIntro(){
		GameLogic.separatorPrint('#',30);
		System.out.println("ACT III - INTRO");
		GameLogic.separatorPrint('#',30);
		System.out.println("You see the huge black castle in front of you.");
		System.out.println("As you stand in front of the gates, you know there's no going back.");
		System.out.println("You're disguised as a mercenary and enter the castle. You don't know how much time you have left before someone discovers you!");
		System.out.println("All you can do know is fight for your life and pray to come out as the winner...");
		GameLogic.continueCommand();
	}
	
	
	public static void printThirdActOutro(){
		GameLogic.separatorPrint('#',30);
		System.out.println("ACT III - OUTRO");
		GameLogic.separatorPrint('#',30);
		System.out.println("You came so far. You defeated all of the Evil Emperor's minions.");
		System.out.println("As you stand in front of the door to his throne room, you know there's no going back.");
		System.out.println("You recall your lost power and restore your health.");
		System.out.println("You get the chance to learn a last trait before entering the throne room.");
		GameLogic.continueCommand();
	}
	
	public static void printFourthActIntro(){
		GameLogic.separatorPrint('#',30);
		System.out.println("ACT IV - INTRO");
		GameLogic.separatorPrint('#',30);
		System.out.println("You enter the throne room of the Evil Emperor.");
		System.out.println("You stares you dead in the eyes. You feel the darkness around you.");
		System.out.println("He takes out the holy sword of darkness, the mightiest weapon known to man.");
		System.out.println("All you can do know is fight for your life and pray to come out as the winner...");
		GameLogic.continueCommand();
	}
	
	public static void printEnd(Player player){
		GameLogic.separatorPrint('#',30);
		System.out.println("Congratulations, " + player.getName() + "! You defeated the Evil Emperor and saved the world!");
		GameLogic.separatorPrint('#',30);
		System.out.println("This game was developed by Fred Diekmann for codestudent.net");
		System.out.println("I hope you enjoyed it!");
	}
}
