package pl.pjm77.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotBlank
		@NotNull
		@Column(nullable=false, unique = true)
		private String username;
		
		@NotBlank
		@NotNull
		@Column(nullable=false)
		private String password;
		
		@NotNull
		@Column(nullable=false)
		private boolean enabled;
		
		@NotBlank
		@NotNull
		@Column(nullable=false, unique = true)
		@Email
		private String email;
		
		public String getUserName() {
			return username;
		}
		public void setUserName(String userName) {
			this.username = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = BCrypt.hashpw(password, BCrypt.gensalt());
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
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
}