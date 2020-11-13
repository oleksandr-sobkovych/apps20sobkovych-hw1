package array.operations;

public class ArrayLengthExtend {
    private final int extendCoef;

    public ArrayLengthExtend(int extend_coef) {
        this.extendCoef = extend_coef;
    }

    public int extend(int arrayLen) {
        /*
        Extend array length according to coeficient.
         */
        if (arrayLen == 0) {
            return arrayLen+1;
        } else {
            return arrayLen*extendCoef;
        }
    }
}
