package com.company;

import java.util.Objects;

public class Directory {
    protected String dirname;
    protected String path;

    public Directory(String path, String dirname) {
        this.path = path;
        this.dirname=dirname;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return Objects.equals(dirname, directory.dirname) && Objects.equals(path, directory.path);
    }

    @Override
    public int hashCode() {
        return 31* Objects.hash(dirname, path);
    }

    @Override
    public String toString() {
        return dirname +
                ", path: " + path + ";";
    }
}
