import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

/*The java.io package includes a PrintStream class that has two formatting methods that
you can use to replace print and println. These methods, format and printf, are equivalent
to one another. The familiar System.out that you have been using happens to be a PrintStream
object, so you can invoke PrintStream methods on System.out. Thus, you can use format or
printf anywhere in your code where you have previously been using print or println.
*/
public class Format

{
        public static void main(String[] args)
        {

                float floatVar = 321146.59f;
                int intVar = 32114659;
                String stringVar = "32114659";


                System.out.format("\nThe value of " + "the float variable is " +
                        "%f, while the value of the " + "integer variable is %d, " +
                        "and the string is %s\n\n", floatVar, intVar, stringVar);

                Examples();

                //DecimalFormat Class
                customFormat("###,###.###", 123456.789);
                customFormat("###.##", 123456.789);
                customFormat("000000.000", 123.78);
                customFormat("$###,###.###", 12345.67);

                // for further detail see https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
        }

        static void Examples()
        {
                long n = 461012;

                System.out.format("%d%n", n);      //  -->  "461012"
                System.out.format("%08d%n", n);    //  -->  "00461012"
                System.out.format("%+8d%n", n);    //  -->  " +461012"
                System.out.format("%,8d%n", n);    // -->  " 461,012"
                System.out.format("%+,8d%n%n", n); //  -->  "+461,012"

                double pi = Math.PI;

                System.out.format("%f%n", pi);       // -->  "3.141593"
                System.out.format("%.3f%n", pi);     // -->  "3.142"
                System.out.format("%10.3f%n", pi);   // -->  "     3.142"
                System.out.format("%-10.3f%n", pi);  // -->  "3.142"
                System.out.format(Locale.FRANCE,
                        "%-10.4f%n%n", pi); // -->  "3,1416"

                Calendar c = Calendar.getInstance();
                System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"

                System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"

                System.out.format("%tD%n", c);    // -->  "05/29/06"
        }


        static public void customFormat(String pattern, double value )
        {
                DecimalFormat myFormatter = new DecimalFormat(pattern);
                String output = myFormatter.format(value);
                System.out.println(value + "  " + pattern + "  " + output);
        }
}
