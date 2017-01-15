package collections;

import com.google.common.collect.ForwardingList;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;

import java.util.List;

/**
 * Created by shangzhidong on 2017/1/13.
 * https://github.com/google/guava/wiki/CollectionHelpersExplained
 *
 */
public class CollectionHelpersExplainedTest {


    /**Forward decorators*/
    static class myDecoratorList extends ForwardingList<String>{
        private List <String> list;
        @Override
        protected List<String> delegate() {
            return list;
        }

        @Override
        public boolean add(String element) {
            //do something Else
            return super.add(element);
        }
    }



    public static void main(String[] args) {
        /**
         * Peeking iterator
         */
        List<String> p = Lists.newArrayList();
        PeekingIterator<String> iterss = Iterators.peekingIterator(p.iterator());
        while (iterss.hasNext()){
            String cur = iterss.next();
            while (iterss.hasNext() && iterss.peek().equals(cur)){
                //skip duplicate
                iterss.next();
            }
            //do something else
        }
    }


}
