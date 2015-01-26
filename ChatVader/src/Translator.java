import com.memetix.mst.language.*;
import com.memetix.mst.translate.*;

public class Translator {

	public Translator(String input) throws Exception {
		Translate.setClientId("DarthV");
		Translate
				.setClientSecret("TltUAq53APzq+XGzmT8J+mXhVkBjGhDr4Wjt/rrzfy8=");
		String trans = Translate.execute(input, Language.ENGLISH,
				Language.DUTCH);

		String output = "original text: " + input + "\n" + "Translated text(Dutch): "
				+ trans + "\n";
		System.out.println(output);
	}

}
