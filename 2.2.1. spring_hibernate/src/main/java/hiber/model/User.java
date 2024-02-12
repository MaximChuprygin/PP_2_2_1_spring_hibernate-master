package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   public User() {
   }

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public Car getCar() {
      return car;
   }


   @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
   private Car car;

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      User user = (User) o;
      return id == user.id
              && (firstName == user.firstName
              || (firstName != null && firstName.equals(user.getFirstName()))
              && (lastName == user.lastName
              || (lastName != null && lastName.equals(user.getLastName()))
              && (email == user.email
              || (email != null && email.equals(user.getEmail()))
      )));
   }

   @Override
   public int hashCode() {
      int result = 31;
      result = result * 17 + firstName.hashCode();
      result = result * 17 + lastName.hashCode();
      result = result * 17 + email.hashCode();
      return result;

   }
}
