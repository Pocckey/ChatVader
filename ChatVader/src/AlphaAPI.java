import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;
import com.wolfram.alpha.net.HttpProviderFactory;

public class AlphaAPI {

	// PUT YOUR APPID HERE:
	private static String appid = "6LYGA3-A38P5VHTH8";

	@SuppressWarnings("static-access")
	public AlphaAPI(String input) {

		HttpProviderFactory h = new HttpProviderFactory();

		WAEngine engine = new WAEngine();
		h.getDefaultHttpProvider();
		engine.setAppID(appid);
		engine.addFormat("plaintext");

		// Create the query.
		WAQuery query = engine.createQuery();

		// Set properties of the query.
		query.setInput(input);

		try {
			WAQueryResult result = engine.performQuery(query);

			if (result.isError()) {
				System.out.println("Query error");
				System.out.println("  error code: " + result.getErrorCode());
				System.out.println("  error message: "
						+ result.getErrorMessage());
			} else if (!result.isSuccess()) {
				System.out
						.println("Query was not understood; no results available.");
			} else {

				for (WAPod pod : result.getPods()) {
					if (!pod.isError()) {
						System.out.println(pod.getTitle());
						System.out.println("------------");
						for (WASubpod subpod : pod.getSubpods()) {
							for (Object element : subpod.getContents()) {
								if (element instanceof WAPlainText) {
									System.out.println(((WAPlainText) element)
											.getText());
									System.out.println("");
								}
							}
						}
						System.out.println("");
					}
				}
			}
		} catch (WAException e) {
			e.printStackTrace();
		}
	}

}
