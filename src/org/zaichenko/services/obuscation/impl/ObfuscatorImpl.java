package org.zaichenko.services.obuscation.impl;

import org.zaichenko.services.obuscation.ObfuscationStrategy;
import org.zaichenko.services.obuscation.Obfuscator;

import java.util.regex.Pattern;

public class ObfuscatorImpl implements Obfuscator {
    private ObfuscationStrategy obfuscationStrategy;
    private Pattern pattern;

    public ObfuscatorImpl(ObfuscationStrategy obfuscationStrategy, Pattern pattern) {
        this.obfuscationStrategy = obfuscationStrategy;
        this.pattern = pattern;
    }

    @Override
    public String obfuscate(String content) {
        return obfuscationStrategy.process(content, pattern);
    }
}
