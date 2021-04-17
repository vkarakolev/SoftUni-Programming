import java.util.Scanner;

public class E02_Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split(", ");
        Article article = new Article(inputLine);
        int commandCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandCount; i++) {
            String[] command = scanner.nextLine().split(": ");

            switch (command[0]){
                case "Edit" :
                    article.edit(command);
                    break;
                case "ChangeAuthor" :
                    article.changeAuthor(command);
                    break;
                case "Rename" :
                    article.rename(command);
                    break;
            }
        }
        
        article.toString(article);
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

        public void edit (String[] command){
            this.content = command[1];
        }

        public void changeAuthor (String[] command){
            this.author = command[1];
        }

        public void rename (String[] command){
            this.title = command[1];
        }

        public void toString (Article article){
            String output = String.format("%s - %s: %s", title, content, author);
            System.out.println(output);
        }
    }
    
}
