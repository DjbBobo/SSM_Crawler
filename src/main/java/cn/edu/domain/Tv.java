package cn.edu.domain;

public class Tv {
    private Integer id;
    private String name;
    private String playUrl;
    private String imageUrl;
    private String score;
    private String mainActor;
    private String latestOrder;
    private String videoCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public String getLatestOrder() {
        return latestOrder;
    }

    public void setLatestOrder(String latestOrder) {
        this.latestOrder = latestOrder;
    }

    public String getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(String videoCount) {
        this.videoCount = videoCount;
    }

    @Override
    public String toString() {
        return "Tv{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playUrl='" + playUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", score='" + score + '\'' +
                ", mainActor='" + mainActor + '\'' +
                ", latestOrder='" + latestOrder + '\'' +
                ", videoCount='" + videoCount + '\'' +
                '}';
    }
}
