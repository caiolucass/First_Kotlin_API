package br.com.caio.forum.service

import br.com.caio.forum.dto.TopicoDTOInput
import br.com.caio.forum.dto.TopicoDTOOutput
import br.com.caio.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(),
                    private val cursoServive: CursoService,
                    private val autorService: AutorService) {

    fun listar(): List<TopicoDTOOutput> {
      return topicos.stream().map { t -> TopicoDTOOutput(
             id = t.id,
             titulo = t.titulo,
             mensagem = t.mensagem,
             dataCriacao = t.data,
             status = t.status
          )}.toList()
    }

    fun buscarPorId(id: Long): TopicoDTOOutput {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return TopicoDTOOutput(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            dataCriacao = topico.data,
            status = topico.status
        )
    }

    fun cadastrar(dto: TopicoDTOInput){
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoServive.buscarPorId(dto.idCurso),
            autor = autorService.buscarPorId(dto.idCurso)
        ))
    }
}