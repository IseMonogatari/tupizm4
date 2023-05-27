package com.example.Preproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "request")
@NoArgsConstructor
public class Request {
    @Id
    private Integer id;
    @Column(name = "active_request")
    private boolean activeRequest;
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    public Request(boolean activeRequest, User user) {
        this.activeRequest = activeRequest;
        this.user = user;
    }

    public boolean isActiveRequest() {
        return activeRequest;
    }

    public void setActiveRequest(boolean activeRequest) {
        this.activeRequest = activeRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "\nRequest{" +
                "id=" + id +
                ", activeRequest=" + activeRequest +
                '}';
    }
}
