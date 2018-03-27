package proxyCache;

import java.util.List;
import java.util.Map;

public interface ITest {

    int add(int a, int b);

    String get(String req);

    List<Person> getPerson(String name);

    Map<String, Person> getPersonMap(String name);
}
