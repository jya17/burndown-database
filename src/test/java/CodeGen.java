import org.batgen.BatGen;
import org.batgen.DatabaseType;

public class CodeGen {

    public static void main( String[]args ) {
        BatGen batGen = new BatGen( "src/test/resources", "test.app.sample", DatabaseType.H2 );
        batGen.run();
    }
    
}