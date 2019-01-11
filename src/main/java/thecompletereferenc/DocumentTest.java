package thecompletereferenc;

/**
 * this is a class document.
 * @author shangzhidong
 * @version 1.0
 * @see dab
 * @see daa
 * @deprecated
 * {@link daa#a()}
 */
public class DocumentTest {
}


interface daa{
    /**
     * 注解
     * {@link dab#a  tag说明}
     */
    void a();
}


interface dab extends daa{

    /**
     * {@inheritDoc}
     */
    @Override
    void a();
}