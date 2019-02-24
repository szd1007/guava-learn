package refactoring;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * you want to replace an algorithm with one that is clear.
  */
public class RfSubstituteAlgorithm {

    String foundPerson(List<String> people) {
        for (String person : people) {
            if (person.equals("Don")) {
                return "Don";
            }
            if (person.equals("John")) {
                return "John";
            }
            if (person.equals("Kent")) {
                return "Kent";
            }
        }
        return "";
    }

    ////////////////////////////////////////////
    ///////////////////////////////////////////
    String foundPerson2(List<String> people) {
        List<String> candidates = Lists.newArrayList("Don", "John", "Kent");
        for (String person : people) {
            if (candidates.contains(person)) {
                return person;
            }
        }
        return "";
    }
}
