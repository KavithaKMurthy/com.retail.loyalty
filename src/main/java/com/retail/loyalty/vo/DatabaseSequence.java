package com.retail.loyalty.vo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "database_sequences")
    public class DatabaseSequence {

        @Id
        private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    private long seq;

        //getters and setters omitted
    }
