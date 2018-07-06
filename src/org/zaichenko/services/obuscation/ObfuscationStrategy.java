package org.zaichenko.services.obuscation;

public interface ObfuscationStrategy {
    String process(String str, String regex);
}
