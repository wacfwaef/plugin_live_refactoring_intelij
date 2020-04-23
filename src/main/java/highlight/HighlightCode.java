package highlight;

import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.codeHighlighting.HighlightingPass;
import com.intellij.codeInsight.highlighting.HighlightHandlerBase;
import com.intellij.codeInsight.highlighting.HighlightManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.text.MessageFormat;
import java.util.Collection;

public class HighlightCode  {


    private static void highlight(@NotNull HighlightManager highlightManager,
                                  @NotNull Collection<TextRange> textRanges, @NotNull Editor editor,
                                  @Nullable Collection<RangeHighlighter> holder
    ) {
        final TextAttributes ta = TextAttributesFactory.getInstance().get();
        final Color scrollMarkColor;
        if (ta.getErrorStripeColor() != null) {
            scrollMarkColor = ta.getErrorStripeColor().brighter();
        } else if (ta.getBackgroundColor() != null) {
            scrollMarkColor = ta.getBackgroundColor().darker();
        } else {
            scrollMarkColor = null;
        }
        for (TextRange range : textRanges) {
            highlightManager.addOccurrenceHighlight(editor, range.getStartOffset(),
                    range.getEndOffset(), ta, 0, holder, scrollMarkColor);
        }
        
    }



}
