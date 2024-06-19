package arturnikytenko.calorieCountingProgram.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import arturnikytenko.calorieCountingProgram.Utilities.Goal;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Setter
@Getter
@Entity
public class UserModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotNull
    @Min(18)
    @Max(150)
    private int age;

    @NotNull
    @Min(1)
    @Max(1000)
    private double weight;

    @NotNull
    @Min(1)
    @Max(300)
    private double height;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Goal goal;

    private Date timeToReachGoal;

    @Min(value = 0, message = "This value should be positive")
    private double weightToChange;

    private String gender;

    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Food> createdFoods = new HashSet<>();

    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<DayModel> createdDays = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "user_dislike",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    @JsonIgnore
    private Set<Food> dislikedFoods = new HashSet<>();


    public UserModel() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return id == userModel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
