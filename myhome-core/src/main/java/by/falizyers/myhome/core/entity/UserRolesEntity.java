package by.falizyers.myhome.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user_roles")
public class UserRolesEntity implements PersistentEntity<Long>, TrackUpdateEntity {

    @Id
    @GeneratedValue
    @Column(name = "urls_id")
    private Long id;

    @Column(name = "urls_name")
    private String name;

    @Column(name = "urls_creation_date")
    private Date creationDate;

    @Column(name = "urls_update_date")
    private Date updateDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "upns_id", insertable = false, updatable = false)
    private List<UserPermissionsEntity> permissions;
}
