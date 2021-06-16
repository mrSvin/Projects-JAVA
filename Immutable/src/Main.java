public class Main {

    public static void main(String[] args) {
        Book book = new Book("Java. Руководство для начинающих.","Шилдт Герберт","816","978-5-6041394-5-5");
        System.out.println("Книга:" + book.getNameBook());
        System.out.println("Автор:" + book.getAuthorBook());
        System.out.println("Страниц:" + book.getQuantityPageBook());
        System.out.println("ISBN:" + book.getNumberISBN());

        Product product = new Product("тапок",50,"25689");
        System.out.println("\nТовар:" + product.getName());
        System.out.println("Цена (неизменяемая):" + product.getPrice());
        System.out.println("Код:" + product.getbarCode());
    }


}
