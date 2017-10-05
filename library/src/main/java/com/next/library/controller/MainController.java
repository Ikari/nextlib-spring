package com.next.library.controller;

import com.next.library.model.Carrinho;
import com.next.library.model.Produto;
import com.next.library.repository.IProdutoRepository;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

        _repository.save(
                new Produto(
                        1,
                        "Como a mente funciona",
                        "Como as crianças aprendem sobre o mundo que as rodeia? "
                        + "Pinker mostra como podemos estar bem próximos de uma das últimas fronteiras do conhecimento - "
                        + "a mente humana.",
                        "Livro com a capa Branca escrito Como a mente Funciona",
                        "Como a mente funciona",
                        47.90,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/como-a-mente-funciona.jpg"))));

        _repository.save(
                new Produto(
                        2,
                        "Do que é feito o pensamento",
                        "Combinando alguns de seus livros anteriores como O instinto da linguagem (1994) e "
                        + "Como a mente funciona (1998), Steven Pinker encontra na linguagem uma janela para uma "
                        + "possível explicação da natureza humana.",
                        "Livro com a capa Preta escrito Do que é feito o pensamento",
                        "Do que é feito o pensamento",
                        52.90,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/do-que-e-feito-o-pensamento.jpg"))));

        _repository.save(
                new Produto(
                        3,
                        "O Orfanato da Srta. Peregrine",
                        "O orfanato da Srta. Peregrine para Crianças Peculiares é um romance que "
                        + "mistura ficção e fotografia. A história começa com uma tragédia familiar que lança Jacob, "
                        + "um rapaz de 16 anos, em uma jornada até uma ilha remota na costa do País de Gales.",
                        "Livro com a capa cinza escrito O Orfanato da Srta. Peregrine",
                        "O Orfanato da Srta. Peregrine",
                        13.90,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/o-orfanato-da-srta-peregrine.jpg"))));

        _repository.save(
                new Produto(
                        4,
                        "Animais fantasticos e onde habitam",
                        "Inspirado no livro-texto de Hogwarts escrito pelo personagem Newt Scamander, Animais fantásticos e "
                        + "onde habitam – O roteiro original é uma aventura nova e emocionante que apresenta uma variedade "
                        + "de personagens e criaturas mágicas.",
                        "Livro com a capa azul e dourado escrito Animais Fantasticos",
                        "Animais fantasticos e onde habitam",
                        34.90,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/animais-fantasticos-e-onde-habitam.jpg"))));

        _repository.save(
                new Produto(
                        5,
                        "Senhor das Sombras",
                        "A ensolarada Los Angeles pode ser um lugar sombrio na continuação de Dama da Meia-Noite,"
                        + " de Cassandra Clare. Emma Carstairs finalmente conseguiu vingar a morte dos pais "
                        + "e pensou que com isso estaria em paz. ",
                        "Livro com a capa azul escrito Senhor das Sombras",
                        "Senhor das Sombras",
                        37.50,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/senhor-das-sombras.jpg"))));

        _repository.save(
                new Produto(
                        6,
                        "Brasil, Uma Biografia",
                        "Aliando texto acessível e agradável, vasta documentação original e rica iconografia,"
                        + " Lilia Moritz Schwarcz e Heloísa Starling propõem uma nova (e pouco convencional) "
                        + "história do Brasil.",
                        "Livro onde mostra algumas pessoas de costa escrito Brasil uma Biografia",
                        "Brasil, Uma Biografia",
                        41.90,
                        IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("/images/brasil-uma-biografia.jpg"))));
        return "index";

    }
}
