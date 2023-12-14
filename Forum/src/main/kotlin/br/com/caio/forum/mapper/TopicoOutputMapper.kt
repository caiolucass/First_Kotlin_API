package br.com.caio.forum.mapper

import br.com.caio.forum.dto.TopicoDTOOutput
import br.com.caio.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoOutputMapper: Mapper <Topico, TopicoDTOOutput> {

    override fun map(t: Topico): TopicoDTOOutput {
        return TopicoDTOOutput(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.data,
            status = t.status
        )
    }

}