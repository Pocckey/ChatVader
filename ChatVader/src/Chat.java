import java.io.*;
import java.util.Scanner;

import twitter4j.TwitterException;

import com.dropbox.core.DbxException;

public class Chat {
	static String name = "Vader";
	static IO myIO = new IO();
	static String input;
	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		myIO.setChatName(name);
		System.out
				.println("Welcome to ChatVader (enter 'Bye'to quit the program)");
		sc = new Scanner(System.in);

		System.out.println("");
		do {
			// Adds some delay to make the chatbot seem more realistic
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("<User>");
			input = sc.nextLine();

			// Edit input to slash any special characters, leading/trailing
			// spaces, etc.
			input = input.trim();
			input = input.toLowerCase();
			try {
				// Adds some delay to make the chatbot seem more realistic
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (input.contains("name")&& input.contains("change")) {
				input= "changename";
				myIO.print("");
				System.out.println(Bot.Bot(input));
				System.out.println();
				System.out.print("<User> ");
				name = sc.nextLine();
				System.out.println(" ");
				myIO.setChatName(name);
				input = "done";
			}

			if (input.contains("translate")) {
				input= "translate";
				myIO.print("");
				System.out.println(Bot.Bot(input));
				System.out.println("");
				System.out.println("<User>: ");
				String line = sc.nextLine();
				System.out.println(" ");
				translateIt(line);
				input = "done";
			}
			if (input.contains("wolfram")) {
				input= "wolfram";
				myIO.print("");
				System.out.println(Bot.Bot(input));
				System.out.println("");
				System.out.println("<User>: ");
				String line = sc.nextLine();
				System.out.println(" ");
				WolframAPI(line);
				input = "done";
			}
			if (input.contains("tweet")||input.contains("twitter")) {
				input= "tweet";
				myIO.print("");
				System.out.println(Bot.Bot(input));
				System.out.println("");
				System.out.println("<User>: ");
				String line = sc.nextLine();
				System.out.println(" ");
				Tweet(line);
				input = "done";
			}
			if (input.contains("facebook")) {
				input= "facebook";
				myIO.print("");
				System.out.println(Bot.Bot(input));
				System.out.println("");
				System.out.println("<User>: ");
				String line = sc.nextLine();
				input= "w";
				myIO.print("");
				System.out.println(Bot.Bot(input));
				System.out.println("");
				System.out.println("<User>: ");
				String name = sc.nextLine();
				System.out.println(" ");
				FB(name, line);
				input = "done";
			}
			if (input.contains("dropbox")) {
				input= "dropbox";
				System.out.println(Bot.Bot(input));
				System.out.println("");
				System.out.println("<User>: ");
				String line = sc.nextLine();
				input= "secretkey";
				myIO.print("");
				System.out.println(Bot.Bot(input));
				System.out.println("");
				System.out.println("<User>: ");
				String line1 = sc.nextLine();
				System.out.println(" ");
				DB(line, line1);
				input = "done";
			}
			try {
				// Adds some delay to make the chatbot seem more realistic
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
			
			System.out.println(" ");
			myIO.print("");
			System.out.println(Bot.Bot(input));
			System.out.println(" ");

		} while (!input.contains("bye"));

	}

	private static Translator translateIt(String input) throws Exception {
		Translator t = new Translator(input);
		return t;
	}

	private static AlphaAPI WolframAPI(String input) {
		AlphaAPI a = new AlphaAPI(input);
		return a;
	}

	private static TwitterAPI Tweet(String input) throws TwitterException {
		TwitterAPI tw = new TwitterAPI(input);
		return tw;
	}
	
	private static FacebookAPI FB(String name, String Token)
	{
		FacebookAPI fb= new FacebookAPI(name, Token);
		return fb;
	}
	private static DropboxAPI DB(String appkey, String appsec) throws IOException, DbxException
	{
		DropboxAPI db= new DropboxAPI(appkey, appsec);
		return db;
	}
}