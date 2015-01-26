import com.dropbox.core.*;

import java.io.*;
import java.util.Locale;

public class DropboxAPI {
	
	public DropboxAPI(String appkey, String appsec) throws IOException, DbxException{

		String name= Chat.name;
		IO myIO = new IO();
		myIO.setChatName(name);
		
		
		DbxAppInfo appInfo = new DbxAppInfo(appkey, appsec);
		DbxRequestConfig config = new DbxRequestConfig("Dropbox API", Locale
				.getDefault().toString());
		DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);

		// Web Authorization
		String authUrl = webAuth.start();
		myIO.print(" ");
		System.out.println("1. Go to: " + authUrl);
		System.out
				.println("2. Click \"Allow\" (you might have to log in first)");
		System.out.println("3. Copy the authorization code.");
		System.out.println("\n"+"<User>: ");
		String code = new BufferedReader(new InputStreamReader(System.in))
				.readLine().trim();

		// This will fail if the user enters an invalid authorization code.
		DbxAuthFinish authFinish = webAuth.finish(code);
		String accessToken = authFinish.accessToken;

		DbxClient client = new DbxClient(config, accessToken);
myIO.print(" ");
		System.out.println("Linked account: "
				+ client.getAccountInfo().displayName);
		
		
		//Look at files in the root path of the Account
        DbxEntry.WithChildren list = client.getMetadataWithChildren("/");
        System.out.println("Files in the root path:");
        for (DbxEntry child : list.children) {
            System.out.println("	" + child.name + ": " + child.toString());
        
        //
        }
	}
}