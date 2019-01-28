public class GCD
{
    public static long gcd( long m, long n )
    {
        while( n != 0 )
        {
        	System.out.println(m+":"+n);
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    // Test program
    public static void main( String [ ] args )
    {
        System.out.println( "gcd( 45, 35 ) = " + gcd( 45, 35 ) );
        System.out.println( "gcd( 1989, 1590 ) = " + gcd( 1989, 1590 ) );
        System.out.println( "gcd( 1500033, 1000003 ) = " + gcd( 1500033, 1000003 ) );

    }
}
