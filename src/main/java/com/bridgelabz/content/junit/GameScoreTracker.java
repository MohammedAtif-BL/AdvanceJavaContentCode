package com.bridgelabz.content.junit;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GameScoreTracker {

    private Map<String, Integer> playerScores;

    public GameScoreTracker() {
        playerScores = new HashMap<>();
    }

    public void addPlayer(String player) {
        if (!playerScores.containsKey(player)) {
            playerScores.put(player, 0);
        }
    }

    public void recordScore(String player, int score) {
        if (playerScores.containsKey(player)) {
            playerScores.put(player, playerScores.get(player) + score);
        }
    }

    public Optional<Integer> getHighestScore() {
        return playerScores.values().stream().max(Integer::compare);
    }

    public Set<String> getWinners() {
        Optional<Integer> highestScore = getHighestScore();
        if (highestScore.isEmpty()) {
            return Set.of();
        }
        return playerScores.entrySet().stream()
                .filter(entry -> entry.getValue().equals(highestScore.get()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Map<String, Integer> getPlayerScores() {
        return playerScores;
    }
}

