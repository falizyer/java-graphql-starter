package by.falizyers.myhome.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UsersEntity implements VersionableEntity<Long>, TrackUpdateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usrs_id")
    private Long id;

    @Column(name = "usrs_email")
    private String email;

    @Column(name = "usrs_password")
    private String password;

    @Column(name = "usrs_cell_phone")
    private Long cellPhone;

    @Column(name = "usrs_creation_date")
    private Date creationDate;

    @Column(name = "usrs_update_date")
    private Date updateDate;

    @Version
    @Column(name = "usrs_version")
    private Integer version;

    @Column(name = "usrs_deleted")
    private boolean deleted;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles_assignment",
            joinColumns = {@JoinColumn(name = "urat_usrs_id", insertable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "urat_urls_id", insertable = false, updatable = false)}
    )
    private List<UserRolesEntity> roles;

    public String creationDateFunc(String value) {
        return value;
    }
}
