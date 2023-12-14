package br.com.caio.forum.service

import br.com.caio.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(var cursos: List<Curso>) {

    init {
        val curso = Curso(
            1,
            "Kotlin",
            "Programação"
        )
        listOf(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }

}
