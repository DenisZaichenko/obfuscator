package org.zaichenko.services.obuscation.impl;

import org.zaichenko.services.obuscation.ObfuscationStrategy;
import org.zaichenko.services.obuscation.Obfuscator;

public class ObfuscatorImpl implements Obfuscator {
    private ObfuscationStrategy obfuscationStrategy;
    private String regex;

    public ObfuscatorImpl(ObfuscationStrategy obfuscationStrategy, String regex) {
        this.obfuscationStrategy = obfuscationStrategy;
        this.regex = regex;
    }

    @Override
    public String obfuscate(String content) {
        return obfuscationStrategy.process(content, regex);
    }
}
