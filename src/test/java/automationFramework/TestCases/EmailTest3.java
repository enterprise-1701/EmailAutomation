package automationFramework.TestCases;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EmailTest3{
	
	 String host = "bb-corp-cas01.corp.cubic.cub";// change accordingly
     String username = "cts.systemtest";// change accordingly
     String password = "Cubic_2016";// change accordingly
     String folder = "Inbox/Cmc";
	
	
	@Test
	public void checkEmail() throws Exception{
		
		Properties props = System.getProperties();               
	      props.put("mail.imaps.auth.plain.disable","true"); 
	      
	           try {
	                Session session = Session.getDefaultInstance(props, null);
	                Store store = session.getStore("imaps");
	                store.connect(host, 993, username, password);
	                Folder inbox = store.getFolder(folder);
	                inbox.open(Folder.READ_ONLY);
	                Message messages[] = inbox.getMessages();               
	                int newEmail = inbox.getUnreadMessageCount();
	                System.out.println("Number of new emails: " + newEmail);
	                Assert.assertTrue((newEmail>0), ("New Welcome Email Not Received!"));
	                int indexNewMessage = (inbox.getMessageCount()-1);
	                String newEmailSubject = inbox.getMessage(indexNewMessage).getSubject();
	                System.out.println("Subject of new email is: " + newEmailSubject);
                    Assert.assertEquals(newEmailSubject, "Welcome New Customer");
	
	             
	           }  catch (Exception e) {
	           e.printStackTrace();
	           System.exit(2);
	   }
			

	}
}
	
