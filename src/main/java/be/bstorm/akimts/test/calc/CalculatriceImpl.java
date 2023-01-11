package be.bstorm.akimts.test.calc;

public class CalculatriceImpl implements Calculatrice{
    @Override
    public int addition(int a, int b) {
        int rslt = a + b;

        // a >= 0 ET b >= 0 <-> Overflow si rslt < 0
        // a >= 0 ET b < 0 <-> Pas d'Overflow
        // a < 0 ET b >= 0 <-> Pas d'Overflow
        // a < 0 ET b < 0 <-> Overflow si rslt >= 0

        if( a >= 0 && b >= 0 && rslt < 0 )
            return Integer.MAX_VALUE;
        else if( a < 0 && b < 0 && rslt >= 0 )
            return Integer.MIN_VALUE;
        else
            return rslt;
    }

    @Override
    public int soustraction(int a, int b) {

        int rslt = a - b;

        // a >= 0 ET b >= 0 <-> Pas d'Overflow
        // a >= 0 ET b < 0  <-> Overflow si rslt < 0
        // a < 0 ET b >= 0  <-> Overflow si rslt >= 0
        // a < 0 ET b < 0   <-> Pas d'Overflow

        if( a >= 0 && b < 0 && rslt < 0 )
            return Integer.MAX_VALUE;
        else if( a < 0 && b >= 0 && rslt >= 0 )
            return Integer.MIN_VALUE;
        else
            return rslt;

    }

    @Override
    public int multiplication(int a, int b) {
        long rslt = (long)a * (long)b;

        if( ((a >= 0 && b >= 0) || (a < 0 && b < 0)) && rslt > Integer.MAX_VALUE )
            return Integer.MAX_VALUE;
        else if ( ((a >= 0 && b < 0) || (a < 0 && b >= 0)) && rslt < Integer.MIN_VALUE )
            return Integer.MIN_VALUE;
        else
            return (int) rslt;
    }

    @Override
    public double division(int a, int b) {
        if( b == 0 )
            throw new IllegalArgumentException();

        return (double)a / b;
    }

    @Override
    public int divisionEntiere(int a, int b) {
        if( b == 0 )
            throw new IllegalArgumentException();

        return a / b;
    }

    @Override
    public int modulo(int a, int b) {
        if( b == 0 )
            throw new IllegalArgumentException();

        return a % b;
    }
}
