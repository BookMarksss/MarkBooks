package com.example.markbooks.common;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

// Book 구조체 김찬호 바꾼다 고현욱도 바꿈 ㅋㅋㅋㅋㅋㅋㅋ
public class Book {
    private static FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    public String genre;
    public String title;
    public String author;
    public String highlight;
    public String time;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String title, String highlight, String time,String genre,String author) {
        this.title = title;
        this.highlight = highlight;
        this.time = time;
        this.author = author;
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setHighlight(String highlight) { this.highlight = highlight; }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getHighlight() {
        return highlight;
    }

    public String getTime() {
        return time;
    }

    public static ArrayList<String> createList() {
        ArrayList<String> contents = new ArrayList<>();

        fStore.collection("book")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot ds : queryDocumentSnapshots.getDocuments()) {
                            String title = (String) ds.get("title");
                            String author = (String) ds.get("author");
                            String genre = (String) ds.get("genre");
                            if (!contents.contains(title)) {
                                contents.add(title);
                            }
                            if (!contents.contains(author)) {
                                contents.add(author);
                            }
                            if (!contents.contains(genre)) {
                                contents.add(genre);
                            }

                        }
                    }
                });
        return contents;
    }
}
