package com.example.email;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class EmailExtractorService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("\\S+@\\S+");

    public List<String> extractEmails(InputStreamReader reader) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            return bufferedReader.lines()
                    .flatMap(line -> EMAIL_PATTERN.matcher(line).results().map(match -> match.group()))
                    .collect(Collectors.toList());
        }
    }
}
