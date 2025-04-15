package assignment1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.util.*;

public class WebPageWordCounter {
    public static void main(String[] args) {
        List<String> urlList = readFileLines("urls.txt");
        List<String> wordList = readFileLines("words.txt");
        Map<String, Integer> overallWordCount = new HashMap<>();

        System.out.println("\nWord Count Per URL\n==================");
        for (String url : urlList) {
            Map<String, Integer> urlWordCount = countWordsFromWebPage(url, wordList);
            if (!urlWordCount.isEmpty()) {
                displayTopWords(url, urlWordCount, 3);
                updateTotalWordCount(overallWordCount, urlWordCount);
            }
        }

        System.out.println("=================================");

        System.out.println("\nTotal Word Count Across URLs\n===========================");
        displaySortedWordCount(overallWordCount);
    }

    private static List<String> readFileLines(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.toLowerCase().trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return lines;
    }

    private static Map<String, Integer> countWordsFromWebPage(String url, List<String> wordList) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try {
            Document document = Jsoup.connect(url).get();
            String content = document.text().toLowerCase();
            String[] words = content.split("\\W+");

            for (String word : words) {
                if (wordList.contains(word)) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to retrieve: " + url);
        }
        return wordFrequency;
    }

    private static void displayTopWords(String url, Map<String, Integer> wordCount, int topN) {
        System.out.println(url);
        wordCount.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(topN)
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
        System.out.println();
    }

    private static void updateTotalWordCount(Map<String, Integer> totalWordCount, Map<String, Integer> urlWordCount) {
        for (Map.Entry<String, Integer> entry : urlWordCount.entrySet()) {
            totalWordCount.put(entry.getKey(), totalWordCount.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
    }

    private static void displaySortedWordCount(Map<String, Integer> totalWordCount) {
        totalWordCount.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}