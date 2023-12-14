package br.com.caio.forum.mapper

import br.com.caio.forum.dto.TopicoDTOInput
import br.com.caio.forum.model.Topico
import br.com.caio.forum.service.AutorService
import br.com.caio.forum.service.CursoService
import org.springframework.stereotype.Component

@Component
class TopicoInputMapper(private val cursoService: CursoService,
                        private val usuarioService: AutorService): Mapper<TopicoDTOInput, Topico> {

    override fun map(t: TopicoDTOInput): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}


