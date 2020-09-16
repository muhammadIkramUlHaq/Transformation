import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;

import java.util.List;

/**
 * Flag Removal
 *
 * @author Muhammad Ikram Ul Haq
 */
public class FlagRemovalProcessor extends AbstractProcessor<CtMethod<?>> {

    @Override
    public boolean isToBeProcessed(CtMethod<?> element) {
        return element.getBody() != null;
    }
    
    @Override
    public void process(CtMethod<?> element) {

        final CtLocalVariable localVariableTa = getFactory().Core().createLocalVariable();
        localVariableTa.setType(getFactory().createCtTypeReference(Integer.TYPE));
        localVariableTa.setSimpleName("Ta");
        localVariableTa.setInferred(true);
        localVariableTa.setAssignment(getFactory().createCodeSnippetExpression("a"));

        final CtLocalVariable localVariableTb = getFactory().Core().createLocalVariable();
        localVariableTb.setType(getFactory().createCtTypeReference(Integer.TYPE));
        localVariableTb.setSimpleName("Tb");
        localVariableTb.setInferred(true);
        localVariableTb.setAssignment(getFactory().createCodeSnippetExpression("b"));

        final CtStatementList statementList = getFactory().createStatementList();
        statementList.addStatement(localVariableTa);
        statementList.addStatement(localVariableTb);
        element.getBody().insertBegin(statementList);

        final List<CtElement> directChildren = element.getBody().getDirectChildren();
        final CtIf ctIfStatement = (CtIf) directChildren.get(directChildren.size() - 1);

        final CtConditional conditionalStatement = getFactory().createConditional();
        final String variableTa = localVariableTa.getSimpleName();
        final String variableTb = localVariableTb.getSimpleName();
        final String condition = getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.GT)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression("( " + variableTa))
                .setRightHandOperand(getFactory().createCodeSnippetExpression(variableTb + " )"))
                .toString();
        final String trueCaseExpression1 = getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.PLUS)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(variableTa))
                .setRightHandOperand(getFactory().createLiteral(1))
                .toString();
        final String trueCaseExpression2 = getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.EQ)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(trueCaseExpression1))
                .setRightHandOperand(getFactory().createCodeSnippetExpression(variableTb))
                .toString();
       final String trueCaseExpression3 =  getFactory().createUnaryOperator()
                .setKind(UnaryOperatorKind.NOT)
                .setOperand(getFactory().createCodeSnippetExpression("( " + trueCaseExpression2 + " )"))
                .toString();
       final String trueCaseExpression4 =  getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.PLUS)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(variableTa))
                .setRightHandOperand(getFactory().createLiteral(3))
                .toString();
       final String trueCaseExpression5 =  getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.OR)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(trueCaseExpression3))
                .setRightHandOperand(getFactory().createCodeSnippetExpression("( " + trueCaseExpression4 + " )"))
                .toString();
       final String trueCaseExpression6 =  getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.PLUS)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(trueCaseExpression5))
                .setRightHandOperand(getFactory().createLiteral(2))
                .toString();
       final String trueCaseExpression =  getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.GT)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(trueCaseExpression6))
                .setRightHandOperand(getFactory().createCodeSnippetExpression("c"))
                .toString();
       final String falseCaseExpression1 =  getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.EQ)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(variableTa))
                .setRightHandOperand(getFactory().createCodeSnippetExpression(variableTb))
                .toString();
       final String falseCaseExpression2 =  getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.AND)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(falseCaseExpression1))
                .setRightHandOperand(getFactory().createCodeSnippetExpression(variableTa))
                .toString();
       final String falseCaseExpression3 =  getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.PLUS)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(falseCaseExpression2))
                .setRightHandOperand(getFactory().createLiteral(2))
                .toString();
       final String falseCaseExpression =  getFactory().createBinaryOperator()
                .setKind(BinaryOperatorKind.GT)
                .setLeftHandOperand(getFactory().createCodeSnippetExpression(falseCaseExpression3))
                .setRightHandOperand(getFactory().createCodeSnippetExpression("c"))
                .toString();

        conditionalStatement.setCondition(getFactory().createCodeSnippetExpression(condition));
        conditionalStatement.setThenExpression(getFactory().createCodeSnippetExpression(trueCaseExpression));
        conditionalStatement.setElseExpression(getFactory().createCodeSnippetExpression(falseCaseExpression));

        ctIfStatement.setCondition(conditionalStatement) ;
    }
   
}
