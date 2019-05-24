package br.com.moldsystems.projetoFray.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "pessoa")
public class PessoaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = " Nome é uma informação obrigatória.")
	private String nome;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = " E-mail é uma informação obrigatória.")
	private String email;
	

	@Column(name="cpf", length=14, nullable=false)
	@Length(max=14, message=" O cpf não pode ser maior que {max} caracteres")
//	@CPF(message= " O cpf deve ser válido.")
	@NotBlank(message= " O cpf é obrigatório.")
	private String cpf;
	

	@Column(name="data_nascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message=" A data de nascimento é obrigatória.")
	private Date dataNascimento;
	

//	public PessoaModel() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public PessoaModel(Long id, String nome, String email, String cpf, Date dataNascimento) {
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.email = email;
//		this.cpf = cpf;
//		this.dataNascimento = dataNascimento;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
