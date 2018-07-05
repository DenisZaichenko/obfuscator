package org.zaichenko.services.obuscation;

import java.util.List;

public interface ObfuscationStrategy {
    public String process(String str, List<String> regex);
}
