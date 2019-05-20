package cn.soft1841.entity;

/**
 * 菜谱实体类
 */
public class Menus {
    //标题
    private String title;
    //材料
    private String tags;
    //展示图
    private String albums;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAlbums() {
        return albums;
    }

    public void setAlbums(String albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Menus{" + "title='" + title + '\'' + "," +
                " tags='" + tags + '\'' + ", " +
                "albums='" + albums + '\'' + '}';
    }
}
