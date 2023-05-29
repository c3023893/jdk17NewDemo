package org.example;

public record Record(String username,String password) {
    public Record {
        System.out.println("start to get record");
    }

    @Override
    public String toString() {
        return "Record{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
