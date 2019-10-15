package br.com.codenation.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "log")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat
	private Long id;

	@Column
	@Size(max = 7)
	@NotNull
	@JsonFormat
	private String level; //debug warning error 

	@Column
	@Size(max = 100)
	@NotNull
	@JsonFormat
	private String title;

	@Column
	@Size(max = 150)
	@NotNull
	@JsonFormat
	private String description;

	@Column
	@Size(max = 255)
	@NotNull
	@JsonFormat
	private String details;

	@Column
	@Size(max = 11)
	@NotNull
	@JsonFormat
	private String environment; //produção homologação dev

	@Column
	@NotNull
	@Size(max = 255)
	@JsonFormat
	private String source; //origem

	@Column
	@NotNull
	@JsonFormat
	private Long frequence;
	
	@Column
	@JsonFormat
	private boolean archived;

	@Column
	@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime createdAt;

	@ManyToOne
	@JsonFormat
	private User user;

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public boolean isArchived(boolean b) {
		return archived;
	}
}
