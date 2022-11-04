package edu.uptc.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "meets")
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(nullable = false, length = 255)
    private String affair;

    @Column(nullable = false)
    private LocalDateTime dateMeet;

 //   @OneToOne(mappedBy = "meet", cascade = CascadeType.ALL)
 //   private Act act;

    @ManyToOne
    private Room room;

    public Meet() {
    }

    public Meet(String affair, LocalDateTime dateMeet, Room room) {
        this.affair = affair;
        this.dateMeet = dateMeet;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAffair() {
        return affair;
    }

    public void setAffair(String affair) {
        this.affair = affair;
    }

    public LocalDateTime getDateMeet() {
        return dateMeet;
    }

    public void setDateMeet(LocalDateTime dateMeet) {
        this.dateMeet = dateMeet;
    }
/*
    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }
*/
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "id=" + id +
                ", affair='" + affair + '\'' +
                ", dateMeet=" + dateMeet +
          //      ", room= " +room + "\n" +
                '}';
    }
}
