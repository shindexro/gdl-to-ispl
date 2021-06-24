import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.InputStream;

public class Translator {
    public static void main(String[] args) throws Exception {
        String inputFile = (args.length > 0) ? args[0] : null;
        InputStream is = (inputFile == null) ? System.in : new FileInputStream(inputFile);
        CharStream cs = CharStreams.fromStream(is);

        GDLLexer lexer = new GDLLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GDLParser parser = new GDLParser(tokens);
        ParseTree tree = parser.description();

        ParseTreeWalker walker = new ParseTreeWalker();
        TranslationListener listener = new TranslationListener(parser);
        walker.walk(listener, tree);
    }
}
