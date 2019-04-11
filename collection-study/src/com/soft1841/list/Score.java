package com.soft1841.list;

public class Score implements Comparable<Score> {
    private String starName;
    private Integer starScore;

    public Score(String starName, Integer starScore) {
        this.starName = starName;
        this.starScore = starScore;
    }

    public Score() {
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public Integer getStarScore() {
        return starScore;
    }

    public void setStarScore(Integer starScore) {
        this.starScore = starScore;
    }

    @Override
    public int compareTo(Score score) {
        return this.getStarScore()-score.getStarScore();
    }
}
