package plugin_psi_weaver;

import com.intellij.psi.PsiElement;
import org.lara.interpreter.weaver.options.WeaverOption;
import org.lara.language.specification.LanguageSpecification;
import plugin_psi_weaver.abstracts.weaver.APsiWeaver;

import java.util.Collections;
import java.util.List;
import java.io.File;
import org.suikasoft.jOptions.Interfaces.DataStore;
import org.lara.interpreter.weaver.interf.JoinPoint;
import org.lara.interpreter.weaver.interf.AGear;

/**
 * Weaver Implementation for PsiWeaver<br>
 * Since the generated abstract classes are always overwritten, their implementation should be done by extending those abstract classes with user-defined classes.<br>
 * The abstract class {@link plugin_psi_weaver.abstracts.APsiWeaverJoinPoint} can be used to add user-defined methods and fields which the user intends to add for all join points and are not intended to be used in LARA aspects.
 * @author Lara Weaver Generator
 */
public class PsiWeaver extends APsiWeaver {

    public PsiWeaver(PsiElement rooot) {
        this.root = rooot;
    }
    private PsiElement root;
    /**
     * Warns the lara interpreter if the weaver accepts a folder as the application or only one file at a time.
     * 
     * @return true if the weaver is able to work with several files, false if only works with one file
     */
    public boolean handlesApplicationFolder() {
        //Can the weaver handle an application folder?
        return true;
    }

    /**
     * Set a file/folder in the weaver if it is valid file/folder type for the weaver.
     * 
     * @ param source the file with the source code
     * @param outputDir output directory for the generated file(s)
     * @param args arguments to start the weaver
     * @return true if the file type is valid
     */
    public boolean begin(List<File> sources, File outputDir, DataStore args) {
        //Initialize weaver with the input file/folder
        throw new UnsupportedOperationException("Method begin for PsiWeaver is not yet implemented");
    }

    /**
     *  Return a JoinPoint instance of the language root, i.e., an instance of AApp
     * @return an instance of the join point root/program
     */
    public JoinPoint select() {
        //return new <AApp implementation>;
        throw new UnsupportedOperationException("Method select for PsiWeaver is not yet implemented");
    }

    @Override
    public List<WeaverOption> getOptions() {
        return Collections.emptyList();
    }

    @Override
    public LanguageSpecification getLanguageSpecification() {
        return LanguageSpecification.newInstance(() -> "joinPointModel.xml", () -> "artifacts.xml",
                () -> "actionModel.xml", true);
    }
    /**
     *  Closes the weaver to the specified output directory location, if the weaver generates new file(s)
     * 
     * @return if close was successful
     */
    public boolean close() {
        //Terminate weaver execution with final steps required and writing output files
        throw new UnsupportedOperationException("Method close for PsiWeaver is not yet implemented");
    }

    /**
     *  Returns a list of Gears associated to this weaver engine
     * 
     * @return a list of implementations of {@link AGear} or null if no gears are available
     */
    public List<AGear> getGears() {
        return null; //i.e., no gears currently being used
    }

    /**
     * Returns Weaving Engine as a PsiWeaver
     */
    public static PsiWeaver getPsiWeaver() {
        return (PsiWeaver) getThreadLocalWeaver();
    }
}
