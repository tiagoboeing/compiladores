package compilador.semantic.semanticActions;

import java.util.*;
import java.util.function.Predicate;

public class SemanticActionGrouper {

    private static Collection<SemanticAction> actions;
    static {
        Set<SemanticAction> actionList = new LinkedHashSet<>();
        actionList.addAll(Arrays.asList(BooleanActions.values()));
        actionList.addAll(Arrays.asList(InterfaceActions.values()));
        actionList.addAll(Arrays.asList(HeadersActions.values()));
        actionList.addAll(Arrays.asList(NumericActions.values()));
        actionList.addAll(Arrays.asList(VariableActions.values()));
        actionList.addAll(Arrays.asList(StringActions.values()));
        actions = actionList;
    }

    private static Predicate<SemanticAction> actionFilter(int actionId) {
        return x -> x.getNumber() == actionId;
    }

    public static SemanticAction getAction(int actionId) {
        final Predicate<SemanticAction> F = actionFilter(actionId);
        final Optional<SemanticAction> ACTION_OPTIONAL = actions.
                stream().
                filter(F).
                findFirst();
        return ACTION_OPTIONAL.orElse(null);
    }

}
