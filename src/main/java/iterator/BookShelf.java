package iterator;


import java.util.ArrayList;

/**
 * @author XuqiangDuan
 * @Date 2018/8/1 9:47
 **/
public class BookShelf implements Aggregate{

    /**
     * book数组
     */
    private ArrayList<Book> books;
    /**
     * book存放数量
     */
    private int length = 0;

    /**
     * 取书
     * @param index
     * @return
     */
    public Book getBookByIndex(int index){
        return books.get(index);
    }

    /**
     * 存书
     * @param book
     */
    public void appendBook(Book book){
//        //使用数组
//        if(length < books.length){
//            this.books[length] = book;
//            length++;
//        }else{
//            System.err.println("本书架可容纳"+books.length+"本书,目前书架已存放："+length+"本书 【书架已存满】");
//        }

        books.add(book);
        length++;

    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * 书架迭代器
     * @return
     */
    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    public BookShelf(int length) {
        this.books = new ArrayList<Book>();
    }

}
