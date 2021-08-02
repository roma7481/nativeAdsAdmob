package template.myapplication;

public class Item {

    private String header, content;
    private int drawable;

    public Item(String header, String content, int drawable) {
        this.header = header;
        this.content = content;
        this.drawable = drawable;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public int getDrawable() {
        return drawable;
    }


}

