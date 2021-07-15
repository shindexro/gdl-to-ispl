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

public class Translator {
    public static void main(String[] args) throws Exception {
        String gameName = "firefighter";
        String filename = "D:\\mcmas\\mcmas-1.3.0\\gdl\\" + gameName + ".kif";
        Game theGame = Game.createEphemeralGame(Game.preprocessRulesheet(FileUtils.readFileAsString(new File(filename))));

        if (theGame.getRules() == null || theGame.getRules().size() == 0) {
            System.err.println("Problem reading the file " + filename + " or parsing the GDL.");
            return;
        }

        try {
            new StaticValidator().checkValidity(theGame);
        } catch (ValidatorException e) {
            System.err.println("GDL validation error: " + e);
            return;
        }

        List<Gdl> description = theGame.getRules();
        description = VariableConstrainer.replaceFunctionValuedVariables(description);
        description = DeORer.run(description);
        PropNetFlattener pf = new PropNetFlattener(description);
        List<GdlRule> flatDescription = pf.flatten();

        IsplDescriptionFactory isplFactory = new IsplDescriptionFactory(flatDescription);
        String isplDescription = isplFactory.build();
        File outFile = new File("D:\\mcmas\\mcmas-1.3.0\\gdl2ispl\\" + gameName + ".ispl");
        FileUtils.writeStringToFile(outFile, isplDescription);
    }
}

