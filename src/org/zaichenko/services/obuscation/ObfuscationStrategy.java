package org.zaichenko.services.obuscation;

import java.util.regex.Pattern;

public interface ObfuscationStrategy {
    String process(String str, Pattern pattern);
}
