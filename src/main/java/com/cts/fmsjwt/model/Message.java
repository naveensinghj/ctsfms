package com.cts.fmsjwt.model;
/**
 * @author 849289
 * */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author ard333
 */
public class Message {
	
	public Message(String content) {
		super();
		this.content = content;
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
