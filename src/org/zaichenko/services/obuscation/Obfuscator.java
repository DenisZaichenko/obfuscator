package org.zaichenko.services.obuscation;

import java.util.List;

public interface Obfuscator {
    public List<String> obfuscate(List<String> strings);
}
