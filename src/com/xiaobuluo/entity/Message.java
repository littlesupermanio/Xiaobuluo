package com.xiaobuluo.entity;

public class Message {
    private String type;
    private String content;
    private String icon;
    private String jumpUrl;

    public Message() {
    }

    public Message(String type, String content, String icon, String jumpUrl) {

        this.type = type;
        this.content = content;
        this.icon = icon;
        this.jumpUrl = jumpUrl;
    }

    public static Message successMessage(String content, String jumpUrl)
    {
        Message m = new Message();
        m.type = "success";
        m.icon = "check";
        m.content = content;
        m.jumpUrl = jumpUrl;
        return m;
    }

    public static Message failedMessage(String content, String jumpUrl)
    {
        Message m = new Message();
        m.type = "danger";
        m.icon = "close";
        m.content = content;
        m.jumpUrl = jumpUrl;
        return m;
    }

    public String getJumpUrl() {

        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
