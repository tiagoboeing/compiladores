package compilador.decomposer;

import compilador.controller.LexicalError;
import compilador.controller.Token;

import java.util.List;
import java.util.function.Consumer;

public enum PositionCalc {

    lineColumn {
        private void calculateRealPosition(int absPos, Consumer<Integer> setLine, Consumer<Integer> setColumn, List<Integer> breakList) {
            int line;
            if (breakList.stream().anyMatch((x) -> x >= absPos)) {
                line = breakList.indexOf(breakList.stream().filter((x) -> x >= absPos).findFirst().get()) + 1;
            } else {
                line = breakList.size() + 1;
            }

            int column;
            if (line == 1) {
                column = absPos + 1;
            } else {
                column = absPos - breakList.get(line - 2);
            }

            setLine.accept(line);
            setColumn.accept(column);
        }

        @Override
        public void calc(DecomposerFactory decFac, Token token) {
            if (token != null) {
                int absPos = token.getPosition();
                calculateRealPosition(absPos, token::setLine, token::setColumn, decFac.getBreakList());
            }
        }

        @Override
        public void calc(DecomposerFactory decFac, LexicalError error) {
            if (error != null) {
                int absPos = error.getPosition();
                calculateRealPosition(absPos, error::setLine, error::setColumn, decFac.getBreakList());
            }
        }

    };

    public abstract void calc(DecomposerFactory decFac, Token token);
    public abstract void calc(DecomposerFactory decFac, LexicalError error);
}