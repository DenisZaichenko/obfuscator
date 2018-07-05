package org.zaichenko.services.obuscation.impl;

import org.zaichenko.services.obuscation.ObfuscationStrategy;
import org.zaichenko.services.obuscation.Obfuscator;

import java.util.List;
import java.util.stream.Collectors;

public class ObfuscatorImpl implements Obfuscator {
    private ObfuscationStrategy obfuscationStrategy;
    private List<String> regexs;

    public ObfuscatorImpl(ObfuscationStrategy obfuscationStrategy, List<String> regexs) {
        this.obfuscationStrategy = obfuscationStrategy;
        this.regexs = regexs;
    }

    @Override
    public List<String> obfuscate(List<String> strings) {
        return strings.stream().map(s->obfuscationStrategy.process(s,regexs)).collect(Collectors.toList());
    }
}
