/**
 *
 */
package com.java.messageconverter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author VirajSolaskar
 *
 */
@Entity
@Table(name="T_Message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sourceMessage;
	private String destinationMessage;
	private String status;
	private String statusDescription; 
	private Date CreatedDate;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the sourceMessage
	 */
	public String getSourceMessage() {
		return sourceMessage;
	}
	/**
	 * @param sourceMessage the sourceMessage to set
	 */
	public void setSourceMessage(String sourceMessage) {
		this.sourceMessage = sourceMessage;
	}
	/**
	 * @return the destinationMessage
	 */
	public String getDestinationMessage() {
		return destinationMessage;
	}
	/**
	 * @param destinationMessage the destinationMessage to set
	 */
	public void setDestinationMessage(String destinationMessage) {
		this.destinationMessage = destinationMessage;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the statusDescription
	 */
	public String getStatusDescription() {
		return statusDescription;
	}
	/**
	 * @param statusDescription the statusDescription to set
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return CreatedDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
}
