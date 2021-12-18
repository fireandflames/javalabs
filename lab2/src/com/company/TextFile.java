package com.company;

import java.util.Objects;

public class TextFile extends File{
    private StringBuffer content;


    public TextFile(String name, Directory dir)
    {
        super(name,dir);
        this.content=new StringBuffer();
    }

    public void rename(String newName)
    {
        this.name = newName;
    }

    public void addContent(String newContent)
    {
        this.content.append(newContent);
    }

    public void deleteContent()
    {
        this.content.delete(0,this.content.capacity()-1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TextFile textFile = (TextFile) o;
        return Objects.equals(content, textFile.content);
    }

    @Override
    public int hashCode() {
        return 41* Objects.hash(super.hashCode(), content);
    }

    @Override
    public String toString() {
        return "TextFile: " +
                "directory: " + parentDirectory +
                ", name: " + name + ", content: " + content;
    }
}
