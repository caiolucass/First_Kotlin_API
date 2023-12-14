package br.com.caio.forum.service

import br.com.caio.forum.dto.TopicoDTO
import br.com.caio.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(),
                    private val cursoServive: CursoService,
                    private val autorService: AutorService) {

    fun listar(): List<Topico> {
      return topicos
    }

    fun buscarPorId(id: Long): Topico {
      return topicos.stream().filter { t ->
          t.id == id
      }.findFirst().get()
    }

    fun cadastrar(dto: TopicoDTO){
        topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoServive.buscarPorId(dto.idCurso),
            autor = autorService.buscarPorId(dto.idCurso)
        ))
    }
}