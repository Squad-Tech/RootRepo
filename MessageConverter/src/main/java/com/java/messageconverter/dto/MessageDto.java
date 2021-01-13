/**
 *
 */
package com.java.messageconverter.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Size;

/**
 * @author Shalini
 *
 */
public class MessageDto {

		@Size(min = 1,max = 5)
	    private Long accountNumber;
		@Size(min = 1,max = 5)
	    private BigDecimal transferAmount;
		@Size(min = 1,max = 5)
	    private String bankName;
		@Size(min = 1,max = 5)
	    private BigDecimal beneficiaryAccountNumber;
		@Size(min = 1,max = 5)
	    private String beneficiaryIfscCode;
	    private Date date;
	    @Size(min = 1,max = 5)
	    private String formatType;

	 

	    public Long getAccountNumber() {
	        return accountNumber;
	    }
	    public void setAccountNumber(Long accountNumber) {
	        this.accountNumber = accountNumber;
	    }
	    public BigDecimal getTransferAmount() {
	        return transferAmount;
	    }
	    public void setTransferAmount(BigDecimal transferAmount) {
	        this.transferAmount = transferAmount;
	    }
	    public String getBankName() {
	        return bankName;
	    }
	    public void setBankName(String bankName) {
	        this.bankName = bankName;
	    }

	    public BigDecimal getBeneficiaryAccountNumber() {
	        return beneficiaryAccountNumber;
	    }	 

	    public void setBeneficiaryAccountNumber(BigDecimal beneficiaryAccountNumber) {
	        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	    } 
	    /**
		 * @return the beneficiaryIfscCode
		 */
		public String getBeneficiaryIfscCode() {
			return beneficiaryIfscCode;
		}
		/**
		 * @param beneficiaryIfscCode the beneficiaryIfscCode to set
		 */
		public void setBeneficiaryIfscCode(String beneficiaryIfscCode) {
			this.beneficiaryIfscCode = beneficiaryIfscCode;
		}
	   
	    public Date getDate() {
	        return date;
	    }
	    public void setDate(Date date) {
	        this.date = date;
	    }
	    public String getFormatType() {
	        return formatType;
	    }
	    public void setFormatType(String formatType) {
	        this.formatType = formatType;
	    }
		@Override
		public String toString() {
			return "MessageDto [accountNumber=" + accountNumber + ", transferAmount=" + transferAmount + ", bankName="
					+ bankName + ", beneficiaryAccountNumber=" + beneficiaryAccountNumber + ", BeneficiaryIfscCode="
					+ beneficiaryIfscCode + ", date=" + date + ", formatType=" + formatType + "]";
		}
	    
}
