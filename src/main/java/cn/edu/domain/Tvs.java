package cn.edu.domain;

public class Tvs {
    private Integer id;
    private Integer tv_id;
    private String playUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTv_id() {
        return tv_id;
    }

    public void setTv_id(Integer tv_id) {
        this.tv_id = tv_id;
    }

    public String getPlayUrl() {
        return playUrl;
    }


    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    @Override
    public String toString() {
        return "Tvs{" +
                "id=" + id +
                ", tv_id=" + tv_id +
                ", playUrl='" + playUrl + '\'' +
                '}';
    }
}
