import java.io.*;




public class Chat {
    
	public static void main(String[]args)throws IOException{
        
		System.out.println("Welcome to ChatVader (enter 'Bye'to quit the program)");
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
        
		do{
			//Adds some delay to make the chatbot seem more realistic
			try {
				Thread.sleep(750);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
			System.out.print("<User>");
			input = br.readLine();
			
			//Edit input to slash any special characters, leading/trailing spaces, etc.
			input=input.trim();
			input=input.toLowerCase();
            
			//Adds some delay to make the chatbot seem more realistic
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
			System.out.println("<Vader>"+Bot.Bot(input));
		}while (!input.contains("bye"));
        
	}
}
