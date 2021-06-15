public final class  Book {
    private final String namebook;
    private final String authorbook;
    private final String quantitypageBook;
    private final String numberIsbn;


    public Book(String nameBook, String authorBook, String quantityPageBook, String numberISBN) {
        namebook = nameBook;
        authorbook = authorBook;
        quantitypageBook = quantityPageBook;
        numberIsbn = numberISBN;
    }

    public String getNameBook() {
        return namebook;
    }

    public String getAuthorBook() {
        return authorbook;
    }

    public String getQuantityPageBook() {
        return quantitypageBook;
    }

    public String getNumberISBN() {
        return numberIsbn;
    }

}
