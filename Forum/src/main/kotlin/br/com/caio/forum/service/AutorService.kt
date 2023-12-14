package br.com.caio.forum.service

import br.com.caio.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class AutorService(var autor: List<Usuario>) {

    init {
        val autor = Usuario(
            1,
            "Caio Lucas",
            "caio@gmail.com"
        )
        listOf(autor)
    }

    fun buscarPorId(id: Long): Usuario {
        return autor.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}
