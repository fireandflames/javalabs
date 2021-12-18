package com.company;

import java.util.Objects;

public class File {
    protected String name;
    protected Directory parentDirectory;

    public File(String name, Directory parentDirectory)
    {
        this.name=name;
        this.parentDirectory=parentDirectory;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(name, file.name) && Objects.equals(parentDirectory, file.parentDirectory);
    }

    @Override
    public int hashCode() {
        return 21* Objects.hash(name, parentDirectory);
    }

    @Override
    public String toString() {
        return "File:" +
                "name:'" + name + '\'' +
                ", parentDirectory:" + parentDirectory;
    }
}
