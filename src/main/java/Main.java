import org.ggp.base.util.files.FileUtils;
import org.ggp.base.util.game.Game;
import org.ggp.base.util.gdl.grammar.Gdl;
import org.ggp.base.util.gdl.grammar.GdlRule;
import org.ggp.base.util.gdl.transforms.DeORer;
import org.ggp.base.util.gdl.transforms.VariableConstrainer;
import org.ggp.base.util.propnet.factory.flattener.PropNetFlattener;
import org.ggp.base.validator.StaticValidator;
import org.ggp.base.validator.ValidatorException;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String inFilePath, outFilePath;

        if (args.length == 2) {
            inFilePath = args[0];
            outFilePath = args[1];
        } else {
            System.out.println("Usage: java -jar gdl2ispl.jar <path_to_gdl_file> <output_path>");
            System.out.println("Example: java -jar gdl2ispl.jar C:\\Users\\Ian\\Desktop\\connect4.kif C:\\Users\\Ian\\Desktop\\connect4.ispl");
            return;
        }

        long startTime = System.nanoTime();
        long phaseStartTime = System.nanoTime();

        // Check GDL validity
        Game theGame = Game.createEphemeralGame(Game.preprocessRulesheet(FileUtils.readFileAsString(new File(inFilePath))));
        if (theGame.getRules() == null || theGame.getRules().size() == 0) {
            System.err.println("Problem reading the file " + inFilePath + " or parsing the GDL.");
            return;
        }

        try {
            new StaticValidator().checkValidity(theGame);
        } catch (ValidatorException e) {
            System.err.println("GDL validation error: " + e);
            return;
        }
        System.out.println("Time for GDL validity check: " + (System.nanoTime() - phaseStartTime) / 1000000 + " ms");
        phaseStartTime = System.nanoTime();

        // Flattening
        List<Gdl> description = theGame.getRules();
        description = VariableConstrainer.replaceFunctionValuedVariables(description);
        description = DeORer.run(description);
        PropNetFlattener pf = new PropNetFlattener(description);
        List<GdlRule> flatDescription = pf.flatten();
        System.out.println("Time for flattening: " + (System.nanoTime() - phaseStartTime) / 1000000 + " ms");
        phaseStartTime = System.nanoTime();

        // Compile into ISPL
        Translator isplFactory = new Translator(flatDescription);
        String isplDescription = isplFactory.build();
        File outFile = new File(outFilePath);
        FileUtils.writeStringToFile(outFile, isplDescription);
        System.out.println("Time for ISPL compilation: " + (System.nanoTime() - phaseStartTime) / 1000000 + " ms");

        System.out.println("Total time elapsed: " + (System.nanoTime() - startTime) / 1000000 + " ms");
    }
}

