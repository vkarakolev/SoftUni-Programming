import java.util.*;

public class E04_Articles2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandCount = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < commandCount; i++) {
            String[] inputLine = scanner.nextLine().split(", ");
            Article article = new Article(inputLine);
            articles.add(article);
        }

        String command = scanner.nextLine();

        switch(command){
            case "title":
                Collections.sort(articles, Comparator.comparing(Article::getTitle));
                break;
            case "content":
                Collections.sort(articles, Comparator.comparing(Article::getContent));
                break;
            case "author":
                Collections.sort(articles, Comparator.comparing(Article::getAuthor));
                break;
        }

        for (Article article : articles) {
           article.toString(article);
        }

    }

    static class Article {
        String title;
        String  content;
        String author;

        public Article (String[] inputLine){
            this.title = inputLine[0];
            this.content = inputLine[1];
            this.author = inputLine[2];
        }

        public String getTitle(){
            return title;
        }

        public String getContent(){
            return content;
        }

        public String getAuthor(){
            return author;
        }

        public void toString (Article article){
            String output = String.format("%s - %s: %s%n", title, content, author);
            System.out.print(output);
        }
    }
}
