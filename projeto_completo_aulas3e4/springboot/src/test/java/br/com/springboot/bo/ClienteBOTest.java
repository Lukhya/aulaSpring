package br.com.springboot.bo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.springboot.model.Cliente;
import br.com.springboot.model.Sexo;

//as anotacoes @ foram colocadas no tema 3 - realizando testes
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
final public class ClienteBOTest {

	@Autowired
	private ClienteBO bo;
	@Test
	@Order(1)
	
	public void insere() {
		Cliente cliente = new Cliente();
		cliente.setNome("José Silva");	
		
		cliente.setCpf("0123456789");
		cliente.setDataDeNascimento(LocalDate.of(2000,1,8));
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setTelefone("0123456789");
		cliente.setTelefone("01234567890");
		cliente.setAtivo(true);
		bo.insere(cliente);
		}
	
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		System.out.println(cliente);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		cliente.setCpf("98765432100");
		bo.atualiza(cliente);
	}
	
//na aula prof implementa até aqui	
/*	
	public void lista() {
		List<Cliente> clientes = bo.listaTodos();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	
	public void inativa() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.inativa(cliente);
	}
	
	public void remove() {
		Cliente cliente = bo.pesquisaPeloId(1L);
		bo.remove(cliente);
	}*/
}
