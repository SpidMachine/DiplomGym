package by.kovalyov.diplomgym.entityes;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coach_fio")
    @NotNull
    @Size(min = 3, max = 50)
    @Pattern(regexp = "/[^А-Яа-яЁё ]/g")
    private String coachFio;

    @Column(name = "user_fio")
    @NotNull
    @Size(min = 3, max = 50)
    @Pattern(regexp = "/[^А-Яа-яЁё ]/g")
    private String userFio;

    @Column(name = "post_time")
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime postTime;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
