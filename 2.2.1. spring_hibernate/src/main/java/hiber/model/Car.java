package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    public Car () {
    }
    public Car (String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "user_id", referencedColumnName = "id")
    private User user;


    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }
        if ( o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id
                && ( model == car.model
                || ( model != null && model.equals(car.getModel()))
                && (series == car.series
        ));
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 17 + model.hashCode();
        result = result * 17 + series;
        return result;}

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                ", user=" + user +
                '}';
    }

}
