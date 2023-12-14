package br.com.caio.forum.service

import br.com.caio.forum.dto.TopicoDTOInput
import br.com.caio.forum.dto.TopicoDTOOutput
import br.com.caio.forum.mapper.TopicoInputMapper
import br.com.caio.forum.mapper.TopicoOutputMapper
import br.com.caio.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(),
                    private val topicoOutputMapper: TopicoOutputMapper,
                    private val topicoIntpuMapper: TopicoInputMapper
) {

    fun listar(): List<TopicoDTOOutput> {
      return topicos.stream().map{
          t -> topicoOutputMapper.map(t)
      }.toList()
    }

    fun buscarPorId(id: Long): TopicoDTOOutput {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicoOutputMapper.map(topico)
    }

    fun cadastrar(dto: TopicoDTOInput){
        val topico = topicoIntpuMapper.map(dto)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topicoIntpuMapper.map(dto))
    }
}