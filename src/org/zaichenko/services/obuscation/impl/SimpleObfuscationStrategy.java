package org.zaichenko.services.obuscation.impl;

import org.zaichenko.services.obuscation.ObfuscationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleObfuscationStrategy implements ObfuscationStrategy {

    private final String marker;

    public SimpleObfuscationStrategy(String marker) {
        this.marker = marker;
    }

    public SimpleObfuscationStrategy() {
        marker = "<obfuscated>";
    }

    @Override
    public String process(String str, List<String> regexs) {
        for (String regex :
                regexs) {
            Matcher m = Pattern.compile(regex).matcher(str);
            List<String> matches = new ArrayList<>();
            while (m.find()) {
                String subStr = m.group();
                str = str.replace(subStr, marker);
            }
        }
        return str;
    }
}
