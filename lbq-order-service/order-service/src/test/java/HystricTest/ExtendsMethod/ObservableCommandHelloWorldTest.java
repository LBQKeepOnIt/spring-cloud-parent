package HystricTest.ExtendsMethod;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/7 18:07
 */
import org.junit.Test;
import rx.Observable;

import java.util.Iterator;

public class ObservableCommandHelloWorldTest {

    @Test
    public void testObservable() {
        Observable<String> observable= new ObservableCommandHelloWorld("World").observe();

        Iterator<String> iterator = observable.toBlocking().getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testToObservable() {
        Observable<String> observable= new ObservableCommandHelloWorld("World").observe();
        Iterator<String> iterator = observable.toBlocking().getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
