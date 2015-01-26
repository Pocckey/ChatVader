import java.util.*;



public class Bot {
	
	
    static String Bot(String input){
        
        // checks for which method to call first
        
		if(input.startsWith("hey")||
           input.startsWith("hi")||
           input.startsWith("sup")||
           input.startsWith("yo ")||
           input.matches("yo")||
           input.matches("yo,")||
           input.contains("hello")||
           input.contains("greetings")||
           input.contains("good morning")||
           input.contains("good evening")||
           input.contains("good day"))
			return Hi(input);
		else if(input.contains("where"))
			return	Where(input);
		else if(input.contains("how"))
			return How(input);
		else if(input.contains("what"))
			return What(input);
		else if(input.contains("why"))
			return Why(input);
		else if(input.contains("when"))
			return When(input);
		else if(input.contains("?"))
			return Question(input);
		else if(input.contains("bye"))
			return Bye();
		else return generic(input);
		
		
	}
	
	
	private static String Hi(String input){
        //randoms between 2 type of greetings, if the person a person ask a question
        // it calls the adequate method else returns a generic answer
		Random generator = new Random();
		int i=generator.nextInt(2)+1;
		String part1="";
		String part2="";
		switch (i) {
            case 1:  part1 = "Hello, ";
                break;
            case 2:  part1 = "Greetings, ";
            break;}
        
        if(input.contains("where"))
            part2=Where(input);
        else if(input.contains("how"))
            part2=How(input);
        else if(input.contains("what"))
            part2=What(input);
        else if(input.contains("why"))
            part2=Why(input);
        else if(input.contains("when"))
            part2=When(input);
        else if(input.contains("?"))
            part2=Question(input);
        else  part2="what brings you here?";
        String a= part1+part2;
        return a;
		
	}
	private static String Where(String input){
		
		String a="";
		if(input.contains("you")&&input.contains("live"))
            a="Coruscant, it's the first planet on the right after Xpiter.";
		else if(input.contains("you")&&input.contains("from"))
			a="Tataouine, it's beautiful during the winter.";
		else if(input.contains("dark"))
			a="The dark side is in all of us.";
		else a="The emplacement cannot be revealed to the weak links like yourself.";
		
		return a;
		
		
	}
	private static String How(String input){
		String a="";
		if(input.contains("you")&&(input.contains("washroom")||input.contains("pee")||input.contains("bathroom")))
            a="Man diapers... this stays between us right?";
		else if(input.contains("you")&&input.contains("eat"))
			a="Power is the only resource I need.";
		else if(input.contains("power"))
			a="You need to channel your anger to reach greater power.";
		else {
			Random generator = new Random();
			int i=generator.nextInt(3)+1;
			
			switch (i) {
                case 1:  a = "If you need to ask, you do not deserve the answer.";
                    break;
                case 2:  a = "By using the force.";
                    break;
                case 3:  a = "The question is not how, but why?";
                    break;
                    
            } }
		return a;
		
	}
	private static String What(String input){
		String a="";
		if(input.contains("you")&&((input.contains("living"))||input.contains("want")))
            a="Rule the world";
		else if(input.contains("depends"))
			a="Are you ready to join the darkside?";
		else {
            Random generator = new Random();
            int i=generator.nextInt(10)+1;
            
            switch (i) {
		        case 1:  a = "I'll get back to you on that.";
                    break;
		        case 2:  a = "Do you really think I have time to answer this questions?";
                    break;
		        case 3:  a = "Ask me one more question and I will strangle you... WITH MY MIND";
                    break;
		        case 4:  a = "Nice try...";
                    break;
		        case 5:  a = "403 NOT FOUND.... I MEAN 404.";
                    break;
		        case 6:  a = "I would rather not talk about that...";
                    break;
		        case 7:  a = "Would you be happy if I said yes?";
                    break;
		        case 8:  a = "Leave me alone!";
                    break;
		        case 9:  a = "Do you honestly think that you will get an answer from me?";
                    break;
		        case 10: a = "Never.";
                    break;
		    }}
		return a;
		
	}
	private static String Why(String input){
		String a="";
		if(input.contains("cape"))
            a="It looks cool.";
		else if(input.contains("dark")||input.contains("evil"))
			a="I need to get my revenge.";
		else if(input.contains("mask"))
			a="Trust me, you do not want to see the real me.";
		else {
			Random generator = new Random();
			int i=generator.nextInt(3)+1;
			
			switch (i) {
                case 1:  a = "You do not question a Sith lord!";
                    break;
                case 2:  a = "why not?";
                    break;
                case 3:  a = "The question is not why, but how?";
                    break;
                    
            } }
		return a;
		
	}
	private static String When(String input){
		String a="";
		if(input.contains("born"))
            a="The day I put on this mask.";
		else if(input.contains("die"))
			a="Never.";
		else a="Time is relative.";
		return a;
		
	}
	private static String Question(String input){
		String a="";
		if(input.contains("who"))
            a="This information cannot be revealed to the weaklinks like yourself..";
		else if(input.contains("depends"))
			a="Are you ready to join the darkside?";
		else if(input.contains("joke"))
			a="Alright...Let me catch me catch my breath first.";
		else if(input.contains("other"))
			a="I'm not good at it... can you give me a hand?";
		else if(input.contains("regret"))
			a="Do you regret being born?";
		else {
            Random generator = new Random();
            int i=generator.nextInt(10)+1;
            
            switch (i) {
                case 1:  a = "Why do you ask?";
                    break;
                case 2:  a = "Do you really think I have time to answer this questions?";
                    break;
                case 3:  a = "Ask me one more question and I will strangle you... WITH MY MIND";
                    break;
                case 4:  a = "Nice try...";
                    break;
                case 5:  a = "403 NOT FOUND.... I MEAN 404.";
                    break;
                case 6:  a = "I would rather not talk about that...";
                    break;
                case 7:  a = "Would you be happy if I said yes?";
                    break;
                case 8:  a = "Leave me alone!";
                    break;
                case 9:  a = "Yes.";
                    break;
                case 10: a = "Never.";
                    break;
            }}
        return a;}
    
	
	private static String generic(String input){
		
		String a="";
		if(input.contains("yes"))
            a="Good.";
		else if(input.contains("no"))
			a="You will regret this.";
		else if(input.contains("haha"))
			a="Do you think that's funny??";
		else if((input.contains("i'm")|input.contains("i am")|input.contains("my name"))&input.contains("luke"))
			a="I am your father.";
		else if(input.contains("you")&input.contains("heard"))
            a="It depends...";
		else {
            
            Random generator = new Random();
            int i=generator.nextInt(10)+1;
            
            switch (i) {
                case 1:  a = "I only care about the Dark Side.";
                    break;
                case 2:  a = "Obi Wan never told you what happened to your father.";
                    break;
                case 3:  a = "The emperor is not as forgiving as I am.";
                    break;
                case 4:  a = "I am your father.";
                    break;
                case 5:  a = "You may dispense with the pleasantries, commander. I am here to put you back on schedule.";
                    break;
                case 6:  a = "I do not understand what you are talking about.";
                    break;
                case 7:  a = "Impressive. Most impressive. Obi-Wan has taught you well. You have controlled your fear. Now, release your anger. Only your hatred can destroy me.";
                    break;
                case 8:  a = "Brb, need to clean my suit.";
                    break;
                case 9:  a = "Do you want to hear a joke?";
                    break;
                case 10: a = "Can you give me a hand?";
                    break;
            }}
        return a;}
	
	private static String Bye(){
		String a="Good day sir.";
		
		return a;
		
	}
	
    
	
}
