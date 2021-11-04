package com.frey.quitter.model;

import java.util.Objects;

public class NotificationEmail {
    private String subject;
    private String recipient;
    private String body;
	
    public NotificationEmail() {
    	
    }
    
    public NotificationEmail(String subject, String recipient, String body) {
		super();
		this.subject = subject;
		this.recipient = recipient;
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, recipient, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotificationEmail other = (NotificationEmail) obj;
		return Objects.equals(body, other.body) && Objects.equals(recipient, other.recipient)
				&& Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		return "NotificationEmail [subject=" + subject + ", recipient=" + recipient + ", body=" + body + "]";
	}
    
    
}
