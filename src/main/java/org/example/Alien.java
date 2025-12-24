package org.example;

import jakarta.persistence.*;

@Entity
@Table(name="alien_table") //to change the name of the table in database
public class Alien {
    @Id
    private int aid;
    @Column(name="alien_name") // to change the coloumn name in database
    private String aname;

    @Transient
    private String tech;
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }


    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }

}
