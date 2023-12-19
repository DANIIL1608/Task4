package hiber.model;


import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;

    private int series;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }


    public int getPrimaryKey() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public User getUser() {
        return user;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "primaryKey=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                ", user=" + user +
                '}';
    }
}
