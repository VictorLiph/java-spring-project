
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa 
{
    
    
    public List<Conteudo> extraiConteudos(String json)
    {
        // Extrair(parciar) só dados que interessam (titulo, poster, classificação)//
        JsonParser parser = new JsonParser();

        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) 
        {
            String urlImagem = atributos.get("url").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String titulo = atributos.get("title").replaceAll("(@+)(.*).jpg$", "$1.jpg");


            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
