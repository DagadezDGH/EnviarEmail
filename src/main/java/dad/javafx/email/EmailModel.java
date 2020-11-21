package dad.javafx.email;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailModel {
	private Email email = new SimpleEmail();

	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	

}
