package effectiveJava;

/**
 * 35. 用实力域代替序数[永远不要使用ordinal 方法]
 */
public class Eff_35 {

    @EfLanguagePoints("不要使用ordinal方法 这样会导致维护难度很大")
    public enum Ensemble {
        SOLO, DUET, TRIO, QUARTET;
        public int numberOfMusicians(){return ordinal()+1;}
    }
    @EfLanguagePoints("推荐写法")
    public static enum Ensemble2{
        SOLO(1), DUET(2), TRIO(3), QUARTET(4);

        private final int numberOfMusicians ;
        Ensemble2(int size){
            this.numberOfMusicians = size;
        }
        public int NumberOfMusicians(){
            return numberOfMusicians;
        }
    }
}
