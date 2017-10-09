package com.next.library.controller;

import com.next.library.model.Carrinho;
import com.next.library.model.Produto;
import com.next.library.repository.IProdutoRepository;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author roger
 */
@Controller
public class MainController {

    IProdutoRepository _repository;

    protected MainController(IProdutoRepository repository) {
        _repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws IOException, URISyntaxException {

        request.getSession().setAttribute("carrinho", new Carrinho());
/*  
        _repository.save(
                new Produto(
                        1,
                        "Como a mente funciona",
                        "Como as crianÃ§as aprendem sobre o mundo que as rodeia? "
                        + "Pinker mostra como podemos estar bem prÃ³ximos de uma das Ãºltimas fronteiras do conhecimento - "
                        + "a mente humana.",
                        47.9,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/como-a-mente-funciona.jpg"))));

        _repository.save(
                new Produto(
                        2,
                        "Do que Ã© feito o pensamento",
                        "Combinando alguns de seus livros anteriores como O instinto da linguagem (1994) e "
                        + "Como a mente funciona (1998), Steven Pinker encontra na linguagem uma janela para uma "
                        + "possÃ­vel explicaÃ§Ã£o da natureza humana.",
                        52.9,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/do-que-e-feito-o-pensamento.jpg"))));

        _repository.save(
                new Produto(
                        3,
                        "O Orfanato da Srta. Peregrine Para CrianÃ§as Peculiares",
                        "O orfanato da Srta. Peregrine para CrianÃ§as Peculiares Ã© um romance que "
                        + "mistura ficÃ§Ã£o e fotografia. A histÃ³ria comeÃ§a com uma tragÃ©dia familiar que lanÃ§a Jacob, "
                        + "um rapaz de 16 anos, em uma jornada atÃ© uma ilha remota na costa do PaÃ­s de Gales.",
                        13.9,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/o-orfanato-da-srta-peregrine.jpg"))));

        _repository.save(
                new Produto(
                        4,
                        "Animais fantasticos e onde habitam",
                        "Inspirado no livro-texto de Hogwarts escrito pelo personagem Newt Scamander, Animais fantÃ¡sticos e "
                        + "onde habitam â€“ O roteiro original Ã© uma aventura nova e emocionante que apresenta uma variedade "
                        + "de personagens e criaturas mÃ¡gicas.",
                        34.9,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/animais-fantasticos-e-onde-habitam.jpg"))));

        _repository.save(
                new Produto(
                        5,
                        "Senhor das Sombras",
                        "A ensolarada Los Angeles pode ser um lugar sombrio na continuaÃ§Ã£o de Dama da Meia-Noite,"
                        + " de Cassandra Clare. Emma Carstairs finalmente conseguiu vingar a morte dos pais "
                        + "e pensou que com isso estaria em paz. ",
                        37.5,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/senhor-das-sombras.jpg"))));

        _repository.save(
                new Produto(
                        6,
                        "Brasil, Uma Biografia",
                        "Aliando texto acessÃ­vel e agradÃ¡vel, vasta documentaÃ§Ã£o original e rica iconografia,"
                        + " Lilia Moritz Schwarcz e HeloÃ­sa Starling propÃµem uma nova (e pouco convencional) "
                        + "histÃ³ria do Brasil.",
                        41.9,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/brasil-uma-biografia.jpg"))));

              
        _repository.save(
                new Produto(
                        5,
                        "Senhor das Sombras",
                        "O segundo volume da nova sÃ©rie da Cassandra Clare, autora do grande sucesso Os Instrumentos Mortais. "
                        + "A ensolarada Los Angeles pode ser um lugar sombrio na continuaÃ§Ã£o de Dama da Meia-Noite."
                        + " Emma Carstairs finalmente conseguiu vingar a morte dos pais e pensou que ficaria em paz."
                        + " Mas isso nÃ£o aconteceu. Dividida entre o amor que sente pelo seu parabatai Julian e a vontade "
                        + "de protegÃª-lo das graves consequÃªncias que um relacionamento.",
                        38.4,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/senhor-das-sombras.jpg"))));

        _repository.save(
                new Produto(
                        6,
                        "Brasil, uma Biografia",
                        "Com linguagem fluente, acesso a documentaÃ§Ã£o inÃ©dita e profundo rigor na pesquisa, Lilia Moritz Schwarcz e "
                        + "Heloisa Murgel Starling traÃ§am um retrato de corpo inteiro do paÃ­s, e mostram que o Brasil "
                        + "bem merecia uma nova histÃ³ria. Aliando texto acessÃ­vel e agradÃ¡vel, vasta documentaÃ§Ã£o "
                        + "original e rica iconografia, Lilia Moritz Schwarcz e Heloisa Starling propÃµem uma nova "
                        + "(e pouco convencional) histÃ³ria do Brasil.",
                        39.8,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/brasil-uma-biografia.jpg"))));
         */
        return "index";

    }
}
