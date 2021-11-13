package dad.javafx.email;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class Controller implements Initializable {
	
//	EmailModel model = new EmailModel();
	
	private Email email = new SimpleEmail();
	private StringProperty server = new SimpleStringProperty();
	private StringProperty puerto = new SimpleStringProperty();
	private StringProperty remitente = new SimpleStringProperty();
	private StringProperty asunto = new SimpleStringProperty();
	private StringProperty destinatario = new SimpleStringProperty();
	private StringProperty mensaje = new SimpleStringProperty();
	private StringProperty password = new SimpleStringProperty();
	private BooleanProperty ssl = new SimpleBooleanProperty();
	
	@FXML
	private GridPane view;
	
	@FXML
	private TextField servidorText;
	
	@FXML
	private TextField puertoText;
	
	@FXML
	private TextField remitenteText;
	
	@FXML
	private PasswordField remitentePassword;
	
	@FXML
	private CheckBox sslCheckBox;
	
	@FXML
	private TextArea mensajeText;
	
	@FXML
	private TextField destinatarioText;
	
	@FXML
	private TextField asuntoText;
	
	@FXML
	private Button enviarButton;
	
	@FXML
	private Button vaciarButton;
	
	@FXML
	private Button cerrarButton;
	
	@FXML
	void onEnviarButtonAction (ActionEvent e) {
		try {
//		model.getEmail().setHostName(servidorText.getText());
//		model.getEmail().setSmtpPort(Integer.parseInt(puertoText.getText()));
//		model.getEmail().setAuthentication(remitenteText.getText(), remitentePassword.getText());
//		model.getEmail().setSSLOnConnect(sslCheckBox.isSelected());
//		model.getEmail().setFrom(remitenteText.getText());
//		model.getEmail().setSubject(asuntoText.getText());
//		model.getEmail().setMsg(mensajeText.getText());
//		model.getEmail().addTo(destinatarioText.getText());
//		
//		model.getEmail().send();
		email.setHostName(server.getValue());
		email.setSmtpPort(Integer.parseInt(puerto.getValue()));
		email.setAuthentication(remitente.getValue(), password.getValue());
		email.setSSLOnConnect(ssl.getValue());
		email.setFrom(remitente.getValue());
		email.setSubject(asunto.getValue());
		email.setMsg(mensaje.getValue());
		email.addTo(destinatario.getValue());
		
		App.info(
				"Mensaje enviado",
				"Mensaje enviado con éxito a '" + destinatario.getValue() + "'.", 
				""
			);
			
		}catch(Exception ex) {
			App.error(
					"No se puedo enviar el email.", 
					ex.toString()
				);}
	}
	
	@FXML
	void onVaciarButtonAction (ActionEvent e) {
		servidorText.clear();
		puertoText.clear();
		remitenteText.clear();
		remitentePassword.clear();
		sslCheckBox.setSelected(false);
		mensajeText.clear();
		destinatarioText.clear();
		asuntoText.clear();
		
	}
	
	@FXML
	void onCerrarButtonAction (ActionEvent e) {
		Platform.exit();
	}
	
	
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		servidorText.textProperty().bindBidirectional(server);
		puertoText.textProperty().bindBidirectional(puerto);
		remitenteText.textProperty().bindBidirectional(remitente);
		asuntoText.textProperty().bindBidirectional(asunto);
		destinatarioText.textProperty().bindBidirectional(destinatario);
		mensajeText.textProperty().bindBidirectional(mensaje);
		remitentePassword.textProperty().bindBidirectional(password);
		sslCheckBox.selectedProperty().bindBidirectional(ssl);
	}
		
	public GridPane getView() {
		return view;
	}

}

