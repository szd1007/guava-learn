package proxyCache;

import com.google.common.base.Strings;

import java.util.List;

public class Person {

    private String name;
    private boolean male;
    private Integer age;
    List<Book> bookList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override public String toString() {
        return "Person{" + "name='" + name + '\'' + ", male=" + male + ", age=" + age + ", bookList=" + bookList + '}';
    }
}
