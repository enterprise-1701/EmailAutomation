package automationFramework.TestCases;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;


public class EmailTest2{
	

   public static void checkMicrosoftExchangeInbox(String host, String username, String password, String folder) {
      Properties props = System.getProperties();               
      props.put("mail.imaps.auth.plain.disable","true"); 
           try {
                Session session = Session.getDefaultInstance(props, null);
                //session.setDebug(true);
                Store store = session.getStore("imaps");
                store.connect(host, 993, username, password);
                Folder inbox = store.getFolder(folder);
                inbox.open(Folder.READ_ONLY);
                Message messages[] = inbox.getMessages();
                
                int newEmail = inbox.getUnreadMessageCount();
                System.out.println("Number of new emails:" + newEmail);
             
              
                int emailCount = 0;
                for(Message message:messages) {
                		emailCount++;
                        System.out.println("---------------------------------");
                        System.out.println("Email Number " + emailCount);
                        System.out.println("Subject: " + message.getSubject());
                        System.out.println("From: " + message.getFrom()[0]);
                        //System.out.println("Text: " + message.getContent().toString());

                     }
               

           }  catch (Exception e) {
           e.printStackTrace();
           System.exit(2);
      }
   }

	public static void main(String[] args) {

		String host = "bb-corp-cas01.corp.cubic.cub";// change accordingly
	      String username = "cts.systemtest";// change accordingly
	      String password = "Cubic_2016";// change accordingly
	      String folder = "Inbox/Cmc";
	      
	      checkMicrosoftExchangeInbox(host, username, password, folder);
	      

		
	}

}