package br.com.springboot.model;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	@Column(length = 14)
	private String cpf;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(nullable=false, name="data_nascimento", columnDefinition="DATE")
	private LocalDate dataDeNascimento;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(length = 14)
	private String telefone;
	
	@Column(length = 15)
	private String celular;
	
	@Column(length = 50)
	private String email;
	
	private boolean ativo;

	public Cliente() {
		this.ativo = true;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getCelular() {
		return celular;
	}
	public String getEmail() {
		return email;
	}
	public boolean isAtivo() {
		return ativo;
	}
	
	@Override
	public String toString() {
		String cliente = "";
		cliente += "CLIENTE\n";
		cliente += "-------------------------\n";
		cliente += "ID.......: " + this.id + "\n";
		cliente += "Nome.....: " + this.nome + "\n";
		cliente += "CPF......: " + this.cpf + "\n";
		cliente += "Data Nasc: " + this.dataDeNascimento + "\n";
		cliente += "Sexo.....: " + (this.sexo == null ? "null" : this.sexo.getDescricao()) + "\n";
		cliente += "Telefone.: " + this.telefone + "\n";
		cliente += "Celular..: " + this.celular + "\n";
		cliente += "Email....: " + this.email + "\n";
		cliente += "Ativo....: " + (this.ativo ? "Sim" : "Não") + "\n";
		return cliente;
	}
}











