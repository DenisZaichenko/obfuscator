package org.zaichenko.services.obuscation.impl;

import org.zaichenko.services.obuscation.ObfuscationStrategy;
import org.zaichenko.services.obuscation.Obfuscator;

import java.util.List;

public class ObfuscatorImpl implements Obfuscator {
    private ObfuscationStrategy obfuscationStrategy;
    private List<String> regexs;

    public ObfuscatorImpl(ObfuscationStrategy obfuscationStrategy, List<String> regexs) {
        this.obfuscationStrategy = obfuscationStrategy;
        this.regexs = regexs;
    }

    @Override
    public String obfuscate(String content) {
        return obfuscationStrategy.process(content, regexs);
    }
}
