package org.jetbrains.plugins.cucumber.groovy.steps;

import com.intellij.codeHighlighting.Pass;
import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.openapi.editor.markup.GutterIconRenderer;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import icons.CucumberIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.plugins.cucumber.groovy.GrCucumberUtil;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.expressions.GrMethodCall;

import java.util.Collection;
import java.util.List;

/**
 * @author Max Medvedev
 */
public class GrCucumberLineMarkerProvider implements LineMarkerProvider {

  @Nullable
  @Override
  public LineMarkerInfo getLineMarkerInfo(@NotNull PsiElement element) {
    if (GrCucumberUtil.isStepDefinition(element)) {
      PsiElement anchor = PsiTreeUtil.getDeepestFirst(element);

      return new LineMarkerInfo<>(
        anchor,
        anchor.getTextRange(),
        CucumberIcons.Cucumber,
        Pass.LINE_MARKERS,
        __ -> ((GrMethodCall)element).getPresentation().getPresentableText(),
        null, GutterIconRenderer.Alignment.RIGHT
      );
    }
    else {
      return null;
    }
  }

  @Override
  public void collectSlowLineMarkers(@NotNull List<PsiElement> elements, @NotNull Collection<LineMarkerInfo> result) {
  }
}
