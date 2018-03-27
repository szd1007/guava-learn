package proxyCache;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestImpl implements ITest {

    @Override public int add(int a, int b) {
//        System.out.println(getClass().getName() + " add return: " + (a + b));
        return a + b;
    }

    @Override public String get(String req) {
//        System.out.println(getClass().getName() + " get return: " + (req + "111"));
        return req + "111";
    }

    @Override
    public List<Person> getPerson(String name) {
        List<Person> result = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setName(name + i);
            p.setAge(i);
            p.setMale(i % 2 == 0);
            List<Book> books = new ArrayList<>();
            for(int j=i+2;j<10;j++) {
                Book book = new Book();
                book.setCode(j * j);
                book.setDesc(name + i + "'s book");
                book.setName("test" + j);
                books.add(book);
            }
            p.setBookList(books);
            result.add(p);

        }
        return result;
    }

    @Override public Map<String, Person> getPersonMap(String name) {
        List<Person> pList = getPerson(name);
        Map<String,Person>result = Maps.newHashMap();
        pList.forEach((x) -> result.put(x.getName(), x));
        return result;
    }
}
