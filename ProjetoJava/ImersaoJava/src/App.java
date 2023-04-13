import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão http e buscar o top 250 filmes(IMDB) //
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        ExtratorConteudoIMDB extrator = new ExtratorConteudoIMDB();
        
        
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-03-29&end_date=2023-03-29";
        //ExtratorConteudoNasa extrator = new ExtratorConteudoNasa();

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);

        // Exibir e manipular os dados
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var diretorio = new File("C:\\Users\\Jack\\Documents\\ImersaoJava\\ImersaoJava\\figurinhas\\ ");
        diretorio.mkdir();
        FabricaFigurinhas fabrica = new FabricaFigurinhas();

        for (Conteudo conteudo : conteudos) {

            // String urlImagem = conteudo.get("image");

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = diretorio + conteudo.getTitulo().replace(":", "-") + ".png";

            fabrica.criar(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
            // System.out.println(filme.get("imDbRating"));

        }

    }
}
