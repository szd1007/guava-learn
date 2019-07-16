package effectiveJava;

import java.util.Date;

public class Eff_50{}
/**
 * 50. 进行必要的保护性拷贝[]
 */
 final class Period {
    @EfLanguagePoints("Date 已经过时了，新代码不要使用")
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date((end.getTime()));
        if (this.start.compareTo(this.end) < 0) {
            throw new IllegalArgumentException(this.start + "after" + this.end);
        }
    }

    @EfLanguagePoints("保护性拷贝")
    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }
}
