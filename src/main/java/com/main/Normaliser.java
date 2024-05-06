package com.main;

import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Normaliser {

    private final List<String> normalizedJobTitles;

    public Normaliser() {
        this.normalizedJobTitles = new ArrayList<>(Arrays.asList("Architect", "Software Engineer", "Quantity Surveyor", "Accountant"));
    }

    public void addNormalizedJobTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.normalizedJobTitles.add(title);
    }

    public String normalise(String inputTitle) {
        if (inputTitle == null || inputTitle.isEmpty()) {
            throw new IllegalArgumentException("Input title cannot be null or empty.");
        }

        double maxScore = 0.0;
        String bestMatch = "";

        for (String normalizedTitle : normalizedJobTitles) {
            double score = calculateScore(inputTitle, normalizedTitle);
            if (score > maxScore) {
                maxScore = score;
                bestMatch = normalizedTitle;
            }
        }

        return bestMatch;
    }

    // Use Levenshtein distance to calculate the similarity
    private double calculateScore(String inputTitle, String normalizedTitle) {
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        int distance = levenshteinDistance.apply(inputTitle.toLowerCase(), normalizedTitle.toLowerCase());

        // Normalize the distance to a similarity score between 0.0 and 1.0
        int maxLength = Math.max(inputTitle.length(), normalizedTitle.length());
        return 1.0 - ((double) distance / maxLength);
    }
}
