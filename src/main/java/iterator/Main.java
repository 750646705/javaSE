package iterator;

/**
 * @author XuqiangDuan
 * @Date 2018/8/6 13:04
 **/
public class Main {
    public static void main(String[] args) {

        BookShelf bookShelf = new BookShelf(10);
        System.out.println("本书架可容纳" + bookShelf.getBooks().size() + "本书,目前书架已存放：" + bookShelf.getLength() + "本书");
        bookShelf.appendBook(new Book("Hello World!"));
        bookShelf.appendBook(new Book("Three little BOY"));
        bookShelf.appendBook(new Book("READ ME!"));
        bookShelf.appendBook(new Book("JAVA learning"));
        bookShelf.appendBook(new Book("Main"));
        System.out.println("本书架可容纳" + bookShelf.getBooks().size() + "本书,目前书架已存放：" + bookShelf.getLength() + "本书");
        bookShelf.appendBook(new Book("BURSTS"));
        bookShelf.appendBook(new Book("Beautyleg"));
        bookShelf.appendBook(new Book("MongDB"));
        bookShelf.appendBook(new Book("Music learning"));
        bookShelf.appendBook(new Book("GitHub"));
        System.out.println("本书架可容纳" + bookShelf.getBooks().size() + "本书,目前书架已存放：" + bookShelf.getLength() + "本书");
        bookShelf.appendBook(new Book("AAAAA"));
        System.out.println("本书架可容纳" + bookShelf.getBooks().size() + "本书,目前书架已存放：" + bookShelf.getLength() + "本书");
        Iterator iterator = bookShelf.iterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }


    }
}
