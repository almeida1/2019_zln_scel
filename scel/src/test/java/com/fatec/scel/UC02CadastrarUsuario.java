package com.fatec.scel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.fatec.scel.model.PapelDoUsuario;
import com.fatec.scel.model.Usuario;
import com.fatec.scel.model.UsuarioRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UC02CadastrarUsuario {
	@Autowired
	private UsuarioRepository repository;

	@Test
	public void testStoreUser() {
		HashSet<PapelDoUsuario> papel = new HashSet<>();
		papel.add(PapelDoUsuario.PROFESSOR);
		Usuario user = repository.save(new Usuario(UUID.randomUUID(), "prof.edsonalmeida@fatec.sp.br", "pwd", papel));
		papel.add(PapelDoUsuario.ALUNO);
		Usuario user2 = repository.save(new Usuario(UUID.randomUUID(), "jose@gmail.com", "pwd", papel));
		assertThat(user).isNotNull();
		assertThat(repository.count()).isEqualTo(1L);
	}
}