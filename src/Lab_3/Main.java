package Lab_3;

public class Main {
    public static void main(String[] args) {
        BookRepository model = new BookRepository();

        BookView view = new BookView();

        BookController controller = new BookController(model, view);

        controller.startApp();
    }
}
