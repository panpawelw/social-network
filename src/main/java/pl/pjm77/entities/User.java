package pl.pjm77.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Podaj poprawną nazwę użytkownika!")
	@NotNull(message = "Podaj poprawną nazwę użytkownika!")
	@Column(nullable = false, unique = true)
	private String username;

	@NotBlank(message = "Podaj poprawne hasło!")
	@NotNull(message = "Podaj poprawne hasło!")
	@Column(nullable = false)
	private String password;

	@NotBlank(message = "Podaj poprawny adres e-mail!")
	@NotNull(message = "Podaj poprawny adres e-mail!")
	@Email(message = "Podaj poprawny adres e-mail!")
	@Column(nullable = false, unique = true)
	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Twat> twats = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Comment> comments = new ArrayList<>();

	@OneToMany(mappedBy = "sender")
	private List<Message> sentMessages = new ArrayList<>();

	@OneToMany(mappedBy = "receiver")
	private List<Message> receivedMessages = new ArrayList<>();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void hashPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public List<Twat> getTwats() {
		return twats;
	}

	public void setTwats(List<Twat> twats) {
		this.twats = twats;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<Message> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<Message> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
}