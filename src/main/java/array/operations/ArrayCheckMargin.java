package array.operations;

import comparisons.CompareDoubles;

public class ArrayCheckMargin {
    public boolean checkAnyMargin(double[] array, double margin, int desirable_size, CompareDoubles compareDoubles) {
        /*
        Check how all elements in array until desirable_size compare to margin.
        */
        for (int i = 0; i < desirable_size; i++) {
            if (compareDoubles.compare(array[i], margin)) {return true;}
        }
        return false;
    }
}
