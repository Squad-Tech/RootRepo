/**
 *
 */
package com.java.messageconverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.messageconverter.entity.Message;

/**
 * @author hackathon
 *
 */
public interface MessageRpository extends JpaRepository<Message, Long> {

}
