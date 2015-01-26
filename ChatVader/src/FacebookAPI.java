
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;

public class FacebookAPI {

	public FacebookAPI(String name, String token) {

		// TODO code application logic here

		FacebookClient facebook = new DefaultFacebookClient(token);
		Page user = facebook.fetchObject(name, Page.class);
		System.out.println(name+"'s User Name "+user.getName());
		System.out.println(name+" has "+user.getLikes() + "likes.");
		System.out.println(name+" works in "+user.getCompanyOverview());
		System.out.println(name+" "+user.getAbout());
		System.out.println(name+" is founded at "+user.getFounded());
		System.out.println(name+" is "+user.getDescription());

	}
	}
