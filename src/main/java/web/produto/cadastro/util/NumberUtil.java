package web.produto.cadastro.util;

import java.util.Optional;

public class NumberUtil {

    public static Optional<Double> parseDouble(String toParse) {
        try {
            return Optional.of(Double.parseDouble(toParse));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
